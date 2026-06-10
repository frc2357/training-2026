package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Value;

import java.util.function.Supplier;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CAN_ID;
import frc.robot.Constants.FLOOR;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

public class Floor extends SubsystemBase {

    private SparkMax m_motor;

    public Floor() {
        m_motor = new SparkMax(CAN_ID.FLOOR_MOTOR, MotorType.kBrushless);

        m_motor.configure(
                frc.robot.Constants.FLOOR.MOTOR_CONFIG,
                ResetMode.kNoResetSafeParameters,
                PersistMode.kNoPersistParameters);

    }

    public void setSpeed(Dimensionless m_speed) {
        m_motor.set(m_speed.in(Value));
    }

    public void setAxisSpeed(Supplier<Dimensionless> axisSpeed) {
        setSpeed(axisSpeed.get());
    }

    public void stop() {
        m_motor.stopMotor();
    }

    /*
     * * public void initSendable(SendableBuilder builder) {
     * builder.setSmartDashboardType("Floor IdleMode");
     * builder.addBooleanProperty("IdleMode switch", m_motor.getIdleMode(),
     * null);
     * }
     */
}
