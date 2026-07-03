// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Value;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.spark.config.SparkMaxConfig;

public final class Constants {

  public static final class CONTROLLER {
    public static final int DRIVE_CONTROLLER_PORT = 0;
  }

  public static class CAN_ID {
    public static final int FLOOR_MOTOR = 23;
    public static final int TUNNEL_MOTOR = 34;
    public static final int FEEDER_MOTOR = 32;
  }

  public static final class SWERVE {
    public static final AngularVelocity MAX_ANGULAR_VELOCITY = Units.RadiansPerSecond.of((Math.PI * 2) / 1.5);
  }

  public static class FLOOR {

    public static final SparkBaseConfig MOTOR_CONFIG = new SparkMaxConfig()
        .inverted(true)
        .idleMode(IdleMode.kCoast)
        .smartCurrentLimit(20, 20);

    public static final Dimensionless AXIS_MAX_SPEED = Value.of(100);
  }

  public static class TUNNEL {

    public static final SparkBaseConfig MOTOR_CONFIG = new SparkMaxConfig()
        .inverted(true)
        .idleMode(IdleMode.kCoast)
        .smartCurrentLimit(30, 20);

    public static final Dimensionless AXIS_MAX_SPEED = Value.of(100);
  }

  public static class FEEDER {
    public static final SparkBaseConfig MOTOR_CONFIG = new SparkMaxConfig()
        .inverted(true)
        .idleMode(IdleMode.kCoast)
        .smartCurrentLimit(20, 20);

    public static final Dimensionless AXIS_MAX_SPEED = Value.of(100);
  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
