package org.frc571.bradley;

public class Controller {
    public static double ApplyJoystickDeadzone(double rawValue, double deadzone) {
        double result;
        double validRange = Constants.ControlConstants.MAX_AXIS - deadzone;
        double value = Math.abs(rawValue);

        if (value > deadzone) {
            result = (value - deadzone) / validRange;
        }
        else {
            result = 0;
        }

        return rawValue < 0 ? -result : result;
    }
}
