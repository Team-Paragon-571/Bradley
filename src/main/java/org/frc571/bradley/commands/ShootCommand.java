package org.frc571.bradley.commands;

import org.frc571.bradley.Constants.SpeedConstants;
import org.frc571.bradley.Constants.TimeConstants;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

    // revButton.whenPressed(new ReverseHopperCommand().withTimeout(0.1), true);
public class ShootCommand extends ParallelCommandGroup {
    /**
     *
     */

    public ShootCommand () {
        addCommands(
            new RaiseIntake(),
            new WaitCommand(TimeConstants.BACKUP_TIME).andThen(new RevCommand(SpeedConstants.FLYWHEEL_MAX_SPEED)), 
            new ReverseHopperCommand().withTimeout(TimeConstants.FLYWHEEL_REV_TIME)
                .andThen(new FireCommand())
        );
    }
    
}
