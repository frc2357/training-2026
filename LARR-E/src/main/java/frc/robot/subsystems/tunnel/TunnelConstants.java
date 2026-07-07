package frc.robot.subsystems.tunnel;

import static edu.wpi.first.units.Units.Value;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.units.measure.Dimensionless;

public class TunnelConstants {

    public static final SparkBaseConfig MOTOR_CONFIG = new SparkMaxConfig()
            .inverted(true)
            .idleMode(IdleMode.kCoast)
            .smartCurrentLimit(30, 20);

    public static final Dimensionless AXIS_MAX_SPEED = Value.of(100);
}
