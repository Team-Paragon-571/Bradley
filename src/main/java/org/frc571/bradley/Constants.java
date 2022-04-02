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
        public static final int kLeftMotorFrontPort = 1;
        public static final int kLeftMotorRearPort = 2;
        public static final int kRightMotorFrontPort = 3;
        public static final int kRightMotorRearPort = 4;
        public static final double kMaxOutput = 1.0;
        public static final String kMaxOutputKey = "drive/maxOutput";
    }

    public static final class MotorConstants {
        public static final int kLeftIntakeArmPort = 7;
        public static final int kRightIntakeArmPort = 8;
        public static final int INTAKE_MOTOR = 9;
        public static final int kLeftIndexMotor = 5;
        public static final int kRightIndexMotor = 18;
        public static final int kShooterMotor = 6;
    }

    public static final class ControlConstants {
        public static final double MAX_AXIS = 1.0;
        public static final double kDeadzone = 0.3;
        public static final double kShootMotor = 0.5;
        public static final double FIRE_COMMAND_END = 0.1;
        public static final double FIRE_COMMAND_THRESHOLD = 0.5;
    }

    public static final class DigitalConstants {
        public static final int TOP_LEFT_LIMIT_SWITCH = 1;
        public static final int TOP_RIGHT_LIMIT_SWITCH = 3;
        public static final int BOTTOM_LEFT_LIMIT_SWITCH = 0;
        public static final int BOTTOM_RIGHT_LIMIT_SWITCH = 2;
        public static final int kFrontInput = 4;
        public static final int kMiddleInput = 12;
        public static final int kBackInput = 5;
    }

    public static final class SpeedConstants {
        public static final double kIntakeMotorSpeed = 0.25;
        public static final double RAISE_INTAKE_SPEED = 0.3;
        public static final double FLYWHEEL_MAX_SPEED = 0.79;

    }

    public static final class AutonomousConstants {
        public static final double AUTONOMOUS_COMMAND_DURATION = 3.0;
        public static final double AUTONOMOUS_COMMAND_SPEED = -0.25;
    }
}
