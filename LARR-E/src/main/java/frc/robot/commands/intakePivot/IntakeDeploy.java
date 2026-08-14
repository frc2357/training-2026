package frc.robot.commands.intakePivot;

import static edu.wpi.first.units.Units.Percent;
import static edu.wpi.first.units.Units.Value;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.Robot;
import frc.robot.subsystems.intakePivot.IntakePivotConstants;

public class IntakeDeploy extends Command {

    public IntakeDeploy() {
        addRequirements(Robot.intakePivot);
    }

    @Override
    public void initialize() {
        Robot.intakePivot.setSpeed(Percent.of(40));
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
/*
 * public IntakeDeploy() {
 * super(
 * new IntakePivotSetSpeed(Percent.of(20)));
 * new ParallelCommandGroup(
 * new SequentialCommandGroup(
 * new WaitUntilCommand(() -> Robot.intakePivot.StatorCurrentStall()),
 * new IntakePivotStop()));
 * }
 * }
 */