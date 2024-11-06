package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

public class LoopLoopOverrun extends Command {

    public LoopLoopOverrun() {}

    @Override
    public void execute() {
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            // Looping a long time
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public String toString() {
        return "Loop Loop Overrun";
    }
}
