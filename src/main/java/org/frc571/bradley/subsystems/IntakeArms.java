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
    final private CANSparkMax motor;
    final private DigitalInput limitTop;
    final private DigitalInput limitBottom;
    
    public enum ArmDirection {
        UP,
        DOWN
    }

    private IntakeArms() {
        name = getClass().getName();
        motor = new CANSparkMax(MotorConstants.kLeftIntakeArmPort, MotorType.kBrushless);
        limitTop = new DigitalInput(DigitalConstants.TOP_LEFT_LIMIT_SWITCH);
        limitBottom = new DigitalInput(DigitalConstants.BOTTOM_LEFT_LIMIT_SWITCH);

        motor.restoreFactoryDefaults();

        motor.setIdleMode(CANSparkMax.IdleMode.kBrake);

    }

    public static synchronized IntakeArms getInstance() {
        if (intakeArm == null) {
            intakeArm = new IntakeArms();
        }
        return intakeArm;
    }

    @Override
    public void outputTelemetry() {
        SmartDashboard.putBoolean("Upper Left Limit Switch", isTopLimitSwitchPressed());
        SmartDashboard.putBoolean("Lower Limit Switch", isBottomLimitSwitchPressed());
        SmartDashboard.putNumber("Motor Speed", motor.get());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void stop() {
        motor.stopMotor();
    }
    
    public void move(ArmDirection dir, double speed) {
        switch (dir) {
            case UP: 
                motor.set((!isTopLimitSwitchPressed() ? speed : 0));
                break;
            case DOWN:
                motor.set((!isBottomLimitSwitchPressed() ? -speed : 0));
                break;
        }
    }

    public void move(ArmDirection dir) {
        move(dir, SpeedConstants.kIntakeMotorSpeed);
    }

    public boolean isTopLimitSwitchPressed() {
        return !limitTop.get();
    }

    public boolean isBottomLimitSwitchPressed() {
        return !limitBottom.get();
    }

}
