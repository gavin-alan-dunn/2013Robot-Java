/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 * @author swat
 */
public class frisbeeShooter extends Subsystem {
    
    
    //Create the talon object that the shooter uses.
    Talon shooterMotor = new Talon(RobotMap.ShooterWheel);
    
    //Create other pneumatic objects.
    Compressor airComp = new Compressor(12,8);
    DoubleSolenoid shootPush = new DoubleSolenoid(1,2);
    
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
        airComp.start();
    }
    
    public void stopCompressor(){
        airComp.stop();
    }
    
    public boolean getCompValue(){
        return airComp.getPressureSwitchValue();
    }
    
    public void pushOutShooter(){
        shootPush.set(DoubleSolenoid.Value.kForward);
    }
    
    public void pushInShooter(){
        shootPush.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void pushStop(){
        shootPush.set(DoubleSolenoid.Value.kOff);
    }
    
        
}