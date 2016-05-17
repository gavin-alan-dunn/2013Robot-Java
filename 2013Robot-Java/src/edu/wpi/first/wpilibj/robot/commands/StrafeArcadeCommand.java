/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.robot.OI;
/**
 *
 * @author dunng18
 */
public class StrafeArcadeCommand extends CommandBase {
    
    //Create a few variables here.
    OI oi = new OI();
    
    public StrafeArcadeCommand() {
        requires(driveSS);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //Run the drive train based on joystick inputs.
        driveSS.set(oi.Joy1LsX(), oi.Joy1LsY(), oi.Joy1RsX(), 0);
        
        //Output the power to the dashboard while this runs.
        SmartDashboard.putNumber("Left Front Pwr: ", driveSS.getSpeedLeftFrontSide());
        SmartDashboard.putNumber("Left Back Pwr: ", driveSS.getSpeedLeftRearSide());
        SmartDashboard.putNumber("Right Front Pwr: ", driveSS.getSpeedRightFrontSide());
        SmartDashboard.putNumber("Right Back Pwr: ", driveSS.getSpeedRightRearSide());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
