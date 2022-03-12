package org.frc571.bradley.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.frc571.bradley.Constants.MotorConstants;

import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Intake extends ParagonSubsystemBase {

    private static Intake intake;

    private CANSparkMax intakeMotor;

    private String name = "Intake";

    /**
     * Takes in game pieces off the floor
     */
    private Intake() {
        intakeMotor = new CANSparkMax(MotorConstants.INTAKE_MOTOR, MotorType.kBrushless);
        intakeMotor.setInverted(true);

    }

    public static synchronized Intake getInstance() {
        if (intake == null) {
            intake = new Intake();
        }

        return intake;

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
        // TODO put data on the smart dashboard

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void stop() {
        intakeMotor.stopMotor();

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void setSpeed(double speed) {
        intakeMotor.set(speed);
    }

}
