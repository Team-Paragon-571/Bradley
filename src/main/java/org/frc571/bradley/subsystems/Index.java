
package org.frc571.bradley.subsystems;

import org.frc571.bradley.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class Index extends ParagonSubsystemBase {
    private static Index index;

    private String name = "Index";
    private PWMVictorSPX IndexMotor;
    private DigitalInput frontInput;
    private DigitalInput backInput;

    private Index() {
        IndexMotor = new PWMVictorSPX(Constants.MotorConstants.kLeftIndexMotor);
        addChild("IndexMotor", IndexMotor);
        IndexMotor.setInverted(false);

        frontInput = new DigitalInput(Constants.DigitalConstants.kFrontInput);
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
        return name;
    }

    @Override
    public void stop() {
        IndexMotor.stopMotor();

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public boolean getFrontInput() {
        return frontInput.get();
    }

    public boolean getBackInput() {
        return backInput.get();
    }
    public void turn() {
        IndexMotor.set(0.5);
    }
}
