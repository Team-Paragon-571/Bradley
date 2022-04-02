package org.frc571.bradley.commands;

import org.frc571.bradley.Constants.SpeedConstants;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class ShootCommand extends SequentialCommandGroup {
    public ShootCommand () {
        addCommands(
            new RevCommand(SpeedConstants.FLYWHEEL_MAX_SPEED), 
            new WaitCommand(SpeedConstants.FLYWHEEL_REV_TIME)
                .andThen(new FireCommand())
        );
    }
    
}
