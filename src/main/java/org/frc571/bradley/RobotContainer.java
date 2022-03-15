package org.frc571.bradley;

import org.frc571.bradley.Constants.AutonomousConstants;
import org.frc571.bradley.commands.AutonomousCommand;
import org.frc571.bradley.commands.DriveCommand;
import org.frc571.bradley.commands.EjectCommand;
import org.frc571.bradley.commands.IntakeCommand;
import org.frc571.bradley.commands.LowerIntake;
import org.frc571.bradley.commands.RaiseIntake;
import org.frc571.bradley.commands.ShootCommand;
import org.frc571.bradley.commands.StopIntakeCommand;
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

  // The robot's subsystems
  public final Shooter m_shoot = Shooter.getInstance();
  public final Hopper m_hopper = Hopper.getInstance();
  public final Intake m_intake = Intake.getInstance();
  public final Drive m_drive = Drive.getInstance();
  // Joysticks
  private final XboxController driveController = new XboxController(0);
  private final XboxController operatorController = new XboxController(0);

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */

  private RobotContainer() {

    CameraServer.startAutomaticCapture();

    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    m_drive.setDefaultCommand(new DriveCommand(driveController::getLeftY, driveController::getRightX));
    if (!SmartDashboard.containsKey("AutonomousCommand/Autonomous timeout")) {
      SmartDashboard.putNumber("AutonomousCommand/Autonomous timeout",
          AutonomousConstants.AUTONOMOUS_COMMAND_DURATION);
    }
    // Configure autonomous sendable chooser
    m_chooser.setDefaultOption("AutonomousCommand", new AutonomousCommand().withTimeout(
        SmartDashboard.getNumber("AutonomousCommand/Autonomous timeout",
            AutonomousConstants.AUTONOMOUS_COMMAND_DURATION)));

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
   * it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Create some buttons
    final JoystickButton ejectButton = new JoystickButton(driveController, XboxController.Button.kX.value);
    ejectButton.whenPressed(new EjectCommand(), true);

    final JoystickButton stopIntakeButton = new JoystickButton(driveController, XboxController.Button.kB.value);
    stopIntakeButton.whenPressed(new StopIntakeCommand(), true);

    final JoystickButton shootButton = new JoystickButton(driveController, XboxController.Button.kY.value);
    shootButton.whileHeld(new ShootCommand(), true);

    final JoystickButton intakeButton = new JoystickButton(driveController, XboxController.Button.kA.value);
    intakeButton.whenPressed(new IntakeCommand(), true);

    final JoystickButton raiseIntakeButton = new JoystickButton(operatorController,
        XboxController.Button.kLeftBumper.value);
    raiseIntakeButton.whenPressed(new RaiseIntake());

    final JoystickButton lowerIntakeButton = new JoystickButton(operatorController,
        XboxController.Button.kRightBumper.value);
    lowerIntakeButton.whenPressed(new LowerIntake());

  }

  public XboxController getOperatorController() {
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
