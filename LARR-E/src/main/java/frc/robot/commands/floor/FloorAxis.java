package frc.robot.commands.floor;

import java.util.function.Supplier;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class FloorAxis extends Command {

    private Supplier<Dimensionless> m_axis;

    public FloorAxis(Supplier<Dimensionless> axis) {
        m_axis = axis;
        addRequirements(Robot.floor);
    }

    @Override
    public void execute() {
        Robot.floor.setAxisSpeed((m_axis));
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.floor.stop();
    }
}
