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

    private SparkMax m_leftMotor;
    private SparkMax m_rightMotor;

    public Shooter() {
        m_leftMotor = new SparkMax(CanID.LEFT_SHOOTER_MOTOR, MotorType.kBrushless);
        m_rightMotor = new SparkMax(CanID.RIGHT_SHOOTER_MOTOR, MotorType.kBrushless);

        m_leftMotor.configure(
                ShooterConstants.LEFT_MOTOR_CONFIG,
                ResetMode.kNoResetSafeParameters,
                PersistMode.kNoPersistParameters);

        m_rightMotor.configure(
                ShooterConstants.RIGHT_MOTOR_CONFIG,
                ResetMode.kNoResetSafeParameters,
                PersistMode.kNoPersistParameters);
    }

    public void setSpeed(Dimensionless m_speed) {
        m_leftMotor.set(m_speed.in(Value));
    }

    public void setAxisSpeed(Dimensionless axisSpeed) {
        setSpeed(axisSpeed.times(ShooterConstants.AXIS_MAX_SPEED));
    }

    public void stop() {
        m_leftMotor.stopMotor();
    }
}
