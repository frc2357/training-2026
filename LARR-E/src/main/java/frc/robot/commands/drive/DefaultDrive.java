package frc.robot.commands.drive;

import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.Value;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.drivetrain.TunerConstants;
import frc.robot.subsystems.drivetrain.SwerveConstants;

public class DefaultDrive extends Command {

    private static final double m_speedAt12VoltMPS = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond);

    public DefaultDrive() {
        addRequirements(Robot.swerve);
    }

    @Override
    public void execute() {
        double x = (Robot.driverControls.getLeftX().in(Value));
        double y = (Robot.driverControls.getLeftY().in(Value));
        double rotation = (Robot.driverControls.getRotation().in(Value));

        Robot.swerve.driveFieldRelative(
                y * m_speedAt12VoltMPS,
                x * m_speedAt12VoltMPS,
                rotation * SwerveConstants.SWERVE.MAX_ANGULAR_VELOCITY.in(RadiansPerSecond)

        );
    }

    @Override
    public void end(boolean interrupted) {
    }
}
