package frc.robot.subsystems.intakePivot;

import static edu.wpi.first.units.Units.Value;
import com.revrobotics.spark.SparkMax;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.CanID;
import frc.robot.subsystems.intakePivot.IntakePivotConstants;

public class IntakePivot extends SubsystemBase {

    private TalonFX m_motor;
    private final DutyCycleOut m_dutyCycle = new DutyCycleOut(0);

    public IntakePivot() {
        m_motor = IntakePivotConstants.INTAKE_PIVOT_MOTOR;
    }

    public void setSpeed(Dimensionless m_speed) {
        m_motor.setControl(m_dutyCycle.withOutput(m_speed.in(Value)));
    }

    public void setAxisSpeed(Dimensionless axisSpeed) {
        setSpeed(axisSpeed.times(IntakePivotConstants.AXIS_MAX_SPEED));
    }

    public void stop() {
        m_motor.set(0.0);
    }

}