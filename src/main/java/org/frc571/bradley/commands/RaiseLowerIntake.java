package org.frc571.bradley.commands;

import org.frc571.bradley.Constants.SpeedConstants;
import org.frc571.bradley.subsystems.IntakeArm;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

public class RaiseLowerIntake extends ParallelCommandGroup {
    IntakeArm arm;
    boolean raise;
    boolean left;

    public RaiseLowerIntake(boolean raise, boolean left) {
        this.raise = raise;
        this.left = left;
        arm = IntakeArm.getInstance();
    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (left) {
            if (raise) {
                arm.setLeftSpeed(SpeedConstants.RAISE_INTAKE_SPEED);
            } else { // lower
                arm.setLeftSpeed(-SpeedConstants.RAISE_INTAKE_SPEED);
            }
        } else { // right
            if (raise) {
                arm.setRightSpeed(SpeedConstants.RAISE_INTAKE_SPEED);
            } else { // lower
                arm.setRightSpeed(-SpeedConstants.RAISE_INTAKE_SPEED);
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
        if (left) {
            arm.setLeftSpeed(0);
        } else if (!left) {
            arm.setRightSpeed(0);
        } else { // should never happen
            arm.stop();
        }
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (left) {
            if (raise) {
                return arm.getLimitSwitchTopLeft();
            } else { // lower
                return arm.getLimitSwitchBottomLeft();
            }
        } else { // right
            if (raise) {
                return arm.getLimitSwitchTopRight();
            } else { // lower
                return arm.getLimitSwitchBottomRight();
            }
        }
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }

}
