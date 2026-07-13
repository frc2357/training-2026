package first.robot.mechanisms.arm;

import static org.wpilib.units.Units.Degrees;

import java.util.function.Supplier;

import org.wpilib.command3.Command;
import org.wpilib.command3.Mechanism;
import org.wpilib.math.util.MathUtil;
import org.wpilib.units.measure.Angle;
import org.wpilib.xrp.XRPServo;

public class Arm extends Mechanism {
    private final XRPServo armServo;

    /** Creates a new Arm. */
    public Arm() {
        // Device number 4 maps to the physical Servo 1 port on the XRP
        armServo = new XRPServo(ArmConstants.SERVO_PORT);
    }

    /**
     * Set the current angle of the arm (0 - 180 degrees).
     *
     * @param angleDeg Desired arm angle in degrees
     */
    private void setAngle(Angle angleDeg) {
        armServo.setAngle(angleDeg.in(Degrees));
    }

    public Command setAngle(Supplier<Angle> angle) {
        return this.run((coro) -> {
            setAngle(angle.get());

            coro.waitUntil(() -> MathUtil.isNear(angle.get().in(Degrees), armServo.getAngle(),
                    ArmConstants.ARM_POSITION_TOLERANCE.in(Degrees)));
        }).named("Set Arm Angle");
    }
}
