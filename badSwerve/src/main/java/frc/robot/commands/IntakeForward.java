package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class IntakeForward extends Command {
  
  public IntakeForward() {
    addRequirements(Robot.intake);
  }

  @Override
  public void execute() {
    Robot.intake.set(0.25);
  } 

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    Robot.intake.stop();
  }
}
