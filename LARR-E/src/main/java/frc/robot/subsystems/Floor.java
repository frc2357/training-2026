package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Value;

import java.util.function.Supplier;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CAN_ID;
import frc.robot.Constants.FLOOR;

public class Floor extends SubsystemBase {

    private SparkMax m_motor;

    public Floor() {
        m_motor = new SparkMax(CAN_ID.FLOOR_MOTOR, MotorType.kBrushless);

        m_motor.configure(
                frc.robot.Constants.FLOOR.MOTOR_CONFIG,
                ResetMode.kNoResetSafeParameters,
                PersistMode.kNoPersistParameters);
    }

    public void setSpeed(Supplier<Dimensionless> m_speed) {
        m_motor.set(m_speed.get().in(Value));
    }

    public void setAxisSpeed(double axisSpeed) {
        axisSpeed *= FLOOR.AXIS_MAX_SPEED;
    }

    public void stop() {
        m_motor.stopMotor();
    }
}
