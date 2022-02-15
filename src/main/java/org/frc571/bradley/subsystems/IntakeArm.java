package org.frc571.bradley.subsystems;

import static org.frc571.bradley.Constants.DigitalConstants;
import static org.frc571.bradley.Constants.MotorConstants;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;

public class IntakeArm extends ParagonSubsystemBase {

    private static IntakeArm intakeArm;

    private String name;
    private WPI_VictorSPX motorMaster;
    private WPI_VictorSPX motorFollower;
    private DigitalInput limitTop;
    private DigitalInput limitBottom;

    private IntakeArm() {
        name = getClass().getName();
        motorMaster = new WPI_VictorSPX(MotorConstants.kLeftIntakeArmPort);
        motorFollower = new WPI_VictorSPX(MotorConstants.kRightIntakeArmPort);
        limitTop = new DigitalInput(DigitalConstants.kLimitSwitchIntakeArmTopPort);
        limitBottom = new DigitalInput(DigitalConstants.kLimitSwitchIntakeArmBottomPort);

        addChild("motorMaster", motorMaster);
        addChild("motorFollower", motorFollower);

        motorFollower.follow(motorMaster);
        
        motorMaster.setInverted(true);
        motorFollower.setInverted(InvertType.FollowMaster);
    }

    public static synchronized IntakeArm getInstance() {
        if (intakeArm == null) {
            intakeArm = new IntakeArm();
        }
        return intakeArm;
    }

    @Override
    public void outputTelemetry() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void stop() {
        motorMaster.stopMotor();
        motorFollower.stopMotor();
    }

    public void setSpeed(double speed) {
        motorMaster.set(speed);
    }

    public boolean getLimitSwitchTop() {
        return limitTop.get();
    }

    public boolean getLimitSwitchBottom() {
        return limitBottom.get();
    }

    public boolean getLimitSwitchTripped() {
        return limitBottom.get() || limitTop.get();
    }

}
