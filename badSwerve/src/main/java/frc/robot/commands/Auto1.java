package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Auto1 extends SequentialCommandGroup {
  public Auto1() {
    super(new DriveChoreoPath("path1", true),
        new DriveChoreoPath("path2", false)
    );
  }

  @Override
  public String toString() {
    return "Auto1";
  }
}
