package org.frc571.bradley.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class Index extends ParagonSubsystemBase {
    private static Index index;

    private String name = "Index";
    private PWMVictorSPX indexMotor;

    /**
    *
    */
    private Index() {
        indexMotor = new PWMVictorSPX(6);
        addChild("IndexMotor", indexMotor);
        indexMotor.setInverted(false);
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

}
