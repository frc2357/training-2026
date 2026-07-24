package frc.robot.subsystems.intakeRunner;

import static edu.wpi.first.units.Units.Percent;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.controls.Follower;
import frc.robot.constants.CanID;

public class IntakeRunnerConstants {

    public static final TalonFX LEFT_INTAKE_MOTOR = new TalonFX(CanID.LEFT_INTAKE_MOTOR);
    public static final TalonFX RIGHT_INTAKE_MOTOR = new TalonFX(CanID.RIGHT_INTAKE_MOTOR);

    public static final Dimensionless AXIS_MAX_SPEED = Percent.of(80);
}
