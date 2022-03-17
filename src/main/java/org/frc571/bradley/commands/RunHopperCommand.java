package org.frc571.bradley.commands;

import org.frc571.bradley.subsystems.Hopper;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunHopperCommand extends CommandBase {
    private Hopper hopper;

    public RunHopperCommand() {
        hopper = Hopper.getInstance();
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        hopper.turn();
    }

    @Override
    public void end(boolean interrupted) {
        hopper.stop();
    }

    @Override
    public boolean isFinished() {
        return (hopper.getFrontInput() && hopper.getBackInput());
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }

}
