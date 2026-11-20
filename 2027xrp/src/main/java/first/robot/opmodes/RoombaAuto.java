package first.robot.opmodes;

import org.wpilib.command3.Command;
import org.wpilib.command3.Trigger;
import org.wpilib.driverstation.RobotState;
import org.wpilib.opmode.Autonomous;
import org.wpilib.opmode.PeriodicOpMode;
import first.robot.Robot;
import first.robot.mechanisms.distanceSensor.DistanceSensor;

import static org.wpilib.units.Units.Value;
import static org.wpilib.units.Units.Milliseconds;

@Autonomous(name = "Roomba Auto")
public class RoombaAuto extends PeriodicOpMode {
    private Robot m_robot;
    private final Trigger enabled = new Trigger(RobotState::isEnabled);
    private final DistanceSensor m_distanceSensor = new DistanceSensor();

    public RoombaAuto(Robot robot) {
        m_robot = robot;

        enabled.onTrue(roombaAuto());
    }

    public Command roombaAuto() {
        return Command.noRequirements((coro) -> {
            double distance;
            while (true) {
                distance = m_distanceSensor.getDistanceInches();
                if (distance < 20) {
                    coro.await(m_robot.drive.autoDrive(Milliseconds.of(100), Value.of(0), Value.of(1)));
                } else {
                    coro.await(m_robot.drive.autoDrive(Milliseconds.of(100), Value.of(1), Value.of(0)));
                }
            }
        }).named("Roomba Auto");
    }
}
