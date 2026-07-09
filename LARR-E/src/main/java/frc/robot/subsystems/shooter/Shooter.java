package frc.robot.subsystems.shooter;

import static edu.wpi.first.units.Units.Value;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.CanID;

public class Shooter extends SubsystemBase {

    private SparkMax m_motorLeader;
    private SparkMax m_motorFollower;

    public Shooter() {
        m_motorLeader = new SparkMax(CanID.SHOOTER_MOTOR_LEADER, MotorType.kBrushless);
        m_motorFollower = new SparkMax(CanID.SHOOTER_MOTOR_FOLLOWER, MotorType.kBrushless);

        m_motorLeader.configure(
                ShooterConstants.MOTOR_CONFIG_LEADER,
                ResetMode.kNoResetSafeParameters,
                PersistMode.kNoPersistParameters);

        m_motorFollower.configure(
                ShooterConstants.MOTOR_CONFIG_FOLLOWER,
                ResetMode.kNoResetSafeParameters,
                PersistMode.kNoPersistParameters);
    }

    public void setSpeed(Dimensionless m_speed) {
        m_motorLeader.set(m_speed.in(Value));
    }

    public void setAxisSpeed(Dimensionless axisSpeed) {
        setSpeed(axisSpeed.times(ShooterConstants.AXIS_MAX_SPEED));
    }

    public void stop() {
        m_motorLeader.stopMotor();
    }
}
