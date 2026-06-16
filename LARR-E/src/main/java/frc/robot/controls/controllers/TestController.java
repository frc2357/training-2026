package frc.robot.controls.controllers;

import static edu.wpi.first.units.Units.Value;

import java.util.function.Supplier;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.floor.FloorAxis;
import frc.robot.commands.tunnel.TunnelAxis;

public class TestController {

    private CommandXboxController m_controller;

    public TestController(CommandXboxController controller) {
        m_controller = controller;
        mapControls();
    }

    public void mapControls() {
        m_controller.a().onTrue(new TunnelAxis(this::getLeftX));
    }

    public Dimensionless getLeftX() {
        return Value.of(m_controller.getLeftX());
    }
}
