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
import edu.wpi.first.wpilibj.robot.subsystems.Sensors;
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
    DriveTrain drive = new DriveTrain();
    frisbeeShooter shooter = new frisbeeShooter();
    Sensors sensor = new Sensors();
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
        
        //Get all the other variables a go.
        deadZone = 0.25;
        
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
        autonomousCommand.cancel();
        sensor.resetGyro();
        shooter.resetEncoder();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        while(isOperatorControl() && isEnabled()){
        //ALL THE DRIVE TRAIN CONTROLS
        if((Math.abs(oi.get1LsY()) > deadZone) || (Math.abs(oi.get1RsX()) > deadZone) || (Math.abs(oi.get1LsX()) > deadZone)){
            //Move the robot without gyro.
            drive.set(oi.get1LsX(), oi.get1LsY(), oi.get1RsX(), 0);
        } else {
            //Stop the robot.
            drive.set(0,0,0,0);
        }
        
        //ALL THE SHOOTER CONTROLS
        if(oi.get1BtnA()){
            shooter.setRate(5000);
        } else {
            shooter.stopDriving();
        }
        
        //ALL THE OUTPUT TO THE DRIVER STATION
        //Return l/r percent to the dashboard.
        SmartDashboard.putNumber("Left Front Motor Percentage: ", drive.getSpeedLeftFrontSide() * 100);
        SmartDashboard.putNumber("Right Front Motor Percentage: ", drive.getSpeedRightFrontSide() * 100);
        SmartDashboard.putNumber("Left Rear Motor Percentage: ", drive.getSpeedLeftRearSide() * 100);
        SmartDashboard.putNumber("Right Rear Motor Percentage: ", drive.getSpeedRightRearSide() * 100);
        
        //Return whether a frisbee is in or not.
        SmartDashboard.putBoolean("Frisbee In? ", shooter.isFrisbeeIn());
        
        //Return the encoder rate from the shooter motor, unknown units still.
        SmartDashboard.putNumber("Encoder Rate Shooter: ", shooter.getShooterRate());   
        
        //Return the heading from the gyro
        SmartDashboard.putNumber("Gyro Angle: ", sensor.getGyroAngle());
    }
    }
    
    public void disabledInit(){
        
    }
    
    public void disabledPeriodic(){
        drive.set(0, 0, 0, 0);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
