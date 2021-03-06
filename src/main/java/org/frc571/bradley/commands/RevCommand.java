package org.frc571.bradley.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import org.frc571.bradley.subsystems.Shooter;

public class RevCommand extends CommandBase {

    private final Shooter shooter;
    private final double speed;

    public RevCommand(double speed) {
        this.speed = speed;
        shooter = Shooter.getInstance();
        addRequirements(shooter);

    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        shooter.shoot(speed);
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
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
