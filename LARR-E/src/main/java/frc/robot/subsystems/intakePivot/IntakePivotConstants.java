package frc.robot.subsystems.intakePivot;

import static edu.wpi.first.units.Units.Value;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.units.measure.Dimensionless;

public class IntakePivotConstants {

    public static final SparkBaseConfig MOTOR_CONFIG = new SparkMaxConfig()
            .inverted(true)
            .idleMode(IdleMode.kBrake)
            .smartCurrentLimit(40, 20);

    public static final Dimensionless AXIS_MAX_SPEED = Value.of(30);
}
