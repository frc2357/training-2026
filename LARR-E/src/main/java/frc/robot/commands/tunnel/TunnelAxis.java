package frc.robot.commands.tunnel;

import static edu.wpi.first.units.Units.Value;

import java.util.function.Supplier;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class TunnelAxis extends Command {

    private Supplier<Dimensionless> m_axis;

    public TunnelAxis(Supplier<Dimensionless> axis) {
        m_axis = axis;
        addRequirements(Robot.tunnel);

    }

    @Override
    public void execute() {
        Robot.tunnel.setAxisSpeed(m_axis.get());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.tunnel.stop();
    }
}
