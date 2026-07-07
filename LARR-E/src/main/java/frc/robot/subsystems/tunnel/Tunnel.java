package frc.robot.subsystems.tunnel;

import static edu.wpi.first.units.Units.Value;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.CanID;

public class Tunnel extends SubsystemBase {

    private SparkMax m_motor;

    public Tunnel() {
        m_motor = new SparkMax(CanID.TUNNEL_MOTOR, MotorType.kBrushless);

        m_motor.configure(
                TunnelConstants.MOTOR_CONFIG,
                ResetMode.kNoResetSafeParameters,
                PersistMode.kNoPersistParameters);
    }

    public void setSpeed(Dimensionless m_speed) {
        m_motor.set(m_speed.in(Value));
    }

    public void setAxisSpeed(Dimensionless axisSpeed) {
        setSpeed(axisSpeed.times(TunnelConstants.AXIS_MAX_SPEED));

    }

    public void stop() {
        m_motor.stopMotor();
    }

}
