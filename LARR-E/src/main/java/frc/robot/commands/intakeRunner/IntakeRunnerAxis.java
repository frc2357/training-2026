package frc.robot.commands.intakeRunner;

import java.util.function.Supplier;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class IntakeRunnerAxis extends Command {

    private Supplier<Dimensionless> m_axis;

    public IntakeRunnerAxis(Supplier<Dimensionless> axis) {
        m_axis = axis;
        addRequirements(Robot.intakeRunner);
    }

    @Override
    public void execute() {
        Robot.intakeRunner.setAxisSpeed(m_axis.get());
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
