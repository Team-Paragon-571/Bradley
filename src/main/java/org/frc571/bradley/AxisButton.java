package org.frc571.bradley;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Button;

public class AxisButton extends Button {
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
    public AxisButton(GenericHID joystick, int axis, double threshold) {
        this.joystick = joystick;
        this.axis = axis;
        this.threshold = threshold;
    }

    @Override
    public boolean get() {
        return (joystick.getRawAxis(axis) > threshold);
    }

}
