package org.frc571.bradley.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import org.frc571.bradley.subsystems.Drive;
import org.frc571.bradley.Constants.AutonomousConstants;

public class AutonomousDriveCommand extends CommandBase {

    private final Drive drive;
    private double speed = SmartDashboard.getNumber("AutonomousCommand/Autonomous timeout",
            AutonomousConstants.AUTONOMOUS_COMMAND_SPEED);

    public AutonomousDriveCommand() {

        drive = Drive.getInstance();
        addRequirements(drive);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        if (!SmartDashboard.containsKey("AutonomousCommand/Autonomous speed")) {
            SmartDashboard.putNumber("AutonomousCommand/Autonomous speed",
                    AutonomousConstants.AUTONOMOUS_COMMAND_SPEED);
        }
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        speed = SmartDashboard.getNumber("AutonomousCommand/Autonomous speed",
                AutonomousConstants.AUTONOMOUS_COMMAND_SPEED);
        drive.drive(speed, 0, false);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        drive.drive(0.0, 0.0, false);
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
