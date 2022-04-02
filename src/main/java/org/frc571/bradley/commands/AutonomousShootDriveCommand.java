package org.frc571.bradley.commands;

import org.frc571.bradley.Constants.AutonomousConstants;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class AutonomousShootDriveCommand extends SequentialCommandGroup {
        public AutonomousShootDriveCommand(double driveTimeout) {
                addCommands(
                                new ParallelRaceGroup(
                                new RevCommand(1).withTimeout(2),
                                new WaitCommand(0.2).andThen(new FireCommand().withTimeout(1))),
                                new AutonomousDriveCommand()
                                                .withTimeout(AutonomousConstants.AUTONOMOUS_COMMAND_DURATION));
        }

}
