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
import edu.wpi.first.wpilibj.Timer;
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
    OI oi = new OI();
    DriveTrain drive = new DriveTrain();
    frisbeeShooter shooter = new frisbeeShooter();
    Sensors sensor = new Sensors();
    Timer RobotTime = new Timer();
    double deadZone = 0.25;
    
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        CommandBase.init();
        
        
    }

    public void autonomousInit() {
        sensor.resetGyro();
        sensor.resetEncoder();
        RobotTime.reset();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        RobotTime.start();
        while(isAutonomous()){
            while(drive.turnToAngle(90, sensor.getGyroAngle()) == false){
              drive.turnToAngle(90, sensor.getGyroAngle());
            }
            while(RobotTime.get() < 4){
                //Drive Straight for 4 seconds.
                drive.driveStraight(-0.25, 0.0, sensor.getGyroAngle());
            }
            while(drive.turnToAngle(180, sensor.getGyroAngle()) == false){
              drive.turnToAngle(180, sensor.getGyroAngle());
            }
            drive.stopDriving();
        }
        }
        
    

    public void teleopInit() {
        sensor.resetGyro();
        sensor.resetEncoder();
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
            drive.stopDriving();
        }
        
          
        
        //ALL THE SHOOTER CONTROLS
        if(oi.get1BtnA()){
            shooter.spinTo(50000, sensor.getShooterRate());
        } else {
            shooter.stopDriving();
        }
        
        if(oi.get1BtnB()){
            shooter.startCompressor();
        } else {
            shooter.stopCompressor();
        }
        
        //ALL THE OUTPUT TO THE DRIVER STATION
        //Return l/r percent to the dashboard.
        SmartDashboard.putNumber("Left Front Motor Percentage: ", drive.getSpeedLeftFrontSide() * 100);
        SmartDashboard.putNumber("Right Front Motor Percentage: ", drive.getSpeedRightFrontSide() * 100);
        SmartDashboard.putNumber("Left Rear Motor Percentage: ", drive.getSpeedLeftRearSide() * 100);
        SmartDashboard.putNumber("Right Rear Motor Percentage: ", drive.getSpeedRightRearSide() * 100);
       
        
        //Return the encoder rate from the shooter motor, unknown units still.
        SmartDashboard.putNumber("Encoder Rate Shooter: ", sensor.getShooterRate());   
        
        //Return the heading from the gyro
        SmartDashboard.putNumber("Gyro Angle: ", sensor.getGyroAngle());
        
        //Return the error from the shooter.
        SmartDashboard.putNumber("Shooter Error: ", shooter.returnShooterError());
        SmartDashboard.putBoolean("Is Frisbee In? ", sensor.getShooterSwitchState());
        
    }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
