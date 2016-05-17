/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author dunng18
 */
public class Pneumatics extends Subsystem {
    //Create variables for the pneumatics objects.
    Relay airCompressor = new Relay(8);
    DoubleSolenoid shootPush = new DoubleSolenoid(1,2);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //ALL THESE ARE FOR THE COMPRESSOR.
    public void startCompressor(){
        airCompressor.setDirection(Relay.Direction.kForward);
        airCompressor.set(Relay.Value.kOn);
    }
    
    public void stopCompressor(){
        airCompressor.set(Relay.Value.kOff);
    }
    
    public boolean getCompSwitch(){
        return airSwitch.getPressureSwitchValue() ;
    }
    
    //ALL THESE CONTROL THE DOUBLE SOLENOID.
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
