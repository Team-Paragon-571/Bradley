
package org.frc571.bradley.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.frc571.bradley.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Hopper extends ParagonSubsystemBase {
    private static Hopper hopper;

    private String name = "Index";
    private WPI_TalonSRX hopperMotor;
    private DigitalInput frontInput;
    private DigitalInput backInput;

    private Hopper() {
        hopperMotor = new WPI_TalonSRX(Constants.MotorConstants.kLeftIndexMotor);
        addChild("IndexMotor", hopperMotor);
        hopperMotor.setInverted(false);

        frontInput = new DigitalInput(Constants.DigitalConstants.kFrontInput);
        backInput = new DigitalInput(Constants.DigitalConstants.kBackInput);
        hopperMotor.setNeutralMode(NeutralMode.Coast);
    }

    public static synchronized Hopper getInstance() {
        if (hopper == null) {
            hopper = new Hopper();
        }
        return hopper;
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
        hopperMotor.stopMotor();

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
        hopperMotor.set(0.5);
    }

    public void reverse() {
        hopperMotor.set(-0.5);
    }
}
