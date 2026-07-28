package frc.robot.commands.kicker;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class KickerSetSpeed extends Command {

    private Dimensionless m_speed;

    public KickerSetSpeed(Dimensionless speed) {
        addRequirements(Robot.kicker);
        m_speed = speed;
    }

    @Override
    public void initialize() {
        Robot.kicker.setSpeed(m_speed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.kicker.stop();
    }
}
