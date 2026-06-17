package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Value;

import java.util.function.Supplier;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import frc.robot.Constants.TUNNEL;
import frc.robot.Constants.CAN_ID;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Tunnel extends SubsystemBase {

    private SparkMax m_motor;

    public Tunnel() {
        m_motor = new SparkMax(CAN_ID.TUNNEL_MOTOR, MotorType.kBrushless);

        m_motor.configure(
                frc.robot.Constants.TUNNEL.MOTOR_CONFIG,
                ResetMode.kNoResetSafeParameters,
                PersistMode.kNoPersistParameters);
    }

    public void setSpeed(Dimensionless m_speed) {
        m_motor.set(m_speed.in(Value));
    }

    public void setAxisSpeed(Dimensionless axisSpeed) {
        setSpeed(axisSpeed.times(TUNNEL.AXIS_MAX_SPEED));

    }

    public void stop() {
        m_motor.stopMotor();
    }

}
