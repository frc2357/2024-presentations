package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class AutoDrive extends Command {

    private double m_timeMillis, m_turn, m_speed;
    private Timer m_timer;

    public AutoDrive(double timeMillis, double speed, double turn) {
        m_timeMillis = timeMillis;
        m_turn = turn;
        m_speed = speed;

        m_timer = new Timer();
        addRequirements(Robot.drive);
    }

    @Override
    public void initialize() {
        Robot.drive.driveProportional(m_speed, m_turn);
        m_timer.start();
    }

    @Override
    public boolean isFinished() {
        return m_timer.hasElapsed(m_timeMillis / 1000);
    }

    @Override
    public void end(boolean interrupted) {
        Robot.drive.driveProportional(0.0, 0.0);
    }

    @Override
    public String toString() {
        return "Auto Drive";
    }
}