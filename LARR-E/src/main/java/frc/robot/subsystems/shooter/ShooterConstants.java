package frc.robot.subsystems.shooter;

import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.units.measure.Dimensionless;

import static edu.wpi.first.units.Units.Percent;
import static edu.wpi.first.units.Units.Value;

import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import frc.robot.constants.CanID;

public class ShooterConstants {

        public static final SparkBaseConfig LEFT_MOTOR_CONFIG = new SparkMaxConfig()
                        .idleMode(IdleMode.kCoast)
                        .inverted(false)
                        .smartCurrentLimit(30, 30)
                        .voltageCompensation(12);

        public static final SparkBaseConfig RIGHT_MOTOR_CONFIG = new SparkMaxConfig().apply(LEFT_MOTOR_CONFIG)
                        .follow(CanID.LEFT_SHOOTER_MOTOR, true);

        public static final Dimensionless AXIS_MAX_SPEED = Percent.of(80);
}
