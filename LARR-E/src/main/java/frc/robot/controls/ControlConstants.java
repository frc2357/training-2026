package frc.robot.controls;

import static edu.wpi.first.units.Units.Value;

import edu.wpi.first.units.measure.Dimensionless;

public class ControlConstants {

    public static final int DRIVE_CONTROLLER_PORT = 0;
    public static final int CO_DRIVER_CONTROLLER_PORT = 1;

    public static final Dimensionless DRIVER_RUMBLE_INTENSITY = Value.of(100);
    public static final Dimensionless DRIVER_RUMBLE_SECONDS = Value.of(5);

    public static final Dimensionless CODRIVER_RUMBLE_INTENSITY = Value.of(100);
    public static final Dimensionless CODRIVER_RUMBLE_SECONDS = Value.of(5);

    public static final Dimensionless DRIVER_CONTROLLER_DEADBAND = Value.of(0.05);
    public static final Dimensionless CODRIVER_CONTROLLER_DEADBAND = Value.of(0.05);
}
