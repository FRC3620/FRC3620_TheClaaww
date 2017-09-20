package Subsystems;

import org.usfirst.frc3620.Arm.RobotMap;
import org.usfirst.frc3620.Arm.commands.RotateWristUp;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WristSubsystem extends Subsystem {
	public static Servo wristServo = RobotMap.wristServo;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void resetServo(){
    	wristServo.set(0);
    }
    
    public void setServo(double position){
    	wristServo.set(position);
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

