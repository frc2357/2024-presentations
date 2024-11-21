package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private CANSparkMax m_motor;

  public Intake() {
    m_motor = new CANSparkMax(Constants.CAN_ID.INTAKE, MotorType.kBrushless);
  }

  public void set(double percent) {
    m_motor.set(percent);
  }

  public void stop() {
    set(0);
  }

}
