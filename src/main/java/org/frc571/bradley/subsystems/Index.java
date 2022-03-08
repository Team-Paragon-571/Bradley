
package org.frc571.bradley.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import org.frc571.bradley.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Index extends ParagonSubsystemBase {
    private static Index index;

    private String name = "Index";
    private WPI_VictorSPX indexMotor;
    private DigitalInput frontInput;
    private DigitalInput rearInput;

    private Index() {
        indexMotor = new WPI_VictorSPX(Constants.MotorConstants.INDEX_MOTOR);
        addChild("IndexMotor", indexMotor);
        indexMotor.setInverted(false);

        frontInput = new DigitalInput(Constants.DigitalConstants.FRONT_INPUT);
        rearInput = new DigitalInput(Constants.DigitalConstants.REAR_INPUT);
    }

    public static synchronized Index getInstance() {
        if (index == null) {
            index = new Index();
        }
        return index;
    }

    @Override
    public void periodic() {
    }

    @Override
    public void simulationPeriodic() {
    }

    @Override
    public void outputTelemetry() {
        SmartDashboard.putBoolean(getName() + "/Front Input", frontInput.get());
        SmartDashboard.putBoolean(getName() + "/Back Input", backInput.get());

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void stop() {
        indexMotor.stopMotor();

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public boolean getFrontInput() {
        return !frontInput.get();
    }

    public boolean getRearInput() {
        return !rearInput.get();
    }


    public void turn() {
        indexMotor.set(0.5);
    }

    public void reverse() {
        IndexMotor.set(-0.5);
    }
}
