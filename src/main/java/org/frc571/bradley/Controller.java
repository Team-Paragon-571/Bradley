package org.frc571.bradley;

public class Controller {
    public static double ApplyJoystickDeadzone(double value, double deadzone) {
        double result;
        double validRange = 1.0 - deadzone;

        if (value > deadzone) {
            result = (value - deadzone) / validRange;
        }
        else {
            result = 0;
        }

        return result;
    }
}
