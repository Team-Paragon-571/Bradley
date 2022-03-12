package org.frc571.bradley.commands;

import org.frc571.bradley.subsystems.Index;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunIndexCommand extends CommandBase {
    private Index index;

    public RunIndexCommand() {
        index = Index.getInstance();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        index.turn();
    }

    @Override
    public void end(boolean interrupted) {
        index.stop();
    }

    @Override
    public boolean isFinished() {
        return (index.getFrontInput() && index.getRearInput());
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }

}
