package frc.robot.commands;


import frc.robot.subsystems.SparkMax;


import java.util.function.BooleanSupplier;



import edu.wpi.first.wpilibj2.command.CommandBase;



import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;




public class TeleopElevator extends CommandBase {
private SparkMax sMax;
// private BooleanSupplier elevatorButton;

    public TeleopElevator(SparkMax sMax, BooleanSupplier elevatorButton){
    this.sMax = sMax;
    //addRequirements(sMax);



}
    public double getCurrentEncoder() {
        
        return 100d;
    }


}