package frc.robot.controls;

import static edu.wpi.first.units.Units.Value;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class DriverControls {

    private CommandXboxController m_controller;

    public DriverControls(CommandXboxController controller) {
        m_controller = controller;

        mapControls();
    }

    public void mapControls() {
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
