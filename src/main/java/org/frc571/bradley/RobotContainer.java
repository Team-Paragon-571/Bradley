package org.frc571.bradley;

import org.frc571.bradley.Constants.AutonomousConstants;
import org.frc571.bradley.Constants.ControlConstants;
import org.frc571.bradley.commands.AutonomousDriveCommand;
import org.frc571.bradley.commands.AutonomousShootDriveCommand;
import org.frc571.bradley.commands.DriveCommand;
import org.frc571.bradley.commands.EjectCommand;
import org.frc571.bradley.commands.TogglePrecisionTurnMode;
import org.frc571.bradley.commands.HangDriveCommand;
import org.frc571.bradley.commands.IntakeCommand;
import org.frc571.bradley.commands.LowerIntake;
import org.frc571.bradley.commands.RaiseIntake;
import org.frc571.bradley.commands.ShootCommand;
import org.frc571.bradley.commands.ToggleDirectionCommand;
import org.frc571.bradley.subsystems.Drive;
import org.frc571.bradley.subsystems.Hopper;
import org.frc571.bradley.subsystems.Intake;
import org.frc571.bradley.subsystems.Shooter;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.cameraserver.CameraServer;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot
 * (including subsystems, commands, and button mappings) should be declared
 * here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

  // Subsystems
  public final Shooter m_shooter = Shooter.getInstance();
  public final Hopper m_hopper = Hopper.getInstance();
  public final Intake m_intake = Intake.getInstance();
  public final Drive m_drive = Drive.getInstance();

  // Joysticks
  private final XboxController driveController = new XboxController(0);

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */

  private RobotContainer() {

    CameraServer.startAutomaticCapture();

    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands0
    m_drive.setDefaultCommand(
        new DriveCommand(
            () -> Controller.ApplyJoystickDeadzone(
                driveController.getLeftY(),
                Constants.ControlConstants.kDeadzone),
            () -> Controller.ApplyJoystickDeadzone(
                driveController.getRightX(),
                Constants.ControlConstants.kDeadzone)));

    if (!SmartDashboard.containsKey("AutonomousCommand/Autonomous timeout")) {
      SmartDashboard.putNumber("AutonomousCommand/Autonomous timeout",
          AutonomousConstants.AUTONOMOUS_COMMAND_DURATION);
    }
    double duration = SmartDashboard.getNumber("AutonomousCommand/Autonomous timeout",
        AutonomousConstants.AUTONOMOUS_COMMAND_DURATION);
    m_chooser.setDefaultOption("ShootDrive", new AutonomousShootDriveCommand(duration));
    m_chooser.addOption("AutonomousDrive", new AutonomousDriveCommand().withTimeout(duration));
    SmartDashboard.putData("Auto Mode", m_chooser);

  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Create some buttons
    final JoystickButton ejectButton = new JoystickButton(driveController, XboxController.Button.kY.value);
    ejectButton.whenPressed(new LowerIntake());
    ejectButton.whileHeld(new EjectCommand(), true);

    final AnalogButton shootButton = new AnalogButton(driveController, XboxController.Axis.kRightTrigger.value,
        ControlConstants.SHOOT_TRIGGER_THRESHOLD);
    shootButton.whenHeld(new ShootCommand());

    final JoystickButton stopIntakeButton = new JoystickButton(driveController, XboxController.Button.kB.value);
    stopIntakeButton.whenPressed(new RaiseIntake(), true);

    final JoystickButton intakeButton = new JoystickButton(driveController, XboxController.Button.kA.value);
    intakeButton.whenPressed(new IntakeCommand(), true);

    final POVButton raiseIntakeButton = new POVButton(driveController, 0);
    raiseIntakeButton.whenHeld(new RaiseIntake());

    final POVButton lowerIntakeButton = new POVButton(driveController, 180);
    lowerIntakeButton.whenHeld(new LowerIntake());

    final JoystickButton toggleDirectionButton = new JoystickButton(driveController,
        XboxController.Button.kLeftStick.value);
    toggleDirectionButton.whenPressed(new ToggleDirectionCommand());

    final JoystickButton togglePrecisionTurnModeButton = new JoystickButton(driveController,
        XboxController.Button.kRightStick.value);
    togglePrecisionTurnModeButton.whenHeld(new TogglePrecisionTurnMode());

    final JoystickButton driveAtMaxLowHangSpeed = new JoystickButton(driveController, 
    XboxController.Button.kX.value);
    driveAtMaxLowHangSpeed.whenHeld(new HangDriveCommand());
  }

  public XboxController getDriveController() {
    return driveController;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }

  public Drive getDrive() {
    return m_drive;
  }

}
