package org.frc571.bradley.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class ParagonSubsystemBase extends SubsystemBase {

    public abstract void outputTelemetry();
    public abstract String getName();
    public abstract void stop();
    
}
