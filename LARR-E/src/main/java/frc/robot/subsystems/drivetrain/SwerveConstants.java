package frc.robot.subsystems.drivetrain;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.AngularVelocity;

public class SwerveConstants {
    public static final class SWERVE {
        public static final AngularVelocity MAX_ANGULAR_VELOCITY = Units.RadiansPerSecond.of((Math.PI * 2) / 1.5);
    }
}
