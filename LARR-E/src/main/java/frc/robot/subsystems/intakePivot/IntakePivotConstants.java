package frc.robot.subsystems.intakePivot;

import static edu.wpi.first.units.Units.Percent;
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

    public static final Dimensionless AXIS_MAX_SPEED = Percent.of(10);
}
