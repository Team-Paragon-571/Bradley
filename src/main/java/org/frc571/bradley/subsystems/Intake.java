package org.frc571.bradley.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

/**
 *
 */
public class Intake extends ParagonSubsystemBase {

    private static Intake intake;

    private PWMVictorSPX intakeMotor;

    private String name = "Intake";

    /**
     * Takes in game pieces off the floor
     */
    private Intake() {
        intakeMotor = new PWMVictorSPX(5);
        addChild("IntakeMotor", intakeMotor);
        intakeMotor.setInverted(false);

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

}
