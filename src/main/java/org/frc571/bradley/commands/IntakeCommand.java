
package org.frc571.bradley.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class IntakeCommand extends SequentialCommandGroup {

    public IntakeCommand() {
        new ParallelCommandGroup(
            new RaiseLowerIntake(false, false),
            new RaiseLowerIntake(false, true)
        );
        new ParallelDeadlineGroup(
                new RunIndexCommand(),
                new RunIntakeCommand());
        new ParallelDeadlineGroup(
            new ParallelCommandGroup(
                new RaiseLowerIntake(true, false),
                new RaiseLowerIntake(true, true)
            ),
            new ReverseIndexCommand()
        );
    }

    // Called when the command is initially scheduled.
    @Override
    public boolean runsWhenDisabled() {
        return false;

    }

}
