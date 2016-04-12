/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.robot.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author swat
 */
public class DriveTrain extends Subsystem {
    
    
    //Create the jaguar objects for the drive
    Jaguar leftBackMotor = new Jaguar(4);
    Jaguar leftFrontMotor = new Jaguar(RobotMap.JaguarLeftFront);
    Jaguar rightBackMotor = new Jaguar(RobotMap.JaguarRightBack);
    Jaguar rightFrontMotor = new Jaguar(RobotMap.JaguarRightFront);
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(double leftPwr, double rightPwr){
        leftBackMotor.set(leftPwr);
        leftFrontMotor.set(leftPwr);
        
        rightBackMotor.set(rightPwr);
        rightFrontMotor.set(rightPwr);
    }
    
    public void stopDriving(){
        leftBackMotor.set(0);
        leftFrontMotor.set(0);
        
        rightBackMotor.set(0);
        rightFrontMotor.set(0);
    }
    
    public double getSpeedLeftSide(){
        if(leftBackMotor.get() != leftFrontMotor.get()){
            return 0;
        } else {
            return leftBackMotor.get();
        }
    }
    
    public double getSpeedRightSide(){
        if(rightBackMotor.get() != rightFrontMotor.get()){
            return 0;
        } else {
            return rightBackMotor.get();
        }
    }
    
    public void strafe(double speed){
        leftBackMotor.set(speed);
        rightBackMotor.set(speed);
        
        leftFrontMotor.set(-speed);
        rightFrontMotor.set(-speed);
    }
    
}
