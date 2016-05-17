package edu.wpi.first.wpilibj.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.robot.OI;
import edu.wpi.first.wpilibj.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.robot.subsystems.Sensors;
import edu.wpi.first.wpilibj.robot.subsystems.frisbeeShooter;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {
    public static DriveTrain driveSS = new DriveTrain();
    public static frisbeeShooter frisbeeSS = new frisbeeShooter();
    public static Sensors sensorSS = new Sensors();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.

        // Show what command your subsystem is running on the SmartDashboard
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
