package frc.robot.subsystems.intakePivot;

import static edu.wpi.first.units.Units.Value;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.units.measure.Dimensionless;
import frc.robot.constants.CanID;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.controls.Follower;
import frc.robot.constants.CanID;

public class IntakePivotConstants {

    public static final TalonFX INTAKE_PIVOT_MOTOR = new TalonFX(CanID.INTAKE_PIVOT_MOTOR);

    private void configureMotor() {
        TalonFXConfiguration INTAKE_PIVOT_MOTOR_CONFIG = new TalonFXConfiguration();
        INTAKE_PIVOT_MOTOR_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        INTAKE_PIVOT_MOTOR_CONFIG.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

        INTAKE_PIVOT_MOTOR.getConfigurator().apply(INTAKE_PIVOT_MOTOR_CONFIG);
    }

    public static final Dimensionless AXIS_MAX_SPEED = Value.of(30);
}
