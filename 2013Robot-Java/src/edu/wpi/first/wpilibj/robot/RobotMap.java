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
    
    
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
}
