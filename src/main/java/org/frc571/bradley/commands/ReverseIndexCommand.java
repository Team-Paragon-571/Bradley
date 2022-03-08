package org.frc571.bradley.commands;

import org.frc571.bradley.subsystems.Index;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ReverseIndexCommand extends CommandBase {
    private Index index;

    public ReverseIndexCommand() {
        index = Index.getInstance();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        index.reverse();
    }

    @Override
    public void end(boolean interrupted) {
        index.stop();
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
