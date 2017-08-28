package Subsystems;



import org.usfirst.frc3620.Arm.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
	static SpeedController shoulderMotor = RobotMap.shoulderMotor;
	static SpeedController elbowMotor = RobotMap.elbowMotor;
	static SpeedController twisterActuator = RobotMap.twisterActuator;
	public static Servo wristServo = RobotMap.wristServo;

    public void moveShoulderDown(){
    	shoulderMotor.set(0.35);
    }
    
    public void moveShoulderUp(){
    	shoulderMotor.set(-0.35);
    }
    
    public void moveTorsoleft(){
    	twisterActuator.set(0.50);
    }
    
    public void moveTorsoRight(){
    	twisterActuator.set(-0.50);
    }
    
    public void moveElbowDown(){
    	elbowMotor.set(0.35);
    }
    
    public void moveElbowUp(){
    	elbowMotor.set(-0.35);
    
    }
    
    public void shoulderStop(){
    	shoulderMotor.set(0);
    }
    
    public void elbowStop(){
    	elbowMotor.set(0);
    }
    
    public void twisterStop(){
    	twisterActuator.set(0);
    }
    
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

