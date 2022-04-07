package org.frc571.bradley.commands;

import org.frc571.bradley.subsystems.Drive;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class TogglePrecisionTurnMode extends InstantCommand{
    Drive drive;

    public TogglePrecisionTurnMode() {
        drive = Drive.getInstance();
    }

    @Override
    public void execute() {
        drive.togglePrecisionTurnMode();
    }
}
