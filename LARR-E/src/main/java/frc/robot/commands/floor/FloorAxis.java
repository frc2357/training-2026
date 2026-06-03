package frc.robot.commands.floor;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;

public class FloorAxis extends Command {
    
    private Dimensionless m_axis;

    public FloorAxis(Dimensionless axis) {
        m_axis = axis;
        addRequirements(Robot.floor);
    }

    @Override
    public void execute() {
        double axisValue = m_axis.in(null);
        Robot.floor.setAxisSpeed(axisValue);
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
