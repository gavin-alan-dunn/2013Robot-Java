/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.AnalogTrigger;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
/**
 *
 * @author swat
 */
public class frisbeeShooter extends Subsystem {
    
    
    //Create the talon object that the shooter uses.
    Talon shooterMotor = new Talon(RobotMap.ShooterWheel);
    
    //Create the encoder object for the shooter.
    Encoder shooterEnc = new Encoder(13, 14, true, EncodingType.k4X);
    
    //Create the analog trigger object that checks if frisbee is in.
    AnalogTrigger frisbeeCheck = new AnalogTrigger(1);
    
    
    public void initDefaultCommand() {
        shooterEnc.setMaxPeriod(.2);
        shooterEnc.setMinRate(10);
        shooterEnc.setDistancePerPulse(5);
        shooterEnc.setReverseDirection(false);
    }
    
    public void setSpeed(double Pwr){
        shooterMotor.set(Pwr);
    }
    
    public void setRate(double targetRate){
        double error = targetRate - shooterEnc.getRate();
        if(error > 5000){
            shooterMotor.set(-1);
        } else if(error > 2000 && error <= 5000){
            shooterMotor.set(-0.5);
        } else if(error > 500 && error <= 2000){
            shooterMotor.set(-0.2);
        } else if(error <= 500 && error > 150){
            shooterMotor.set(-0.1);
        } else if(error <= 150){
            shooterMotor.set(-0.05);
        }else {
            shooterMotor.set(0);
        }
    }
    
    public void stopDriving(){
        shooterMotor.set(0);
    }
    
    public double getShooterSpeed(){
        return shooterMotor.get();
    }
    
    public double getShooterRate(){
        return shooterEnc.getRate(); //Feet Per Seconds I think.
    }
    
    public boolean isFrisbeeIn(){
        return frisbeeCheck.getTriggerState(); //Might work and return true or false.
    }
    
    public void resetEncoder(){
        shooterEnc.reset();
        shooterEnc.start();
    }
    

    
}
