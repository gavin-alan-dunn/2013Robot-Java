
package edu.wpi.first.wpilibj.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //CREATE JOYSTICK PORTS
    int Joystick1_Port = 1, Joystick2_Port = 2;
    
    /*
    UPDATE THE PORTS PLZ
    */
    
    
    //CREATE AXIS PORTS
    int LsY = 2, LsX = 1, RsX = 5;
    
    //CREATE BUTTON PORTS
    int BtnA = 1, BtnB = 2, BtnX = 3, BtnY = 4;
    
    //CREATE THE JOYSTICKS
    Joystick gamepad1 = new Joystick(Joystick1_Port);
    
    Joystick gamepad2 = new Joystick(Joystick2_Port);
    
    //CREATING BUTTONS
    Button btnA = new JoystickButton(gamepad1, 1);
    
    /*
    All the actual button and axis methods.
    */
    
    //CREATE THE AXIS METHODS
    public double get1LsY() {
        return gamepad1.getRawAxis(LsY);
    }
    
    public double get1LsX() {
        return gamepad1.getRawAxis(LsX);
    }
    
    public double get1RsX() {
        return gamepad1.getRawAxis(RsX);
    }
    
    public double get2LsY() {
        return gamepad2.getRawAxis(LsY);
    }
    
    public double get2LsX() {
        return gamepad2.getRawAxis(LsX);
    }
    
    public double get2RsX() {
        return gamepad2.getRawAxis(RsX);
    }
    
    public boolean get1BtnA() {
        return btnA.get();
    }
    
    public boolean get1BtnB() {
        return gamepad2.getRawButton(BtnB);
    }
    
    //CREATE THE BUTTON OBJECTS AND TRIGGERS
    
    
    //CREATE METHODS TO OUTPUT DATA TO DASHBOARD.
    
    //Create the joysticks
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

