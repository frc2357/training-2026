package frc.robot.commands.rumble;

import static edu.wpi.first.units.Units.Value;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.controls.ControlConstants;

public class RumbelCoDriverController extends Command {

    Timer timer = new Timer();

    @Override
    public void initialize() {
        Robot.coDriverControls.setRumble(ControlConstants.CODRIVER_RUMBLE_INTENSITY);
        timer.reset();
        timer.start();
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(ControlConstants.CODRIVER_RUMBLE_SECONDS.in(Value));
    }

    @Override
    public void end(boolean interrupted) {
        timer.stop();
        Robot.coDriverControls.setRumble(Value.of(0));
    }
}
