package frc.robot.controls;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.controls.util.RumbleInterface;

public class CoDriverControls implements RumbleInterface {

    private CommandXboxController m_controller;

    public CoDriverControls(CommandXboxController controller) {
        m_controller = controller;

        mapControls();
    }

    public void mapControls() {

    }

    @Override
    public void setRumble(Dimensionless intensity) {
        m_controller.setRumble(RumbleType.kBothRumbe, intensity);
    }
}
