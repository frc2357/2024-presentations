package frc.robot.subsystems;

import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {

  private TalonFX m_leftFalconLeader;
  private TalonFX m_rightFalconLeader;

  private TalonFX m_leftFalconFollower;
  private TalonFX m_rightFalconFollower;

  public Drive() {
    m_leftFalconLeader = new TalonFX(Constants.CAN_ID.DRIVE_MOTOR_LEFT_1);

    m_leftFalconFollower = new TalonFX(Constants.CAN_ID.DRIVE_MOTOR_LEFT_2);

    m_rightFalconLeader = new TalonFX(Constants.CAN_ID.DRIVE_MOTOR_RIGHT_1);

    m_rightFalconFollower = new TalonFX(Constants.CAN_ID.DRIVE_MOTOR_RIGHT_2);

    /* Configure the devices */
    TalonFXConfiguration leftConfiguration = new TalonFXConfiguration();
    TalonFXConfiguration rightConfiguration = new TalonFXConfiguration();

    /*
     * User can optionally change the configs or leave it alone to perform a factory
     * default
     */
    leftConfiguration.MotorOutput.Inverted = Constants.DRIVE.LEFT_INVERTED;
    rightConfiguration.MotorOutput.Inverted = Constants.DRIVE.RIGHT_INVERTED;

    leftConfiguration.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    rightConfiguration.MotorOutput.NeutralMode = NeutralModeValue.Brake;

    m_leftFalconLeader.getConfigurator().apply(leftConfiguration);
    m_leftFalconFollower.getConfigurator().apply(leftConfiguration);

    m_rightFalconLeader.getConfigurator().apply(rightConfiguration);
    m_rightFalconFollower.getConfigurator().apply(rightConfiguration);
  }

  public void driveProportionalWithStick(double speed, double turn) {
    speed = -1 * MathUtil.applyDeadband(speed, Constants.DRIVE.DEADBAND);
    turn = MathUtil.applyDeadband(turn, Constants.DRIVE.DEADBAND);
    driveProportional(speed, turn);
  }

  /**
   * 
   * @param speed -1 to 1
   * @param turn  -1 to 1
   */
  public void driveProportional(double speed, double turn) {
    double leftProportion = speed + turn;
    double rightProportion = speed - turn;

    leftProportion = MathUtil.clamp(leftProportion, -1.0, 1.0);

    rightProportion = MathUtil.clamp(rightProportion, -1.0, 1.0);

    m_leftFalconLeader.set(leftProportion);
    m_rightFalconLeader.set(rightProportion);
  }
}
