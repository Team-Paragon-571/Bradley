package org.frc571.bradley.commands;

import org.frc571.bradley.subsystems.IntakeArm;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RaiseIntake extends CommandBase {
    IntakeArm arm;

    public RaiseIntake() {
        arm = IntakeArm.getInstance();

        addRequirements(arm);
    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        arm.setSpeed(0.3);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        arm.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return arm.getLimitSwitchTop();
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }

}
