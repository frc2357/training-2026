package frc.robot.subsystems.intakeRunner;

import static edu.wpi.first.units.Units.Value;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.controls.Follower;
import frc.robot.constants.CanID;
import frc.robot.constants.CanID;

public class IntakeRunner extends SubsystemBase {

    public static final TalonFX m_leftMotor = new TalonFX(CanID.LEFT_INTAKE_MOTOR);
    public static final TalonFX m_rightMotor = new TalonFX(CanID.RIGHT_INTAKE_MOTOR);

    public IntakeRunner() {
        TalonFXConfiguration config = new TalonFXConfiguration();

        config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

        m_leftMotor.getConfigurator().apply(config);
        m_rightMotor.getConfigurator().apply(config);
    }

    public void setSpeed(Dimensionless m_speed) {
        m_leftMotor.set(m_speed.in(Value));
        m_rightMotor.set(m_speed.in(Value));
    }

    public void setAxisSpeed(Dimensionless axisSpeed) {
        setSpeed(axisSpeed.times(IntakeRunnerConstants.AXIS_MAX_SPEED));
    }

    public void stop() {
        m_leftMotor.set(0);
        m_rightMotor.set(0);
    }
}
