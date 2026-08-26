package frc.robot.commands.scoring;

import static edu.wpi.first.units.Units.Value;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.feeder.FeederSetSpeed;
import frc.robot.commands.floor.FloorSetSpeed;
import frc.robot.commands.kicker.KickerSetSpeed;
import frc.robot.commands.tunnel.TunnelSetSpeed;

public class Feeding extends ParallelCommandGroup {
    public Feeding() {
        super(
                new ParallelCommandGroup(
                        new KickerSetSpeed(Value.of(50)),
                        new FloorSetSpeed(Value.of(80)),
                        new FeederSetSpeed(Value.of(80)),
                        new TunnelSetSpeed(Value.of(80))));
    }
}
