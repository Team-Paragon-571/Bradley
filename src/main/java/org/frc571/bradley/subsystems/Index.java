
package org.frc571.bradley.subsystems;

import org.frc571.bradley.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class Index extends ParagonSubsystemBase {
    private static Index index;

    private String name = "Index";
    private PWMVictorSPX leftIndexMotor,rightIndexMotor;
    private DigitalInput frontInput;
    private DigitalInput middleInput;
    private DigitalInput backInput;

    private Index() {
        leftIndexMotor = new PWMVictorSPX(Constants.MotorConstants.kLeftIndexMotor);
        rightIndexMotor = new PWMVictorSPX(Constants.MotorConstants.kRightIndexMotor);
        addChild("IndexMotor", leftIndexMotor);
        addChild("IndexMotor", rightIndexMotor);
        leftIndexMotor.setInverted(false);
        rightIndexMotor.setInverted(false);

        frontInput = new DigitalInput(Constants.DigitalConstants.kFrontInput);
        middleInput = new DigitalInput(Constants.DigitalConstants.kMiddleInput);
        backInput = new DigitalInput(Constants.DigitalConstants.kBackInput);
    }

    public static synchronized Index getInstance() {
        if (index == null) {
            index = new Index();
        }
        return index;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    @Override
    public void outputTelemetry() {
        // TODO Add telemetry to smart dashboard

    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public void stop() {
        leftIndexMotor.stopMotor();
        rightIndexMotor.stopMotor();

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public boolean getFrontInput() {
        return frontInput.get();
    }

    public boolean getMiddleInput() {
        return middleInput.get();
    }

    public boolean getBackInput() {
        return backInput.get();
    }
    public void turn() {
        rightIndexMotor.set(0.5);
        leftIndexMotor.set(0.5);
    }
}
