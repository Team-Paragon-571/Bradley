package org.frc571.bradley.commands;

import org.frc571.bradley.subsystems.IntakeArms;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RaiseIntake extends CommandBase {
    final IntakeArms arm;
    boolean first = true;

    final IntakeArms.ArmDirection dir;

    public RaiseIntake() {
        dir = IntakeArms.ArmDirection.UP;
        arm = IntakeArms.getInstance();
        
        addRequirements(arm);
    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        arm.move(dir);
    }

    @Override
    public void end(boolean interrupted) {
        arm.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return arm.isTopLimitSwitchPressed();
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}