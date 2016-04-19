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
        
}
