/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Gyro;


public class Sensors extends Subsystem {
    //Create some constants
    double gyroResetValue = 2.5;
    
    //Create the gyro sensor
    Gyro gyroAngle = new Gyro(1); //Create a gyro on analog channel one.
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void resetGyro(){
        //Reset the gyro's 0 degree angle to the current angle, returns T or F.\
        gyroAngle.reset();
    }
    
    public double getGyroAngle(){
        //Return the current angle measure.
        return gyroAngle.getAngle();
    }
    
}
