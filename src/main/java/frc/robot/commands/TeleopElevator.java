package frc.robot.commands;


import frc.robot.subsystems.SparkMax;


import java.util.function.BooleanSupplier;



import edu.wpi.first.wpilibj2.command.CommandBase;






public class TeleopElevator extends CommandBase {
private SparkMax sMax;
// private BooleanSupplier elevatorButton;

    public TeleopElevator(SparkMax sMax, BooleanSupplier elevatorButton){
    this.sMax = sMax;
    //addRequirements(sMax);



}



}