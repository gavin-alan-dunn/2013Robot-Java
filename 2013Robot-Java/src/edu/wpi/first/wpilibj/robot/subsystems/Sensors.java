/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.robot.RobotMap;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;


public class Sensors extends Subsystem {
    
    //Create the gyro sensor
    Gyro gyroAngle = new Gyro(1); //Create a gyro on analog channel one.
    
    //Create the encoder object for the shooter.
    Encoder shooterEnc = new Encoder(RobotMap.ShooterEnc1, RobotMap.ShooterEnc2, true, EncodingType.k4X);
    
    //Create the limit switch object.
    DigitalIOButton shooterSwitch = new DigitalIOButton(1);
    
    public void initDefaultCommand() {
        shooterEnc.setMaxPeriod(.2);
        shooterEnc.setMinRate(10);
        shooterEnc.setDistancePerPulse(5);
        shooterEnc.setReverseDirection(false);
    }
    
    public void resetGyro(){
        //Reset the gyro's 0 degree angle to the current angle, returns T or F.\
        gyroAngle.reset();
    }
    
    public double getGyroAngle(){
        //Return the current angle measure.
        return gyroAngle.getAngle();
    }
    
    public double getShooterRate(){
        return shooterEnc.getRate(); //Feet Per Seconds I think.
    }
    
    public void resetEncoder(){
        shooterEnc.reset();
        shooterEnc.start();
    }
    
    public boolean getShooterSwitchState(){
        return shooterSwitch.get();
    }
    
}
