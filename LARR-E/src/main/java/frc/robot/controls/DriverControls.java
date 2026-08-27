package frc.robot.controls;

import static edu.wpi.first.units.Units.Value;
import static edu.wpi.first.units.Units.Percent;
import edu.wpi.first.units.measure.Dimensionless;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.feeder.FeederSetSpeed;
import frc.robot.commands.hood.HoodSetSpeed;
import frc.robot.commands.intakePivot.IntakeDeploy;
import frc.robot.commands.intakePivot.IntakePivotAxis;
import frc.robot.commands.intakePivot.IntakePivotSetSpeed;
import frc.robot.commands.intakeRunner.IntakeRunnerAxis;
import frc.robot.commands.intakeRunner.IntakeRunnerSetSpeed;
import frc.robot.commands.kicker.KickerSetSpeed;
import frc.robot.commands.scoring.Feeding;
import frc.robot.commands.shooter.ShooterAxis;
import frc.robot.commands.shooter.ShooterSetSpeed;
import frc.robot.commands.shooter.ShooterStop;
import frc.robot.commands.tunnel.TunnelSetSpeed;

public class DriverControls {

    private CommandXboxController m_controller;

    public DriverControls(CommandXboxController controller) {
        m_controller = controller;
        mapControls();
    }

    public void mapControls() {
        m_controller.povRight().whileTrue(new IntakePivotSetSpeed(Percent.of(10)));
        m_controller.povLeft().whileTrue(new IntakePivotSetSpeed(Percent.of(-10)));

        m_controller.povUp().whileTrue(new HoodSetSpeed(Percent.of(15)));
        m_controller.povDown().whileTrue(new HoodSetSpeed(Percent.of(-15)));
        m_controller.rightTrigger().whileTrue(new IntakeRunnerAxis(() -> Value.of(m_controller.getRightTriggerAxis())));
        m_controller.leftTrigger()
                .whileTrue(new ShooterAxis(() -> Value.of(m_controller.getLeftTriggerAxis())).alongWith(new Feeding()));
    }

    public Dimensionless getLeftX() {
        return Value.of(m_controller.getLeftX());
    }

    public Dimensionless getLeftY() {
        return Value.of(m_controller.getLeftY());
    }

    public Dimensionless getRotation() {
        return Value.of(-m_controller.getRightX());
    }
}
