package org.frc571.bradley.commands;

import static org.frc571.bradley.Constants.ControlConstants.kDeadzone;

import java.util.function.DoubleSupplier;

import org.frc571.bradley.subsystems.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {

    private final Drive m_drive;
    private DoubleSupplier m_forward;
    private DoubleSupplier m_turn;

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
        m_drive.drive(m_forward.getAsDouble() * 0.5, -m_turn.getAsDouble() * 0.5,
                // If the robot isn't moving, spin in place
                (Math.abs(m_forward.getAsDouble()) < kDeadzone));
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
