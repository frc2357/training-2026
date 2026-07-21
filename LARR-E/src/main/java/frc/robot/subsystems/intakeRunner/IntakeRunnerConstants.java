package frc.robot.subsystems.intakeRunner;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.controls.Follower;
import frc.robot.constants.CanID;

public class IntakeRunnerConstants {

    public static final TalonFX LEFT_INTAKE_MOTOR = new TalonFX(CanID.LEFT_INTAKE_MOTOR, "rio");
    public static final TalonFX RIGHT_INTAKE_MOTOR = new TalonFX(CanID.RIGHT_INTAKE_MOTOR, "rio");

    public IntakeRunnerConstants() {

    }

    private void configureMotor() {
        TalonFXConfiguration LEFT_INTAKE_MOTOR_CONFIG = new TalonFXConfiguration();

        LEFT_INTAKE_MOTOR_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        LEFT_INTAKE_MOTOR_CONFIG.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

        LEFT_INTAKE_MOTOR.getConfigurator().apply(LEFT_INTAKE_MOTOR_CONFIG);

        RIGHT_INTAKE_MOTOR.setControl(new Follower(LEFT_INTAKE_MOTOR.getDescription().getDeviceID(), true));

        // Follower followerRequest = new Follower(LEFT_INTAKE_MOTOR.getDeviceID(),
        // true);
        // RIGHT_INTAKE_MOTOR.setControl(followerRequest);
    }
}
