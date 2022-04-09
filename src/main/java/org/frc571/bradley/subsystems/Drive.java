package org.frc571.bradley.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import org.frc571.bradley.Constants.DriveConstants;
// import org.frc571.bradley.Constants.TimeConstants;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends ParagonSubsystemBase {
    private static Drive drive;
    private WPI_TalonFX lMaster;
    private WPI_TalonFX lFollower;
    private WPI_TalonFX rMaster;
    private WPI_TalonFX rFollower;
    private DifferentialDrive differentialDrive;
    private boolean direction = true;
    private double maxDriveSpeed = DriveConstants.kMaxOutput;
    // private double rampTime = TimeConstants.RAMP_TIME;
    private double turnSpeed = 0.3;
    private boolean precisionTurnMode = false;

    private Drive() {
        lMaster = new WPI_TalonFX(1);
        lMaster.configFactoryDefault();
        rMaster = new WPI_TalonFX(3);
        rMaster.configFactoryDefault();

        lMaster.setInverted(true);
        rMaster.setInverted(false);
        lMaster.setNeutralMode(NeutralMode.Coast);
        rMaster.setNeutralMode(NeutralMode.Coast);

        addChild("lFront", lMaster);
        addChild("rFront", rMaster);

        lMaster.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 20);

        lFollower = new WPI_TalonFX(2);
        lFollower.configFactoryDefault();
        rFollower = new WPI_TalonFX(4);
        rFollower.configFactoryDefault();

        addChild("lFollower", lFollower);
        addChild("rFollower", rFollower);

        lFollower.follow(lMaster);
        rFollower.follow(rMaster);

        lFollower.setInverted(InvertType.FollowMaster);
        rFollower.setInverted(InvertType.FollowMaster);
        lFollower.setNeutralMode(NeutralMode.Coast);
        rFollower.setNeutralMode(NeutralMode.Coast);

        differentialDrive = new DifferentialDrive(lMaster, rMaster);
        addChild("DifferentialDrive", differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

    }

    public synchronized static Drive getInstance() {
        if (drive == null) {
            drive = new Drive();
        }
        return drive;
    }

    @Override
    public void periodic() {
        // if (!SmartDashboard.containsKey(DriveConstants.RAMP_TIME_KEY)) {
        //     SmartDashboard.putNumber(DriveConstants.RAMP_TIME_KEY, rampTime);
        // }
        // rampTime = SmartDashboard.getNumber(DriveConstants.RAMP_TIME_KEY, rampTime);

        if (!SmartDashboard.containsKey(DriveConstants.kMaxOutputKey)) {
            SmartDashboard.putNumber(DriveConstants.kMaxOutputKey, maxDriveSpeed);

        }
        maxDriveSpeed = SmartDashboard.getNumber(DriveConstants.kMaxOutputKey, maxDriveSpeed);

        if (!SmartDashboard.containsKey(DriveConstants.TURN_SPEED_SCALE_KEY)) {
            SmartDashboard.putNumber(DriveConstants.TURN_SPEED_SCALE_KEY, turnSpeed);

        }
        turnSpeed = SmartDashboard.getNumber(DriveConstants.TURN_SPEED_SCALE_KEY, turnSpeed);
        // This method will be called once per scheduler run
        outputTelemetry();
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    /**
     * Cheesy driving for the drivetrain.
     * 
     * @param speed      robot Speed from [-1.0..1.0]
     * @param curvature  robot turn radius from [-1.0..1.0]
     * @param isSpinning whether or not the robot is spinning in place
     */
    public void drive(double speed, double curvature) {
        differentialDrive.curvatureDrive(speed * (direction ? 1 : -1), curvature * turnSpeed,
                speed == 0);
    }

    /**
     * Get the left master motor
     * 
     * @return the left master motor
     */
    public WPI_TalonFX getLMasterMotor() {
        return lMaster;
    }

    /**
     * Get the right master motor
     * 
     * @return the right master motor
     */
    public WPI_TalonFX getRMasterMotor() {
        return rMaster;
    }

    /**
     * Get the left follower motor
     * 
     * @return the left follower motor
     */
    public WPI_TalonFX getLFollowerMotor() {
        return lFollower;
    }
    
    public double getMaxDriveSpeed() {
        return maxDriveSpeed;
    }

    /**
     * Get the right follower motor
     * 
     * @return the right follower motor
     */
    public WPI_TalonFX getRFollowerMotor() {
        return rFollower;
    }

    @Override
    public void outputTelemetry() {
        SmartDashboard.putNumber("drive/LeftMotor/Encoder",
                getRMasterMotor().getSelectedSensorPosition());
        SmartDashboard.putNumber("drive/RightMotor/Encoder", getRMasterMotor().getSelectedSensorPosition());
        // TODO: add Pigeon IMU telemetry
        // SmartDashboard.putNumber(getName() + "Drive/Pigeon/Yaw", pigeon.getYaw());

    }

    @Override
    public void stop() {
        drive(0, 0);

    }

    @Override
    public String getName() {
        return "drive";
    }

    public void toggleDirection() {
        direction = !direction;
    }

    public boolean getDirection() {
        return direction;
    }

    public boolean isPrecisionTurnMode() {
        return precisionTurnMode;
    }

    public void togglePrecisionTurnMode() {
        precisionTurnMode = !precisionTurnMode;
        if (precisionTurnMode) {
            lMaster.setNeutralMode(NeutralMode.Brake);
            rMaster.setNeutralMode(NeutralMode.Brake);
            lFollower.setNeutralMode(NeutralMode.Brake);
            rFollower.setNeutralMode(NeutralMode.Brake);
        } else {
            lMaster.setNeutralMode(NeutralMode.Coast);
            rMaster.setNeutralMode(NeutralMode.Coast);
            lFollower.setNeutralMode(NeutralMode.Coast);
            rFollower.setNeutralMode(NeutralMode.Coast);
        }
    }

}
