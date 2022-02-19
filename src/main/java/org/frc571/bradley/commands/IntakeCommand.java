package org.frc571.bradley.commands;

import org.frc571.bradley.subsystems.Index;
import org.frc571.bradley.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class IntakeCommand extends SequentialCommandGroup {

    public IntakeCommand(Intake intake, Index index) {

        addCommands(
                new SuckCommand(intake),
                new IndexCommand(index));
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
