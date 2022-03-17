package org.frc571.bradley.commands;

import org.frc571.bradley.subsystems.Hopper;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ReverseHopperCommand extends CommandBase {
    Hopper hopper;

    public ReverseHopperCommand() {
        hopper = Hopper.getInstance();
        addRequirements(hopper);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        hopper.reverse();
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
