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

/**
 *
 * @author swat
 */
public class frisbeeShooter extends Subsystem {
    
    
    //Create the talon object that the shooter uses.
    Talon shooterMotor = new Talon(RobotMap.ShooterWheel);
    
    //Create the encoder object for the shooter.
    Encoder shooterEnc = new Encoder(1,2);
    
    //Create the analog trigger object that checks if frisbee is in.
    AnalogTrigger frisbeeCheck = new AnalogTrigger(1);
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
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
    
    public double getShooterRate(){
        return shooterEnc.getRate(); //Feet Per Seconds I think.
    }
    
    public boolean isFrisbeeIn(){
        return frisbeeCheck.getTriggerState(); //Might work and return true or false.
    }
    

    
}
