package org.frc571.bradley.subsystems;

import static org.frc571.bradley.Constants.DigitalConstants;
import static org.frc571.bradley.Constants.MotorConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.frc571.bradley.Constants.SpeedConstants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeArms extends ParagonSubsystemBase {

    private static IntakeArms intakeArm;

    final private String name;
    final private CANSparkMax motorLeft;
    final private CANSparkMax motorRight;
    final private DigitalInput limitTopLeft;
    final private DigitalInput limitTopRight;
    final private DigitalInput limitBottomLeft;
    final private DigitalInput limitBottomRight;
    
    public enum ArmSide {
        LEFT,
        RIGHT
    }
    
    public enum ArmDirection {
        UP,
        DOWN
    }

    private IntakeArms() {
        name = getClass().getName();
        motorLeft = new CANSparkMax(MotorConstants.kLeftIntakeArmPort, MotorType.kBrushless);
        motorRight = new CANSparkMax(MotorConstants.kRightIntakeArmPort, MotorType.kBrushless);
        limitTopLeft = new DigitalInput(DigitalConstants.TOP_LEFT_LIMIT_SWITCH);
        limitTopRight = new DigitalInput(DigitalConstants.TOP_RIGHT_LIMIT_SWITCH);
        limitBottomLeft = new DigitalInput(DigitalConstants.BOTTOM_LEFT_LIMIT_SWITCH);
        limitBottomRight = new DigitalInput(DigitalConstants.BOTTOM_RIGHT_LIMIT_SWITCH);


        motorLeft.restoreFactoryDefaults();
        motorRight.restoreFactoryDefaults();

        motorLeft.setIdleMode(CANSparkMax.IdleMode.kBrake);
        motorRight.setIdleMode(CANSparkMax.IdleMode.kBrake);

        // motorLeft.setSmartCurrentLimit(limit)

    }

    public static synchronized IntakeArms getInstance() {
        if (intakeArm == null) {
            intakeArm = new IntakeArms();
        }
        return intakeArm;
    }

    @Override
    public void outputTelemetry() {
        SmartDashboard.putBoolean("Upper Left Limit Switch", isTopLeftLimitSwitchPressed());
        SmartDashboard.putBoolean("Lower Limit Switch", isBottomLeftLimitSwitchPressed());
        SmartDashboard.putBoolean("Upper Right Limit Switch", isTopRightLimitSwitchPressed());
        SmartDashboard.putBoolean("Lower Right Limit Switch", isBottomRightLimitSwitchPressed());
        SmartDashboard.putNumber("Left Motor Speed", motorLeft.get());
        SmartDashboard.putNumber("Right Motor Speed", motorRight.get());
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
    
    public void stop(ArmSide side) {
        switch (side) {
            case LEFT:
                motorLeft.stopMotor();
                break;
            case RIGHT:
                motorRight.stopMotor();
                break;
        }
    }

    public void move(ArmDirection dir, double speed) {
        switch (dir) {
            case UP: 
                motorRight.set((!isTopRightLimitSwitchPressed() ? speed : 0));
                motorLeft.set((!isTopLeftLimitSwitchPressed() ? speed : 0));
                break;
            case DOWN:
                motorRight.set((!isBottomRightLimitSwitchPressed() ? -speed: 0));
                motorLeft.set((!isBottomLeftLimitSwitchPressed() ? -speed : 0));
                break;
        }
    }

    public void move(ArmDirection dir) {
        move(dir, SpeedConstants.kIntakeMotorSpeed);
    }

    public boolean isTopLeftLimitSwitchPressed() {
        return !limitTopLeft.get();
    }

    public boolean isBottomLeftLimitSwitchPressed() {
        return !limitBottomLeft.get();
    }

    public boolean isTopRightLimitSwitchPressed() {
        return !limitTopRight.get();
    }

    public boolean isBottomRightLimitSwitchPressed() {
        return !limitBottomRight.get();
    }

}
