package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Value;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import frc.robot.Constants.CAN_ID;
import frc.robot.Constants.FEEDER;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Feeder extends SubsystemBase {

    private SparkMax m_motor;

    public Feeder() {

        m_motor = new SparkMax(CAN_ID.FEEDER_MOTOR, MotorType.kBrushless);

        m_motor.configure(
                FEEDER.MOTOR_CONFIG,
                ResetMode.kNoResetSafeParameters,
                PersistMode.kNoPersistParameters);
    }

    public void setSpeed(Dimensionless m_speed) {
        m_motor.set(m_speed.in(Value));
    }

    public void setAxisSpeed(Dimensionless axisSpeed) {
        setSpeed(axisSpeed.times(FEEDER.AXIS_MAX_SPEED));
    }

    public void stop() {
        m_motor.stopMotor();
    }
}
