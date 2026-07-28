package frc.robot.subsystems.kicker;

import static edu.wpi.first.units.Units.Percent;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.units.measure.Dimensionless;
import com.revrobotics.spark.config.SparkMaxConfig;

public class KickerConstants {

    public static final SparkBaseConfig MOTOR_CONFIG = new SparkMaxConfig()
            .inverted(true)
            .idleMode(IdleMode.kCoast)
            .smartCurrentLimit(20, 20);

    public static final Dimensionless AXIS_MAX_SPEED = Percent.of(100);

}
