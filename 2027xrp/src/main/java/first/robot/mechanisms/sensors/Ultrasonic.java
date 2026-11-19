package first.robot.mechanisms.sensors;

import org.wpilib.xrp.XRPRangefinder;
import org.wpilib.command3.Command;
import org.wpilib.command3.Mechanism;

public class Ultrasonic extends XRPRangefinder implements Mechanism {

    public Ultrasonic() {}

    public Command whenTrueElse(double distance, Runnable onTrue, Runnable onFalse) {
        final byte sign = (byte) Math.signum(distance);
        return this.runRepeatedly( () -> {
            if (sign * Math.signum(distance) < this.getDistance() * sign) {
                onTrue.run();
            } else {
                onFalse.run();
            }
        }).named("when true else");
    }
}
