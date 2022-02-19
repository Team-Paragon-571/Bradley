package org.frc571.bradley.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import org.frc571.bradley.subsystems.Shooter;

public class ShootCommand extends CommandBase {

    private final Shooter m_shoot;

    public ShootCommand(Shooter subsystem) {

        m_shoot = subsystem;
        addRequirements(m_shoot);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
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
