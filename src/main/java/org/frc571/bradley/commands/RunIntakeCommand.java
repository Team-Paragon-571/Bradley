package org.frc571.bradley.commands;

import org.frc571.bradley.Constants.SpeedConstants;
import org.frc571.bradley.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunIntakeCommand extends CommandBase {

    private Intake intake;

    public RunIntakeCommand() {
        intake = Intake.getInstance();
        addRequirements(intake);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        intake.setSpeed(SpeedConstants.kIntakeMotorSpeed);
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
