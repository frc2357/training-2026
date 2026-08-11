package frc.robot.commands.intakePivot;

import static edu.wpi.first.units.Units.Percent;
import static edu.wpi.first.units.Units.Value;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.subsystems.intakePivot.IntakePivotConstants;

public class IntakeDeploy extends Command {

    public IntakeDeploy() {
        addRequirements(Robot.intakePivot);
    }

    public void execute() {
        new IntakePivotSetSpeed(Percent.of(40)).andThen(
                new WaitCommand(IntakePivotConstants.DEPLOY_TIME.in(Value))).andThen(
                        new IntakePivotSetSpeed(Percent.of(0)));
    }
}
