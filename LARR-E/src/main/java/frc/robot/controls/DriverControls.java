package frc.robot.controls;

import static edu.wpi.first.units.Units.Value;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.intakePivot.IntakePivotAxis;

public class DriverControls {

    private CommandXboxController m_controller;

    public DriverControls(CommandXboxController controller) {
        m_controller = controller;

        mapControls();
    }

    public void mapControls() {
        m_controller.rightTrigger().whileTrue(new IntakePivotAxis(() -> Value.of(m_controller.getRightTriggerAxis())));
        m_controller.leftTrigger().whileTrue(new IntakePivotAxis(() -> Value.of(-m_controller.getLeftTriggerAxis())));
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
