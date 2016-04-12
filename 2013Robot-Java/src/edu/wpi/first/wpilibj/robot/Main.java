/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.robot;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.robot.commands.ExampleCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.robot.subsystems.frisbeeShooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Main extends IterativeRobot {

    Command autonomousCommand;
    double deadZone;
    OI oi = new OI();
    SmartDashboard dash = new SmartDashboard();
    DriveTrain drive = new DriveTrain();
    frisbeeShooter shooter = new frisbeeShooter();
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
        
        //Get all the other variables a go.
        deadZone = 0.15;
        
        // Initialize all subsystems
        CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        //ALL THE DRIVE TRAIN CONTROLS
        if((Math.abs(oi.get1LsY()) > deadZone) || (Math.abs(oi.get1RsX()) > deadZone)){
            if((Math.abs(oi.get1LsY()) > deadZone) && (Math.abs(oi.get1RsX()) > deadZone)){
                //DRIVING AND TURNING AT THE SAME TIME
                double leftSidePwr = oi.get1LsY() - oi.get1RsX();
                double rightSidePwr = oi.get1LsY() + oi.get1RsX();
                
                drive.set(leftSidePwr, rightSidePwr);
                
                
            } else if((Math.abs(oi.get1LsY()) > deadZone) && (Math.abs(oi.get1RsX()) <= deadZone)){
                //ONLY DRIVING STRAIGHT.
                double leftSidePwr = oi.get1LsY();
                double rightSidePwr = oi.get1LsY();
                
                drive.set(leftSidePwr, rightSidePwr);
            } else if((Math.abs(oi.get1LsY()) <= deadZone) && (Math.abs(oi.get1RsX()) > deadZone)){
                //ONLY TURNING
                double rightSidePwr = oi.get1RsX();
                double leftSidePwr = -1 * oi.get1RsX();
                
                drive.set(leftSidePwr, rightSidePwr);
            } else {
                drive.stopDriving();
            }
            
            
        } else {
            drive.stopDriving();
        }
        
        //ALL THE SHOOTER CONTROLS
        if(oi.get1BtnA()){
            shooter.setSpeed(-0.5);
        } else {
            shooter.stopDriving();
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
