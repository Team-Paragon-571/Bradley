package org.frc571.bradley.commands;

import org.frc571.bradley.Constants.SpeedConstants;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// revButton.whenPressed(new ReverseHopperCommand().withTimeout(0.1), true);
public class ShootCommand extends ParallelCommandGroup {

    public ShootCommand() {
        addCommands(
                new RevCommand(-0.25).withTimeout(0.5).andThen(new RevCommand(SpeedConstants.FLYWHEEL_MAX_SPEED)),
                new SequentialCommandGroup(
                        new ParallelDeadlineGroup(
                                new ReverseHopperCommand().withTimeout(0.5),
                                new LowerIntake()),
                        new FireCommand().alongWith(new RaiseIntake())));
    }

}
