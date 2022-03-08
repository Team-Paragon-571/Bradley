package org.frc571.bradley;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be
 * declared globally (i.e. public static). Do not put anything functional in
 * this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
    public static final class DriveConstants {
        public static final int LEFT_FRONT_MOTOR = 1;
        public static final int LEFT_REAR_MOTOR = 2;
        public static final int RIGHT_FRONT_MOTOR = 3;
        public static final int RIGHT_REAR_MOTOR = 4;
        public static final int PIGEON = 30;
    }

    public static final class MotorConstants {
        public static final int LEFT_INTAKE_ARM_MOTOR = 5;
        public static final int RIGHT_INTAKE_ARM_MOTOR = 6;
        public static final int INDEX_MOTOR = 7;
        public static final int INTAKE_MOTOR = 8;
        public static final int SHOOTER_MOTOR = 9;
    }

    public static final class ControlConstants {
        public static final double kDeadzone = 0.3;
        public static final double kShootMotor = 0.5;
    }

    public static final class DigitalConstants {
        public static final int TOP_INTAKE_ARM_LIMIT_SWITCH = 0;
        public static final int BOTTOM_INTAKE_ARM_LIMIT_SWITCH = 1;
        public static final int FRONT_INPUT = 2;
        public static final int REAR_INPUT = 3;
    }

    public static final class SpeedConstants {
        public static final double kIntakeMotorSpeed = 0.5;

    }
}
