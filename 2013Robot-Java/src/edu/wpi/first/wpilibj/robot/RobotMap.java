package edu.wpi.first.wpilibj.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    //ALL THE JAGUAR PORTS
    public static final int JaguarRightFront = 1;
    public static final int JaguarRightBack = 2;
    
    public static final int JaguarLeftFront = 3;
    public static final int JaguarLeftBack = 4;
    
    //TALON PORTS
    public static final int ShooterWheel = 10;
    
    //ENCODER PORTS
    public static final int ShooterEnc1 = 13;
    public static final int ShooterEnc2 = 14;
    
    //DIGITAL SWITCH PORTS
    public static final int ShooterSwitch = 1;
    
    //PNEUMATICS
    public static final int SpikeComp = 8;
    public static final int SwitchShooter = 6;
}
