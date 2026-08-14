package frc.robot.subsystems.shooter;

import static edu.wpi.first.units.Units.Value;
import com.revrobotics.spark.SparkMax;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.CanID;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.controls.StrictFollower;

public class Shooter extends SubsystemBase {

    public static final TalonFX m_leftMotor = new TalonFX(CanID.LEFT_SHOOTER_MOTOR);
    public static final TalonFX m_rightMotor = new TalonFX(CanID.RIGHT_SHOOTER_MOTOR);

    public Shooter() {
        m_rightMotor.setControl(new StrictFollower(m_leftMotor.getDeviceID()));
        TalonFXConfiguration leftConfig = new TalonFXConfiguration();
        TalonFXConfiguration rightConfig = new TalonFXConfiguration();
        leftConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        leftConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
        rightConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        rightConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        m_leftMotor.getConfigurator().apply(leftConfig);
        m_rightMotor.getConfigurator().apply(rightConfig);
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
