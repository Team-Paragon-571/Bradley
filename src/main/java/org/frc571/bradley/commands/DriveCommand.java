package org.frc571.bradley.commands;

import static org.frc571.bradley.Constants.ControlConstants.kDeadzone;

import java.util.function.DoubleSupplier;

import org.frc571.bradley.subsystems.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {

    private final Drive m_drive;
    private final Double m_forward;
    private final Double m_turn;

    public DriveCommand(Double forward, Double turn) {

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
        m_drive.drive(m_forward * Math.abs(m_forward)*0.60, -m_turn * 0.30);
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
