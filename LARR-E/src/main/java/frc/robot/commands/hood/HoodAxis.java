package frc.robot.commands.hood;

import java.util.function.Supplier;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class HoodAxis extends Command {

    private Supplier<Dimensionless> m_axis;

    public HoodAxis(Supplier<Dimensionless> axis) {
        m_axis = axis;
        addRequirements(Robot.hood);
    }

    @Override
    public void execute() {
        Robot.hood.setAxisSpeed(m_axis.get());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.hood.stop();
    }
}
