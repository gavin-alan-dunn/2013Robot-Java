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
    
    
    //Create any other objects.
    RobotDrive MecanumDrive = new RobotDrive(leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);
    
    
    public void initDefaultCommand() {
        MecanumDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        MecanumDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    }
    
    public void set(double x, double y, double rotation, double gyro){
        
        MecanumDrive.mecanumDrive_Cartesian(-x, y, rotation, gyro);
    }
    
    public void driveStraight(double power, double gyro){
        MecanumDrive.mecanumDrive_Cartesian(0, power, 0, gyro);
    }
    
    public double getSpeedLeftRearSide(){
        return leftBackMotor.get();
    }
    
    public double getSpeedLeftFrontSide() {
        return leftFrontMotor.get();
    }
    
    public double getSpeedRightRearSide(){
        return rightBackMotor.get();
    }
    
    public double getSpeedRightFrontSide(){
        return rightFrontMotor.get();
    }
    
    public void stopDriving(){
        MecanumDrive.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
    
}