package org.usfirst.frc3620.Arm.commands;

import org.usfirst.frc3620.Arm.Robot;

import Subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateWristUp extends Command {

	double p0;
	Timer timer = new Timer();
	boolean limit;
	double moveValue;
    public RotateWristUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	timer.reset();	
    	timer.start();
    	p0 = Robot.wristSubsystem.getServo();
    	System.out.println ("starting, p0 = " + p0);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
     	moveValue = timer.get()*(.05)*(1000);
        
    	System.out.println();
    	 
    	double position = p0 + moveValue; 
        System.out.println("execute, p0 = " + p0 + ", moveValue = " + moveValue + ", position = " + position);
    			
    	
    	
    	if (position<=1){
    		Robot.wristSubsystem.setServo(position);
    		limit = false;
    		}
    	else {
    		limit = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (limit = true){
    		return true;
    	}
    	else {
        return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("ended");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("interrupted()");
    }
}
