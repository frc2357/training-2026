package frc.robot.controls;

import static edu.wpi.first.units.Units.Value;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.controls.util.RumbleInterface;

public class CoDriverControls implements RumbleInterface {

    private CommandXboxController m_controller;

    private Dimensionless m_deadband;

    public CoDriverControls(CommandXboxController controller, Dimensionless deadband) {
        m_controller = controller;
        m_deadband = deadband;

        mapControls();
    }

    public void mapControls() {

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
