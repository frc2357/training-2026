// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.drive.DefaultDrive;
import frc.robot.controls.DriverConstants;
import frc.robot.controls.DriverControls;
import frc.robot.subsystems.drivetrain.CommandSwerveDrivetrain;
import frc.robot.subsystems.drivetrain.TunerConstants;
import frc.robot.subsystems.feeder.Feeder;
import frc.robot.subsystems.floor.Floor;
import frc.robot.subsystems.intakePivot.IntakePivot;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.subsystems.tunnel.Tunnel;

/**
 * The methods in this class are called automatically corresponding to each
 * mode, as described in
 * the TimedRobot documit entation. If you change the name of this class or the
 * package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {

  public static DriverControls driverControls;
  public static Floor floor;
  public static Tunnel tunnel;
  public static Feeder feeder;
  public static IntakePivot intakePivot;
  public static Shooter shooter;
  public static CommandSwerveDrivetrain swerve;

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  public Robot() {
    swerve = TunerConstants.createDrivetrain();
    // m_example = new example();
    floor = new Floor();
    tunnel = new Tunnel();
    feeder = new Feeder();
    intakePivot = new IntakePivot();
    shooter = new Shooter();

    driverControls = new DriverControls(
        new CommandXboxController(DriverConstants.DRIVE_CONTROLLER_PORT));

    swerve.setDefaultCommand(new DefaultDrive());
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items
   * like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {
  }

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {
  }
}
