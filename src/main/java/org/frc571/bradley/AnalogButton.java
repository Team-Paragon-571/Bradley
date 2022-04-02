package org.frc571.bradley;

import static edu.wpi.first.wpilibj.util.ErrorMessages.requireNonNullParam;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Button;

public class AnalogButton extends Button {
    GenericHID joystick;
    int axis;
    double threshold;

    /**
     * Create an Axis button for triggering commands when value exceeds threshold
     * 
     * @param joystick  The GenericHID object that has the axis
     * @param axis      The axis number (see {@link GenericHID#getRawAxis(int) } )
     * @param threshold The threshold beyond which the button is triggered.
     */
    public AnalogButton(GenericHID joystick, int axis, double threshold) {
        requireNonNullParam(joystick, "joystick", "AxisButton");
        this.joystick = joystick;
        this.axis = axis;
        this.threshold = threshold;
    }

    /**
     * Checks whether the joystick axis value is greater than the threshold
     * 
     * @return whether the axis value is greater than the threshold
     */
    @Override
    public boolean get() {
        return (joystick.getRawAxis(axis) > threshold);
    }

}
