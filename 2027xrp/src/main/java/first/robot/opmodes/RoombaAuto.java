package first.robot.opmodes;

import first.robot.Robot;
import org.wpilib.command3.Command;
import org.wpilib.command3.Scheduler;
import org.wpilib.command3.Trigger;
import org.wpilib.driverstation.RobotState;
import org.wpilib.opmode.Autonomous;
import org.wpilib.opmode.PeriodicOpMode;
import org.wpilib.telemetry.Telemetry;

@Autonomous(name = "Roomba Auto")
public class RoombaAuto extends PeriodicOpMode {

    private final Robot m_robot;
    private final Trigger enabled = new Trigger(RobotState::isEnabled);

    public RoombaAuto(Robot robot) {
        m_robot = robot;
        System.out.println("opmode constructed");
    }

    @Override
    public void start() {
        Scheduler.getDefault().schedule(roomba());
    /* Called once when the robot is enabled. */
    //enabled.onTrue(m_robot.roomba.roomba());
    }

    @Override
    public void periodic() {
        Telemetry.getTable("Rangefinder").log("Distance", m_robot.rangefinder.getDistance());
    }

    public Command roomba() {
        return Command.requiring(m_robot.drive, m_robot.rangefinder).executing((coro) -> {
            while(true) {
                if (m_robot.rangefinder.getDistance() < 0.4) {
                    m_robot.drive.flipRight(false);
                } else {
                    m_robot.drive.flipRight(true);
                }
                m_robot.drive.arcadeDrive(1, 0);
                coro.yield();
            }
        }).named("Roomba");
    }
}
