package frc.robot.commands.intakeRunner;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class IntakeRunnerStop extends Command {

    public IntakeRunnerStop() {
        addRequirements(Robot.intakeRunner);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.intakeRunner.stop();
    }
}
