package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoBadStartPose extends SequentialCommandGroup {
  public AutoBadStartPose() {
    super(new DriveChoreoPath("path1", false),
        new DriveChoreoPath("path2", false)
    );
  }

  @Override
  public String toString() {
    return "Auto1";
  }
}
