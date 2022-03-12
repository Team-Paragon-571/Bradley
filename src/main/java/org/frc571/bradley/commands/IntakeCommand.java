
package org.frc571.bradley.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class IntakeCommand extends SequentialCommandGroup {

    public IntakeCommand() {
        new RaiseLowerIntake(false);
        new ParallelDeadlineGroup(
                new RunIndexCommand(),
                new RunIntakeCommand());
        new ParallelDeadlineGroup(
            new RaiseLowerIntake(true),
            new ReverseIndexCommand()
        );
    }

    // Called when the command is initially scheduled.
    @Override
    public boolean runsWhenDisabled() {
        return false;

    }

}
