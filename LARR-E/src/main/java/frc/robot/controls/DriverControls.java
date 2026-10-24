package frc.robot.controls;

import static edu.wpi.first.units.Units.Value;
import static edu.wpi.first.units.Units.Percent;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.feeder.FeederSetSpeed;
import frc.robot.commands.hood.HoodSetSpeed;
import frc.robot.commands.intakePivot.IntakeDeploy;
import frc.robot.commands.intakePivot.IntakePivotAxis;
import frc.robot.commands.intakeRunner.IntakeRunnerAxis;
import frc.robot.commands.intakeRunner.IntakeRunnerSetSpeed;
import frc.robot.commands.kicker.KickerSetSpeed;
import frc.robot.commands.scoring.Feeding;
import frc.robot.commands.shooter.ShooterSetSpeed;
import frc.robot.commands.shooter.ShooterStop;
import frc.robot.commands.tunnel.TunnelSetSpeed;
import frc.robot.controls.util.RumbleInterface;

public class DriverControls implements RumbleInterface {

    private CommandXboxController m_controller;

    private Dimensionless m_deadband;

    public DriverControls(CommandXboxController controller, Dimensionless deadband) {
        m_controller = controller;
        m_deadband = deadband;
        mapControls();
    }

    public void mapControls() {
        // m_controller.rightTrigger().whileTrue(new IntakePivotAxis(() ->
        // Value.of(m_controller.getRightTriggerAxis())));
        m_controller.leftTrigger().whileTrue(new IntakePivotAxis(() -> Value.of(-m_controller.getLeftTriggerAxis())));

        m_controller.a().onTrue(new ShooterSetSpeed(Percent.of(50)));
        m_controller.x().onTrue(new ShooterStop());
        m_controller.b().onTrue(new IntakeDeploy());

        m_controller.rightBumper().whileTrue(new Feeding());
        m_controller.rightTrigger().whileTrue(new IntakeRunnerAxis(() -> Value.of(m_controller.getRightTriggerAxis())));
    }

    public Dimensionless getLeftX() {
        return Value.of(m_controller.getLeftX());
    }

    public Dimensionless getLeftY() {
        return Value.of(m_controller.getLeftY());
    }

    public Dimensionless getRotation() {
        return Value.of(-m_controller.getRightX());
    }

    public double deadband(double value, double deadband) {
        if (Math.abs(value) > deadband) {
            if (value > 0.0) {
                return (value - deadband) / (1.0 - deadband);
            } else {
                return (value + deadband) / (1.0 - deadband);
            }
        } else {
            return 0.0;
        }
    }

    @Override
    public void setRumble(Dimensionless intensity) {
        m_controller.setRumble(RumbleType.kBothRumble, intensity.in(Value));
    }
}
