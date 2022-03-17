package org.frc571.bradley.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

public class EjectCommand extends ParallelCommandGroup {
    public EjectCommand() {
        addCommands(new ReverseIntakeCommand(), new RevCommand(() -> -1), new ReverseHopperCommand());
    }
}
