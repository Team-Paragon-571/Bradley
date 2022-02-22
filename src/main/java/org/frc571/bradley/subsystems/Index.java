
package org.frc571.bradley.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class Index extends ParagonSubsystemBase {
    private static Index index;

    private String name = "Index";
    private PWMVictorSPX indexMotor;
    private DigitalInput frontInput;
    private DigitalInput middleInput;
    private DigitalInput backInput;

    private Index() {
        indexMotor = new PWMVictorSPX(6);
        addChild("IndexMotor", indexMotor);
        indexMotor.setInverted(false);

        frontInput = new DigitalInput(1);
        middleInput = new DigitalInput(2);
        backInput = new DigitalInput(3);
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
        indexMotor.stopMotor();

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
        indexMotor.set(0.5);
    }
}
