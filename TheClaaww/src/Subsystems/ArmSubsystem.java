package Subsystems;



import java.sql.Time;

import javax.swing.text.AbstractDocument.LeafElement;

import org.usfirst.frc3620.Arm.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
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
	static Encoder firstEncoder = RobotMap.firstEncoder;
	static Encoder secondEncoder = RobotMap.secondEncoder;
	Timer timer = new Timer();
	
	double lengthE;
	double lengthS;
	double angleE;
	double angleS;
	double r;

	double x;
	double y;
	double dxAngleE;
	double dxAngleS;
	double dyAngleE;
	double dyAngleS;
	
	
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
    
    public double findR(){
    	
    	r = (Math.pow(lengthS, 2))+(Math.pow(lengthE, 2))-(2*lengthS*lengthE*Math.cos(angleE)) ;
    	
    	return r;
    }
    
    public double findX(){
    	
    	x = Math.sin(90-lengthS+Math.asin(r))*r;
    	
    	return x;
    }
    
    public double findY(){
    	
    	y = Math.sin(angleS-Math.asin((lengthE*Math.sin(angleE))/r)*r);
    	
    	return y;
    	
    	
    }
    
    public double findDYAngleS(){
    	
    	dyAngleS = Math.cos(angleS - Math.asin((lengthE*Math.sin(angleE))/(Math.sqrt(r)))*
    	(angleS-Math.asin(0))*(Math.sqrt(r))
    	 + Math.sin(angleS-Math.asin((lengthE*Math.sin(angleE))/Math.sqrt(r)))*(1/(2*Math.sqrt(r))));
    			
    			return dyAngleS;
    			
    }
    			
    public double findDXAngleS(){
    	
    	dxAngleS = Math.cos(90 - angleS - Math.asin((lengthE*Math.sin(angleE))/(Math.sqrt(r)))*
    	    	angleS * r * (Math.sqrt(r))
    	    	 + Math.sin(90-angleS+Math.asin((lengthE*Math.sin(angleE))/Math.sqrt(r)))*(1/(2*Math.sqrt(r))));
    	
    	return dxAngleS;
    	
    	
    }
    
    public double findDYAngleE(){
    	
    	dyAngleE = Math.cos(angleS - Math.asin((lengthE*Math.sin(angleE))/Math.sqrt(r)))
    	
    }
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

