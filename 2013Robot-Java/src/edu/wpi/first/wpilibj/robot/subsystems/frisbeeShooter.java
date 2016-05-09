/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
/**
 *
 * @author swat
 */
public class frisbeeShooter extends Subsystem {
    
    
    //Create the talon object that the shooter uses.
    Talon shooterMotor = new Talon(RobotMap.ShooterWheel);
    Talon AirComp = new Talon(RobotMap.SpikeFrisbee);
    
    public double error;
    
    
    public void initDefaultCommand() {
        
    }
    
    public void setSpeed(double Pwr){
        shooterMotor.set(Pwr);
    }
    
    public void stopDriving(){
        shooterMotor.set(0);
    }
    
    public double getShooterSpeed(){
        return shooterMotor.get();
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
    
    public double returnShooterError(){
        return error;
    }
    
    public void startCompressor(){
        AirComp.set(1.0);
    }
    
    public void stopCompressor(){
        AirComp.set(0);
    }
    
        
}
