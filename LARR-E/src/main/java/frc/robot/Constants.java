// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.Value;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.units.measure.Dimensionless;

import com.revrobotics.spark.config.SparkMaxConfig;

public final class Constants {

  public static class CAN_ID {
    public static final int FLOOR_MOTOR = 0;

  }

  public static class FLOOR {

    public static final SparkBaseConfig MOTOR_CONFIG = new SparkMaxConfig()
        .idleMode(IdleMode.kCoast)
        .inverted(false)
        .smartCurrentLimit(20, 20);

  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
