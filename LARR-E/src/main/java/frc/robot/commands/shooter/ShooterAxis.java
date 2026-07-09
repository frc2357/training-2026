package frc.robot.commands.shooter;

import java.util.function.Supplier;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class ShooterAxis extends Command {

    private Supplier<Dimensionless> m_axis;

    public ShooterAxis(Supplier<Dimensionless> axis) {
        m_axis = axis;
        addRequirements(Robot.shooter);
    }

    @Override
    public void execute() {
        Robot.shooter.setAxisSpeed(m_axis.get());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.shooter.stop();
    }
}
