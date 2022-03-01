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
    }

    public static final class MotorConstants {
        public static final int kLeftIntakeArmPort = 5;
        public static final int kRightIntakeArmPort = 6;
        public static final int kLeftIndexMotor = 7;
        public static final int kRightIndexMotor = 8;
        public static final int kShooterMotor = 9;
    }

    public static final class ControlConstants {
        public static final double kDeadzone = 0.3;
        public static final double kShootMotor = 0.5;
    }

    public static final class DigitalConstants {
        public static final int kLimitSwitchIntakeArmTopPort = 7;
        public static final int kLimitSwitchIntakeArmBottomPort = 8;
        public static final int kFrontInput = 9;
        public static final int kMiddleInput = 10;
        public static final int kBackInput = 11;
    }
}
