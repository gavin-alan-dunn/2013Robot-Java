/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 * @author swat
 */
public class frisbeeShooter extends Subsystem {
    
    
    //Create the talon object that the shooter uses.
    Talon shooterMotor = new Talon(RobotMap.ShooterWheel);
    
    //Create other pneumatic objects.
    Relay airCompressor = new Relay(8);
    
    
    //All the other crap.
    public double error;
    
    
    public void initDefaultCommand() {
        
    }
    
    public void setSpeed(double Pwr){
        shooterMotor.set(Pwr);
    }
    
    public void stopDriving(){
        shooterMotor.set(0);
    }
        
    public void spinTo(double targetRate, double encoderRate){
        error = targetRate - encoderRate;
        if(error > 5000){
            shooterMotor.set(-1.0);
        } else if(error <= 5000 && error > 2000){
            shooterMotor.set(-0.5);
        } else if(error <= 2000 && error > 500){
            shooterMotor.set(-0.3);
        } else {
            shooterMotor.set(-0.1);
        }
    }
     
    
    
        
}