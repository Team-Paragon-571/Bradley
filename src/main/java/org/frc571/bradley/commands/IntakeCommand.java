package org.frc571.bradley.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;

public class IntakeCommand extends SequentialCommandGroup {

    public IntakeCommand() {
        addCommands(
                new LowerIntake().withTimeout(1),

                new ParallelRaceGroup (
                        new RunHopperCommand(),
                        new RunIntakeCommand(),
                        new RevCommand(-0.1)),
                new ParallelCommandGroup(
                        new ReverseHopperCommand().withTimeout(0.2),
                        new RaiseIntake()));
    }

    // Called when the command is initially scheduled.
    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}