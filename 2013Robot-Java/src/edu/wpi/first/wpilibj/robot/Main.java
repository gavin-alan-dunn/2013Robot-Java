/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.robot;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.robot.commands.autoCommand;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Main extends IterativeRobot {   
    //Instantiate variables here
    Command autonomous;
    
    public void robotInit() {
        CommandBase.init();
        
    }

    public void autonomousInit() {
        //Set the auto command.
        autonomous = new autoCommand();
    }

    public void autonomousPeriodic() {
        //Start the auto command.
        autonomous.start();
        
        }
        
    

    public void teleopInit() {
        //Make sure the auto command stops.
        autonomous.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //Make sure that commands are run in teleop.
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
