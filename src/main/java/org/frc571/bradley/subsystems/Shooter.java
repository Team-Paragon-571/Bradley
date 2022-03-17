package org.frc571.bradley.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.frc571.bradley.Constants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends ParagonSubsystemBase {
    private static Shooter shooter;
    private String name = "shoot";
    private WPI_TalonSRX shootMotor;

    private Shooter() {
        shootMotor = new WPI_TalonSRX(Constants.MotorConstants.kShooterMotor);
        addChild("ShootMotor", shootMotor);
        shootMotor.setInverted(false);
        shootMotor.setNeutralMode(NeutralMode.Coast);

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
        SmartDashboard.putData(shootMotor);
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
