package org.frc571.bradley.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;

public class IntakeCommand extends SequentialCommandGroup {

    public IntakeCommand() {
        new LowerIntake();

        new ParallelDeadlineGroup(
                new RunHopperCommand(),
                new RunIntakeCommand());

        new RaiseIntake();
        new ReverseIntakeCommand();
    }

    // Called when the command is initially scheduled.
    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}