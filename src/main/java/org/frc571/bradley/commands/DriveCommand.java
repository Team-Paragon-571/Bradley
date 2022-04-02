package org.frc571.bradley.commands;

import java.util.function.DoubleSupplier;

import org.frc571.bradley.Constants.DriveConstants;
import org.frc571.bradley.subsystems.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {

    private final Drive m_drive;
    private final DoubleSupplier m_forward;
    private final DoubleSupplier m_turn;

    public DriveCommand(DoubleSupplier forward, DoubleSupplier turn) {

        m_forward = forward;
        m_turn = turn;

        m_drive = Drive.getInstance();
        addRequirements(m_drive);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_drive.drive(m_forward.getAsDouble() * Math.abs(m_forward.getAsDouble()),
            -m_turn.getAsDouble());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
