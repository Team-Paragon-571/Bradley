package org.frc571.bradley.commands;

import org.frc571.bradley.Constants.SpeedConstants;
import org.frc571.bradley.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ReverseIntakeCommand extends CommandBase {
    final private Intake intake;

    public ReverseIntakeCommand() {
        intake = Intake.getInstance();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        intake.setSpeed(-SpeedConstants.kIntakeMotorSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }

}
