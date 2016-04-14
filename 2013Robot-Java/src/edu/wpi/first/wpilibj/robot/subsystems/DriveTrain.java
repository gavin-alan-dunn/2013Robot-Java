/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.robot.RobotMap;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;

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
    
    //Create any encoder objects that are located on the drive train.
    //None right now.
    
    //Create any other objects.
    RobotDrive MecanumDrive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(double x, double y, double rotation, double gyro){
        MecanumDrive.mecanumDrive_Cartesian(x, y, rotation, gyro);
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
    
}
