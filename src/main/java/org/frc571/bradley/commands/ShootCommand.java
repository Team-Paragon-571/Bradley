package org.frc571.bradley.commands;

import java.util.function.DoubleSupplier;

import org.frc571.bradley.subsystems.Hopper;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ShootCommand extends SequentialCommandGroup {

    public ShootCommand(DoubleSupplier fire) {
        addRequirements(Hopper.getInstance());
        addCommands(
                new ReverseHopperCommand().withTimeout(0.2),
                new FireCommand(fire));
    }
}
