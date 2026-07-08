package frc.robot.commands.intakePivot;

import java.util.function.Supplier;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class IntakePivotAxis extends Command {

    private Supplier<Dimensionless> m_axis;

    public IntakePivotAxis(Supplier<Dimensionless> axis) {
        m_axis = axis;
        addRequirements(Robot.intakePivot);
    }

    @Override
    public void execute() {
        Robot.intakePivot.setAxisSpeed(m_axis.get());

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.intakePivot.stop();
    }
}
