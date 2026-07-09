package frc.robot.controls;

import static edu.wpi.first.units.Units.Value;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.feeder.FeederSetSpeed;
import frc.robot.commands.intakePivot.IntakePivotAxis;
import frc.robot.commands.shooter.ShooterSetSpeed;
import frc.robot.commands.shooter.ShooterStop;
import frc.robot.commands.tunnel.TunnelSetSpeed;

public class DriverControls {

    private CommandXboxController m_controller;

    public DriverControls(CommandXboxController controller) {
        m_controller = controller;

        mapControls();
    }

    public void mapControls() {
        m_controller.rightTrigger().whileTrue(new IntakePivotAxis(() -> Value.of(m_controller.getRightTriggerAxis())));
        m_controller.leftTrigger().whileTrue(new IntakePivotAxis(() -> Value.of(-m_controller.getLeftTriggerAxis())));

        m_controller.a().onTrue(new ShooterSetSpeed(Value.of(50)));
        m_controller.x().onTrue(new ShooterStop());
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
}
