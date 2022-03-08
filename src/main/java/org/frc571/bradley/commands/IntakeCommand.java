
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
        intake.setSpeed(SpeedConstants.kIntakeMotorSpeed);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (index.getFrontInput()) {
            index.turn();
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        index.stop();
        intake.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (index.getRearInput() || index.getRearInput()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
