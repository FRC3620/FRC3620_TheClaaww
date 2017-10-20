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
	
	//Two doubles giving the length of the elbow piece and the shoulder piece, respectively.
	public double lengthE = (Double) null;
	public double lengthS = (Double) null;
	
	// Two doubles representing the measure of the elbow joint angle and that of the shoulder joint.
	static double mE = (Double) null;
	static double mS = (Double) null;
	
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
    
    public double r(){
    	return Math.sqrt((lengthE*lengthE)+(lengthS*lengthS)+(2*lengthE*lengthS*Math.cos(mE))); 
    }
    
    public double gripperX(){
    	return Math.sin(90 - mS + Math.asin((lengthE*Math.sin(mE))/r()));
    }
    
    public double gripperY(){
    	return Math.sin(mS - Math.asin((lengthE*Math.sin(mE))/r()));
    }
    
    public double dXe(){
    	return ((Math.cos(90 - mS + Math.asin((lengthE*Math.sin(mE))/r())))*((lengthE*Math.cos(mE)*(((r()*r())+(2*lengthE*lengthS))/r()))
    			/Math.sqrt(1-Math.pow(((lengthE*Math.sin(mE))/r()),2)))*r())+ Math.sin(90 - mS + Math.asin((lengthE*Math.sin(mE))/r()))*r();
    }
    
    public double dXs(){
    	return ((Math.cos(90 - mS + Math.asin((lengthE*Math.sin(mE))/r())))*(-1)*r());
    }
    
    public double dYe(){
    	return ((Math.cos(90 - mS + Math.asin((lengthE*Math.sin(mE))/r())))*(-(lengthE*Math.cos(mE)*(((r()*r())+(2*lengthE*lengthS))/r()))
    			/Math.sqrt(1-Math.pow(((lengthE*Math.sin(mE))/r()),2)))*r())+ Math.sin(90 - mS + Math.asin((lengthE*Math.sin(mE))/r()))*r();
    }
    
    public double dYs(){
    	return ((Math.cos(90 - mS + Math.asin((lengthE*Math.sin(mE))/r())))*r());
    }
    //When applied to the desired "motor speed"(given as a voltage) for the shoulder, this is the Kinherent.
    public double ratioXeToXs(){
    	return (dXe())/(dXs());
    }
    //Ditto
    public double ratioYeToYs(){
    	return (dYe())/(dYs());
	}
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

