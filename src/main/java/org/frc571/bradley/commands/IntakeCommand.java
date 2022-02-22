
package org.frc571.bradley.commands;

import org.frc571.bradley.subsystems.Index;
import org.frc571.bradley.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class IntakeCommand extends SequentialCommandGroup {

    public IntakeCommand() {

        addCommands(
                new SuckCommand(),
                new IndexCommand());
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
