package frc.robot.subsystems.hood;

import static edu.wpi.first.units.Units.Percent;

import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.units.measure.Dimensionless;

public class HoodConstants {

    public static final SparkBaseConfig MOTOR_CONFIG = new SparkMaxConfig()
            .inverted(false)
            .idleMode(IdleMode.kBrake)
            .smartCurrentLimit(10, 10);

    public static final Dimensionless AXIS_MAX_SPEED = Percent.of(5);

}
