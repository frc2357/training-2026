package first.robot.mechanisms.arm;

import static org.wpilib.units.Units.Degrees;

import org.wpilib.units.measure.Angle;

public final class ArmConstants {
    public static final int SERVO_PORT = 4;
    public static final Angle ARM_POSITION_TOLERANCE = Degrees.of(1);
}
