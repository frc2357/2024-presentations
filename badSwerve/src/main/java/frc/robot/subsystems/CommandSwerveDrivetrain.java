package frc.robot.subsystems;

import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrain;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Class that extends the Phoenix SwerveDrivetrain class and implements subsystem so it can be used
 * in command-based projects easily.
 */
public class CommandSwerveDrivetrain extends SwerveDrivetrain implements Subsystem {

  private final SwerveRequest.ApplyChassisSpeeds chassisSpeedRequest =
      new SwerveRequest.ApplyChassisSpeeds();

  private final SwerveRequest.FieldCentric fieldRelative =
      new SwerveRequest.FieldCentric().withDriveRequestType(DriveRequestType.Velocity);

  private final SwerveRequest.RobotCentric robotRelative =
      new SwerveRequest.RobotCentric().withDriveRequestType(DriveRequestType.Velocity);

  public CommandSwerveDrivetrain(
      SwerveDrivetrainConstants driveTrainConstants,
      double OdometryUpdateFrequency,
      SwerveModuleConstants... modules) {
    super(driveTrainConstants, OdometryUpdateFrequency, modules);
  }

  public CommandSwerveDrivetrain(
      SwerveDrivetrainConstants driveTrainConstants, SwerveModuleConstants... modules) {
    this(driveTrainConstants, 0, modules);
  }

  public void applyRequest(Supplier<SwerveRequest> requestSupplier) {
    setControl(requestSupplier.get());
  }
  
  /**
   * The method to use for robot relative driving.
   *
   * @param velocityXSpeedMetersPerSecond The desired speed on the X axis in meters per second.
   * @param velocityYSpeedMetersPerSecond The desired speed on the X axis in meters per second.
   * @param rotationRateRadiansPerSecond The desired rotation rate in radians per second.
   */
  public void driveRobotRelative(
      double velocityXMetersPerSecond,
      double velocityYMetersPerSecond,
      double rotationRateRadiansPerSecond) {
    applyRequest(
        () ->
            robotRelative
                .withVelocityX(velocityXMetersPerSecond)
                .withVelocityY(velocityYMetersPerSecond)
                .withRotationalRate(rotationRateRadiansPerSecond));
  }

  /**
   * The method to use for field relative driving.
   *
   * @param velocityXSpeedMetersPerSecond The desired speed on the X axis in meters per second.
   * @param velocityYSpeedMetersPerSecond The desired speed on the X axis in meters per second.
   * @param rotationRateRadiansPerSecond The desired rotation rate in radians per second.
   */
  public void driveFieldRelative(
      double velocityXMetersPerSecond,
      double velocityYMetersPerSecond,
      double rotationRateRadiansPerSecond) {
    applyRequest(
        () ->
            fieldRelative
                .withVelocityX(velocityXMetersPerSecond)
                .withVelocityY(velocityYMetersPerSecond)
                .withRotationalRate(rotationRateRadiansPerSecond));
  }

  /**
   * @return A list of module positions in the order Front Left, Front Right, Back Left, Back Right
   */
  public SwerveModulePosition[] getModulePositions() {
    return super.m_modulePositions;
  }

  /**
   * @return A list of module states in the order Front Left, Front Right, Back Left, Back Right
   */
  public SwerveModuleState[] getModuleStates() {
    return super.getState().ModuleStates;
  }

  /**
   * @return A list of module targets in the order Front Left, Front Right, Back Left, Back Right
   */
  public SwerveModuleState[] getModuleTargets() {
    return super.getState().ModuleTargets;
  }

  public Pose2d getPose() {
    return super.getState().Pose;
  }

  private SwerveDriveKinematics getKinematics() {
    return super.m_kinematics;
  }

  public void zeroGyro(boolean flip) {
    StatusCode code = super.getPigeon2().setYaw(flip ? 180 : 0);
    System.out.println("[GYRO] Zeroed to " + (flip ? 180 : 0) + ": " + code.toString());
  }

  public void resetPose() {
    setPose(new Pose2d(0, 0, new Rotation2d()));
  }

  public void stopMotorsIntoX() {
    applyRequest(() -> new SwerveRequest.SwerveDriveBrake());
  }

  /** Stops the motors in a way that should make them not jingle. */
  public void stopMotors() {
    driveFieldRelative(0, 0, 0);
    for (SwerveModule module : super.Modules) {
      module.getDriveMotor().stopMotor(); // anti-jingle
      module.getSteerMotor().stopMotor(); // remove to bring back the jingle (dont do it)
    }
  }

  public void setPose(Pose2d poseToSet) {
    super.seedFieldRelative(poseToSet);
  }

  public void setPoseAndGyro(Pose2d poseToSet) {
    super.seedFieldRelative(poseToSet);
    super.m_pigeon2.setYaw(poseToSet.getRotation().getDegrees());
  }

  public void setPose3D(Pose3d poseToSet) {
    super.seedFieldRelative(poseToSet.toPose2d());
    super.getPigeon2().setYaw(Units.radiansToDegrees(poseToSet.getRotation().getAngle()));
  }

  /**
   * @return A ChassisSpeeds Consumer which applies a feedforward to its inputs.
   */
  public Consumer<ChassisSpeeds> getChassisSpeedsConsumer() {
    return new Consumer<ChassisSpeeds>() {
      @Override
      public void accept(ChassisSpeeds speeds) {
        SwerveModuleState[] moduleStates = getKinematics().toSwerveModuleStates(speeds);
        for (SwerveModuleState state : moduleStates) {
          state.speedMetersPerSecond += Constants.SWERVE.STATIC_FEEDFORWARD_METERS_PER_SECOND;
        }
        setControl(chassisSpeedRequest.withSpeeds(getKinematics().toChassisSpeeds(moduleStates)));
      }
    };
  }

  /**
   * Returns the current field relative speeds but in a ChassisSpeeds object.
   *
   * @return the current field relative speeds in a ChassisSpeeds object.
   */
  public ChassisSpeeds getFieldRelativeChassisSpeeds() {
    ChassisSpeeds chassisSpeeds = getKinematics().toChassisSpeeds(getModuleStates());
    return chassisSpeeds;
  }

  /**
   * Returns the current robot relative speeds but in a ChassisSpeeds object.
   *
   * @return the current robot relative speeds in a ChassisSpeeds object.
   */
  public ChassisSpeeds getRobotRelativChassisSpeeds() {
    var chassisSpeeds =
        ChassisSpeeds.fromFieldRelativeSpeeds(
            getFieldRelativeChassisSpeeds(), getRotation3d().toRotation2d());
    return chassisSpeeds;
  }
}
