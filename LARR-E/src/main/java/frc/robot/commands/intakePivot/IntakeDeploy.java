package frc.robot.commands.intakePivot;

import static edu.wpi.first.units.Units.Value;

import static edu.wpi.first.units.Units.Percent;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.intakePivot.IntakePivotConstants;

public class IntakeDeploy extends Command {

    public IntakeDeploy() {
        addRequirements(Robot.intakePivot);
    }

    @Override
    public void initialize() {
        Robot.intakePivot.setSpeed(IntakePivotConstants.DEPLOY_SPEED);
    }

    @Override
    public boolean isFinished() {
        return Robot.intakePivot.StatorCurrentStall();
    }

    @Override
    public void end(boolean interrupted) {
        Robot.intakePivot.stop();
    }
}
