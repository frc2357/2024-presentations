// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutoCommandChooser;
import frc.robot.commands.DriveProportional;
import frc.robot.subsystems.Drive;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private AutoCommandChooser m_chooser;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    Robot.drive = new Drive();

    Robot.controller = new XboxController(Constants.CONTROLLER.DRIVER);

    Robot.drive.setDefaultCommand(new DriveProportional());

    m_chooser = new AutoCommandChooser();
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    //return new AutoDriveCommand(m_driveSub, 1000, 0.25, 0.0);

    //return new AutoDriveCommandGroup(m_driveSub);

    return m_chooser.getSelectedAutoCommand();
  }
}
