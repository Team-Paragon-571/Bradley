package org.frc571.bradley.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import org.frc571.bradley.subsystems.Index;

public class IndexCommand extends CommandBase {

    private final Index m_index;

    public IndexCommand(Index subsystem) {

        m_index = subsystem;
        addRequirements(m_index);

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
