package org.frc571.bradley.commands;
import org.frc571.bradley.Constants.DriveConstants;
import org.frc571.bradley.subsystems.Drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
public class HangDriveCommand extends CommandBase {
    private final Drive m_drive;


    public HangDriveCommand() {
        m_drive = Drive.getInstance();
        addRequirements(m_drive);

        if(!SmartDashboard.containsKey(DriveConstants.kMaxHangOutputKey)) {
            SmartDashboard.putNumber(DriveConstants.kMaxHangOutputKey, DriveConstants.kMaxHangOutput);
        }
    }


    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        int direction = m_drive.getDirection() ? 1 : -1;
        m_drive.drive(direction * SmartDashboard.getNumber(
            DriveConstants.kMaxHangOutputKey, 
            DriveConstants.kMaxHangOutput), 0.0);
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
