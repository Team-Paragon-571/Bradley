package org.frc571.bradley.subsystems;

import static org.frc571.bradley.Constants.DigitalConstants;
import static org.frc571.bradley.Constants.MotorConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;

public class IntakeArm extends ParagonSubsystemBase {

    private static IntakeArm intakeArm;

    private String name;
    private CANSparkMax motorLeft;
    private CANSparkMax motorRight;
    private DigitalInput limitTopLeft;
    private DigitalInput limitTopRight;
    private DigitalInput limitBottomLeft;
    private DigitalInput limitBottomRight;

    private IntakeArm() {
        name = getClass().getName();
        motorLeft = new CANSparkMax(MotorConstants.kLeftIntakeArmPort, MotorType.kBrushless);
        motorRight = new CANSparkMax(MotorConstants.kRightIntakeArmPort, MotorType.kBrushless);
        limitTopLeft = new DigitalInput(DigitalConstants.TOP_LEFT_LIMIT_SWITCH);
        limitTopRight = new DigitalInput(DigitalConstants.TOP_RIGHT_LIMIT_SWITCH);
        limitBottomLeft = new DigitalInput(DigitalConstants.BOTTOM_LEFT_LIMIT_SWITCH);
        limitBottomRight = new DigitalInput(DigitalConstants.BOTTOM_RIGHT_LIMIT_SWITCH);

        motorRight.follow(motorLeft);

        motorLeft.setInverted(true);
        motorRight.setInverted(true);
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
        motorLeft.stopMotor();
        motorRight.stopMotor();
    }
    public void setRightSpeed(double speed) {
        motorRight.set(speed);
    }


    public void setLeftSpeed(double speed) {
        motorLeft.set(speed);
    }

    public boolean getLimitSwitchTopLeft() {
        return limitTopLeft.get();
    }

    public boolean getLimitSwitchBottomLeft() {
        return limitBottomLeft.get();
    }

    public boolean getLimitSwitchTopRight() {
        return limitTopRight.get();
    }

    public boolean getLimitSwitchBottomRight() {
        return limitBottomRight.get();
    }

}
