package frc.robot.commands.rumble;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class RumbelCoDriverController extends Command {

    Timer timer = new Timer();

    @Override
    public void initialize() {
        Robot.coDriverControls.setRumble(CODRIVER_RUMBLE_INTENSITY);
        timer.reset();
        timer.start();
    }

    @Override
    public boolean isFinished() {
        return timer.hsElapsed(CODRIVER_RUMBLE_SECONDS);
    }

    @Override
    public void end(boolean interrupted) {
        timer.stop();
        Robot.
    }
}
