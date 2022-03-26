package org.frc571.bradley.subsystems;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PowerDistributionPanel extends ParagonSubsystemBase {
    private static PowerDistributionPanel powerDistributionPanel;
    private PowerDistribution pdp;

    private PowerDistributionPanel() {
        pdp = new PowerDistribution(0, ModuleType.kCTRE);
        addChild(getClass().getName(), pdp);
        System.out.println("--->>> created new PowerDistribution Panel");
    }

    public static PowerDistributionPanel getInstance() {
        if (powerDistributionPanel != null) {
            powerDistributionPanel = new PowerDistributionPanel();
        }
        return powerDistributionPanel;
    }

    @Override
    public void periodic() {
        outputTelemetry();
    }

    @Override
    public void outputTelemetry() {
        SmartDashboard.putNumber(getName() + "/Front Left Drive Motor", pdp.getCurrent(14)); // 14
        SmartDashboard.putNumber(getName() + "/Front Right Drive Motor", pdp.getCurrent(1)); // 1
        SmartDashboard.putNumber(getName() + "/Rear Left Drive Motor", pdp.getCurrent(15)); // 15
        SmartDashboard.putNumber(getName() + "/Rear Right Drive Motor", pdp.getCurrent(0)); // 0
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public void stop() {
        // Nothing to stop
    }

}
