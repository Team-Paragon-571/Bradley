package org.frc571.bradley.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends ParagonSubsystemBase {
    private static Drive drive;
    private WPI_TalonFX lMaster;
    private WPI_TalonFX lFollower;
    private WPI_TalonFX rMaster;
    private WPI_TalonFX rFollower;
    private DifferentialDrive differentialDrive;

    private Drive() {
        lMaster = new WPI_TalonFX(1);
        rMaster = new WPI_TalonFX(3);

        lMaster.setInverted(false);
        rMaster.setInverted(true);

        addChild("lFront", lMaster);
        addChild("rFront", rMaster);

        lMaster.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 20);

        lFollower = new WPI_TalonFX(2);
        rFollower = new WPI_TalonFX(4);

        addChild("lFollower", lFollower);
        addChild("rFollower", rFollower);

        lFollower.follow(lMaster);
        rFollower.follow(rMaster);

        lFollower.setInverted(InvertType.FollowMaster);
        rFollower.setInverted(InvertType.FollowMaster);

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
    public void drive(double speed, double curvature, boolean isSpinning) {
        differentialDrive.curvatureDrive(speed, curvature, isSpinning);
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
        SmartDashboard.putNumber(getName() + "Drive/LeftMotor/Encoder",
                getRMasterMotor().getSelectedSensorPosition());
        SmartDashboard.putNumber("Drive/RightMotor/Encoder", getRMasterMotor().getSelectedSensorPosition());
        // TODO: add Pigeon IMU telemetry
        // SmartDashboard.putNumber(getName() + "Drive/Pigeon/Yaw", pigeon.getYaw());

    }

    @Override
    public void stop() {
        drive(0, 0, false);

    }

    @Override
    public String getName() {
        return "Drive";
    }

}
