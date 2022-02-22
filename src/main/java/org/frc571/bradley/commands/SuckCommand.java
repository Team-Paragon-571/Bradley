package org.frc571.bradley.commands;

import org.frc571.bradley.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SuckCommand extends CommandBase {

    private final Intake m_intake;

    public SuckCommand() {

        m_intake = Intake.getInstance();
        addRequirements(m_intake);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
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
