package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;

public class AutoCommandChooser {
    private Command[] m_autoCommands;
    private SendableChooser<Command> m_chooser;

    public AutoCommandChooser() {

        DigitalInput wallSensorIn = new DigitalInput(Constants.DIO.WALL_SENSOR);
        BooleanSupplier wallSensor = () -> {
            return !wallSensorIn.get();
        };

        m_autoCommands = new Command[] {
                new AutoDrive(1000, 0.25, 0),
                new AutoDriveGroup(),
                AutoStopDrive.createAutoStopDriveCommand(2000, -0.2, 0.0, wallSensor),
                new BadAutoDrive(),
                new LoopLoopOverrun(),
                new NetworkLoopOverrun(),
        };

        m_chooser = new SendableChooser<>();

        m_chooser.setDefaultOption("None", new WaitCommand(0));
        for (Command autoCommand : m_autoCommands) {
            m_chooser.addOption(autoCommand.toString(), autoCommand);
        }

        SmartDashboard.putData("Auto chooser", m_chooser);
    }

    public Command getSelectedAutoCommand() {
        return m_chooser.getSelected();
    }
}