package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
//import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.autos.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    private final Joystick driver = new Joystick(0);
    
    /* Drive Controls */


    private final int translationAxis = Joystick.AxisType.kY.value;
    private final int strafeAxis = Joystick.AxisType.kX.value;
    private final int rotationAxis = Joystick.AxisType.kZ.value;

    /* Driver Buttons */
    private final JoystickButton zeroGyro = new JoystickButton(driver, 8  );
    private final JoystickButton robotCentric = new JoystickButton(driver, 7);
    private final JoystickButton elevatorPos1 = new JoystickButton(driver, 3);
    private final JoystickButton elevatorPos2 = new JoystickButton(driver, 4);

    /* Subsystems */
    private final Swerve s_Swerve = new Swerve();
    private final SparkMax s_max = new SparkMax();


    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {

        s_Swerve.setDefaultCommand(
            new TeleopSwerve(
                s_Swerve, 
                () -> -driver.getRawAxis(translationAxis), 
                () -> -driver.getRawAxis(strafeAxis), 
                () -> -driver.getRawAxis(rotationAxis), 
                () -> robotCentric.getAsBoolean()
            )
        );


        // s_max.setDefaultCommand(
        //     new TeleopElevator(
        //         s_max,
        //         () -> elevatorPos1.getAsBoolean()
            
        //     )
        // );
        
        // Configure the button bindings
        s_max.maxInit();
        configureButtonBindings();
        
    }
    // https://docs.wpilib.org/en/stable/docs/software/commandbased/structuring-command-based-project.html
    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        /* Driver Buttons */
        zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroGyro()));

        //Toggle elevator position from top to bottom
        elevatorPos1.onTrue(new InstantCommand(() -> s_max.extend(0d)));
        elevatorPos2.onTrue(new InstantCommand(() -> s_max.extend(5d)));

    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return new exampleAuto(s_Swerve);
    }
}
