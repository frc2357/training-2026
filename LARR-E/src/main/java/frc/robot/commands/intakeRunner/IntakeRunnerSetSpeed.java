package frc.robot.commands.intakeRunner;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class IntakeRunnerSetSpeed extends Command {

    private Dimensionless m_speed;

    public IntakeRunnerSetSpeed(Dimensionless speed) {
        addRequirements(Robot.intakeRunner);
        m_speed = speed;
    }

    @Override
    public void initialize() {
        Robot.intakeRunner.setSpeed(m_speed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.intakeRunner.stop();
    }
}
