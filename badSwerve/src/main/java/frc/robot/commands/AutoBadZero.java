package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoBadZero extends SequentialCommandGroup {
  public AutoBadZero() {
    super(new DriveChoreoPathBadZero("path1", true),
        new DriveChoreoPathBadZero("path2", false)
    );
  }

  @Override
  public String toString() {
    return "Auto1";
  }
}
