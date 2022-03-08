package org.frc571.bradley.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.frc571.bradley.Constants;

public class Shooter extends ParagonSubsystemBase {
    private static Shooter shooter;
    private String name = "shoot";
    private WPI_TalonSRX shootMotor;

    private Shooter() {
        shootMotor = new WPI_TalonSRX(Constants.MotorConstants.SHOOTER_MOTOR);
        addChild("ShootMotor", shootMotor);
        shootMotor.setInverted(false);

    }

    public static synchronized Shooter getInstance() {
        if (shooter == null) {
            shooter = new Shooter();
        }
        return shooter;
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
        // TODO: Put data on the smart dashboard

    }

    @Override
    public String getName() {

        return name;
    }

    public void shoot() {
        shootMotor.set(Constants.ControlConstants.kShootMotor);
    }

    @Override
    public void stop() {
        shootMotor.stopMotor();
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
