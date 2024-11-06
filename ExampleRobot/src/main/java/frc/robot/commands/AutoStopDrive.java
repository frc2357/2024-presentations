package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;

public class AutoStopDrive {
    public static Command createAutoStopDriveCommand(double timeMillis,
            double speed, double turn, BooleanSupplier stopper) {
        return new AutoDrive(timeMillis, speed, turn).until(stopper);
    }
}
