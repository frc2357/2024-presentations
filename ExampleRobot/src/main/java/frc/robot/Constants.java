// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class CAN_ID {
        public static final int DRIVE_MOTOR_LEFT_1 = 11;
        public static final int DRIVE_MOTOR_RIGHT_1 = 12;
        public static final int DRIVE_MOTOR_LEFT_2 = 13;
        public static final int DRIVE_MOTOR_RIGHT_2 = 14;
    }

    public static final class DRIVE {
        public static final InvertedValue LEFT_INVERTED = InvertedValue.CounterClockwise_Positive;
        public static final InvertedValue RIGHT_INVERTED = InvertedValue.Clockwise_Positive;
        public static final double DEADBAND = 0.1;
    }

    public static final class CONTROLLER {
        public static final int DRIVER = 0;
    }

    public static final class DIO {
        public static final int WALL_SENSOR = 2;
    }
}
