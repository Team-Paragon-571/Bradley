package org.frc571.bradley.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import org.frc571.bradley.subsystems.Hopper;
import org.frc571.bradley.subsystems.Intake;

public class StopIntakeCommand extends CommandBase {

    private final Intake m_intake;
    private final Hopper hopper;

    public StopIntakeCommand() {
        hopper = Hopper.getInstance();
        m_intake = Intake.getInstance();
        addRequirements(m_intake, hopper);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_intake.stop();
        hopper.stop();
    }

    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
