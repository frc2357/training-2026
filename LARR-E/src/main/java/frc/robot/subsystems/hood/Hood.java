package frc.robot.subsystems.hood;

import static edu.wpi.first.units.Units.Value;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.CanID;

public class Hood extends SubsystemBase {

    private SparkMax m_motor;

    public Hood() {
        m_motor = new SparkMax(CanID.HOOD_MOTOR, MotorType.kBrushless);

        m_motor.configure(
                HoodConstants.MOTOR_CONFIG,
                ResetMode.kNoResetSafeParameters,
                PersistMode.kNoPersistParameters);
    }

    public void setSpeed(Dimensionless m_speed) {
        m_motor.set(m_speed.in(Value));
    }

    public void setAxisSpeed(Dimensionless axisSpeed) {
        setSpeed(axisSpeed.times(HoodConstants.AXIS_MAX_SPEED));
    }

    public void stop() {
        m_motor.stopMotor();
    }
}
