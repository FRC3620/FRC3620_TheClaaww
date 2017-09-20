package Subsystems;



import java.sql.Time;

import org.usfirst.frc3620.Arm.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSubsystem extends Subsystem {
	static SpeedController shoulderMotor = RobotMap.shoulderMotor;
	static SpeedController elbowMotor = RobotMap.elbowMotor;
	static SpeedController twisterActuator = RobotMap.twisterActuator;
	Timer timer = new Timer();
	
	public static DoubleSolenoid Grip = RobotMap.Grip; 
	
    public void moveShoulderDown(){
    	shoulderMotor.set(0.50);
    }
    
    public void moveShoulderUp(){
    	shoulderMotor.set(-0.50);
    }
    
    public void moveTorsoleft(){
    	twisterActuator.set(1.0);
    }
    
    public void moveTorsoRight(){
    	twisterActuator.set(-1.0);
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
    
    
    
    public void clamp(){
    	Grip.set(Value.kReverse);
    	
    }
    
    public void unclamp(){
    	Grip.set(Value.kForward);
    	
    }
    
    public void deadenClaw(){
    	Grip.set(Value.kOff);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

