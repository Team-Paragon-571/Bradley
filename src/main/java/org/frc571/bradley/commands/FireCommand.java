package org.frc571.bradley.commands;

import java.util.function.DoubleSupplier;

import org.frc571.bradley.Constants.ControlConstants;
import org.frc571.bradley.subsystems.Hopper;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class FireCommand extends CommandBase {
    private Hopper hopper;
    private DoubleSupplier fire;

    public FireCommand(DoubleSupplier fire) {
        this.fire = fire;
        addRequirements(hopper);
    }

    @Override
    public void initialize() {
        hopper.reverse();
    }

    @Override
    public void execute() {
        if (fire.getAsDouble() > ControlConstants.FIRE_COMMAND_THRESHOLD) {
            hopper.turn();
        }
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
