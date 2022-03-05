
package org.frc571.bradley.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import org.frc571.bradley.subsystems.Index;
import org.frc571.bradley.subsystems.Intake;
import org.frc571.bradley.Constants.SpeedConstants;

public class IntakeCommand extends CommandBase {

    private final Index index;
    private final Intake intake;

    public IntakeCommand() {

        index = Index.getInstance();
        addRequirements(index);
        intake = Intake.getInstance();
        addRequirements(index);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        LowerIntake lower = new LowerIntake();
        while (!lower.isFinished()) {
            // wait while intake lowers
        }
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        index.turn();
        intake.setSpeed(SpeedConstants.kIntakeMotorSpeed);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        index.stop();
        intake.setSpeed(-SpeedConstants.kIntakeMotorSpeed);
        RaiseIntake raise = new RaiseIntake();
        while (!raise.isFinished()) {
            // wait while intake raises
        }
        intake.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (index.getFrontInput() && index.getBackInput()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
