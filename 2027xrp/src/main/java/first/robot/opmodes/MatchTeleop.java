// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot.opmodes;

import static org.wpilib.units.Units.Value;

import org.wpilib.opmode.PeriodicOpMode;
import org.wpilib.opmode.Teleop;
import first.robot.Robot;

@Teleop
public class MatchTeleop extends PeriodicOpMode {

  /** The Robot instance is passed into the opmode via the constructor. */
  public MatchTeleop() {
    System.out.println("opmode constructed");
    ConfigureButtonBindings();
    Robot.drive.setDefaultCommand(Robot.drive.arcadeDrive(() -> Value.of(Robot.driverController.getLeftY()),
        () -> Value.of(Robot.driverController.getRightX())));
  }

  public void ConfigureButtonBindings() {

  }

  @Override
  public void disabledPeriodic() {
    /* Called periodically (on every DS packet) while the robot is disabled. */
  }

  @Override
  public void start() {
    /* Called once when the robot is enabled. */
  }

  @Override
  public void periodic() {
    /* Called periodically (set time interval) while the robot is enabled. */
  }

  @Override
  public void end() {
    /* Called when the robot is disabled (after previously being enabled). */
  }

  @Override
  public void close() {
    /*
     * Called when the opmode is de-selected / no additional methods will be called.
     */
  }
}
