package frc.robot.subsystems.intakePivot;

import static edu.wpi.first.units.Units.Value;
import com.revrobotics.spark.SparkMax;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.CanID;
import frc.robot.subsystems.intakePivot.IntakePivotConstants;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;

public class IntakePivot extends SubsystemBase {

    public static final TalonFX m_motor = new TalonFX(CanID.INTAKE_PIVOT_MOTOR);

    public IntakePivot() {

        TalonFXConfiguration config = new TalonFXConfiguration();
        config.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        config.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

        m_motor.getConfigurator().apply(config);

        CurrentLimitsConfigs ampLimiter = new CurrentLimitsConfigs();

        ampLimiter.SupplyCurrentLimit = 40;
        ampLimiter.SupplyCurrentLimitEnable = true;

        m_motor.getConfigurator().apply(ampLimiter);
    }

    public void setSpeed(Dimensionless m_speed) {
        m_motor.set(m_speed.in(Value));
    }

    public void setAxisSpeed(Dimensionless axisSpeed) {
        setSpeed(axisSpeed.times(IntakePivotConstants.AXIS_MAX_SPEED));
    }

    public void stop() {
        m_motor.set(0.0);
    }
}