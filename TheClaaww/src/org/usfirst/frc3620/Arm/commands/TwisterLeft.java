package org.usfirst.frc3620.Arm.commands;

import org.usfirst.frc3620.Arm.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TwisterLeft extends Command {

    public TwisterLeft() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.armSubsystem.moveTorsoleft();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.armSubsystem.shoulderStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.armSubsystem.shoulderStop();
    }
}
