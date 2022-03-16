package org.frc571.bradley.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ShootCommand extends SequentialCommandGroup {
    public ShootCommand(DoubleSupplier fire) {
        addCommands(
                new ReverseHopperCommand().withTimeout(0.3),
                new FireCommand(fire));
    }

}
