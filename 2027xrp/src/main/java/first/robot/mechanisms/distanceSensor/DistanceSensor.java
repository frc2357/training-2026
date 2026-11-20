package first.robot.mechanisms.distanceSensor;

import org.wpilib.command3.Mechanism;
import org.wpilib.xrp.XRPRangefinder;

public class DistanceSensor implements Mechanism {
    public XRPRangefinder m_sensor;

    public DistanceSensor() {
        m_sensor = new XRPRangefinder();
    }

    public double getDistanceInches() {
        return m_sensor.getDistance() / 0.0254;
    }

    public double getDistanceMeters() {
        return m_sensor.getDistance();
    }
}
