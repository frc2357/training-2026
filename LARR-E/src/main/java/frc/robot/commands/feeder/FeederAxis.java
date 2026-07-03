package frc.robot.commands.feeder;

import java.util.function.Supplier;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class FeederAxis extends Command {

    private Supplier<Dimensionless> m_axis;

    public FeederAxis(Supplier<Dimensionless> axis) {
        m_axis = axis;
        addRequirements(Robot.feeder);
    }

    @Override
    public void execute() {
        Robot.feeder.setAxisSpeed(m_axis.get());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.feeder.stop();
    }
}
