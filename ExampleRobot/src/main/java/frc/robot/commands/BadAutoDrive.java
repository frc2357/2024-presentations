package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class BadAutoDrive extends Command {

    public BadAutoDrive() {
        addRequirements(Robot.drive);
    }

    @Override
    public void execute() {
        Robot.drive.driveProportional(0.25, 0.0);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        Robot.drive.driveProportional(0, 0.25);

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
        }

        Robot.drive.driveProportional(0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public String toString() {
        return "Bad Auto Drive";
    }
}
