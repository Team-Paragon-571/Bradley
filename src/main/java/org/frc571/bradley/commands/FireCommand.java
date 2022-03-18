package org.frc571.bradley.commands;

import org.frc571.bradley.subsystems.Hopper;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class FireCommand extends CommandBase {
    private Hopper hopper;

    public FireCommand() {
        hopper = Hopper.getInstance();
        addRequirements(hopper);
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
        return false;
    }

}
