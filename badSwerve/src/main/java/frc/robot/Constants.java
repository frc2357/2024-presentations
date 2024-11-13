// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Optional;
import java.util.function.BooleanSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

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
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final class SWERVE {
    public static final double MAX_ANGULAR_RATE_ROTATIONS_PER_SECOND = Math.PI * 2;

    public static final double STATIC_FEEDFORWARD_METERS_PER_SECOND = 0.094545;

    // Gamepiece tracking
    public static final double AUTO_INTAKE_YAW_TOLERANCE = 18;
    public static final double AUTO_TRANSLATE_DEBOUNCE_SECONDS = 0.1;
    public static final double PIECE_TRACKING_TRANSLATION_SPEED = 0;
    public static final double PIECE_DEBOUNCE_SECONDS = 0.1;
    public static final double PIECE_TRACKING_ROTATION_TOLERANCE = 0.1;

    public static final double PIECE_TRACKING_MAX_DISTANCE_METERS = 3.0; // In Meters
    public static final double PIECE_TRACKING_SLOW_DOWN_METERS = 1.0; // Robot goes half speed once passed
    public static final double PIECE_TRACKING_X_METERS_PER_SECOND = 2;

    public static final double TELEOP_DRIVE_TO_GAMEPIECE_Y_METERS_PER_SECOND = 2.0;
    public static final double TELEOP_CREEP_TO_GAMEPIECE_Y_METERS_PER_SECOND = 1.0;

    // Target Lock
    public static final double TARGET_LOCK_ROTATION_KP = 0.1;
    public static final double TARGET_LOCK_ROTATION_KI = 0.0;
    public static final double TARGET_LOCK_ROTATION_KD = 0.0;
    public static final PIDController TARGET_LOCK_ROTATION_PID_CONTROLLER = new PIDController(
        TARGET_LOCK_ROTATION_KP, TARGET_LOCK_ROTATION_KI, TARGET_LOCK_ROTATION_KD);

    public static final double TARGET_LOCK_FEED_FORWARD = 0.0;
    public static final double TARGET_LOCK_TOLERANCE = 0.5;

    public static final double AUTO_TARGET_LOCK_YAW_TOLERANCE = 2;

    // Translate to Apriltag
    public static final PIDController PIGEON_ROTATION_PID_CONTROLLER = new PIDController(12, 0, 0.0);
    public static final double PIGEON_ROTATION_FEEDFORWARD = 0.00001;
    public static final PIDController VISION_X_TRANSLATION_PID_CONTROLLER = new PIDController(0.10, 0, 0);
    public static final PIDController VISION_Y_TRANSLATION_PID_CONTROLLER = new PIDController(0.15, 0, 0);

    public static final double VISION_YAW_TOLERANCE = 1;
    public static final double VISION_PITCH_TOLERANCE = 0.5;
    public static final double VISION_ROTATION_TOLERANCE_RADIANS = 0.02;
    public static final double VISION_PITCH_MAGIC_OFFSET = 12.5;
    public static final double VISION_CLOSE_PITCH = 4.0;
    public static final double VISION_CLOSE_YAW_FACTOR = 2.0;

    public static final double AMP_YAW_SETPOINT = 0;
    public static final double AMP_PITCH_SETPOINT = 5;
    public static final double BLUE_AMP_ROTATION_SETPOINT_RADIANS = -Math.PI / 2;
    public static final double RED_AMP_ROTATION_SETPOINT_RADIANS = Math.PI / 2;

    public static final double STAGE_YAW_SETPOINT = 0.0;
    public static final double STAGE_PITCH_SETPOINT = 12.2;

    // Passing
    public static final double FEEDING_TARGET_LOCK_YAW_SETPOINT = 5;
    public static final double PASSING_MID_FIELD_ROBOT_YAW_TOLERANCE = 30;
    public static final double PASSING_WALL_SIDE_ROBOT_YAW_TOLERANCE = 40;
    public static final double RED_PASSING_MID_FIELD_YAW_SETPOINT = 5;
    public static final double RED_PASSING_WALL_SIDE_YAW_SETPOINT = 0;

    public static final double BLUE_PASSING_MID_FIELD_YAW_SETPOINT = -20;
    public static final double BLUE_PASSING_WALL_SIDE_YAW_SETPOINT = -10;

    /*
     * s = TranslateToGamepiece.m_startingSpeed
     * d = TRANSLATE_TO_GAMEPIECE_Y_DURATION_SECONDS
     * t = TRANSLATE_TO_GAMEPIECE_START_DECEL_THRESHOLD
     * m = TRANSLATE_TO_GAMEPIECE_MIN_SPEED_METERS_PER_SECOND
     * Distance traveled calculation:
     * s * (d - (d * t)) +
     * d * t * m +
     * ((s - m) * (d * t)) / 2
     *
     * Desmos Graph: https://www.desmos.com/calculator/8kbyasfnkv
     */
    public static final double TRANSLATE_TO_GAMEPIECE_Y_DURATION_SECONDS = 0.8;
    public static final double TRANSLATE_TO_GAMEPIECE_YAW_SETPOINT = 0;
    public static final double TRANSLATE_TO_GAMEPIECE_YAW_TOLERANCE = 2.5;
    public static final double TRANSLATE_TO_GAMEPIECE_ROTATION_SETPOINT = 0;
    public static final double TRANSLATE_TO_GAMEPIECE_START_DECEL_THRESHOLD = 0.7;
    public static final double TRANSLATE_TO_GAMEPIECE_MIN_SPEED_METERS_PER_SECOND = 0.0;

    // Tune this during field calibration
    public static final double BLUE_LEFT_STAGE_ROTATION_SETPOINT_RADIANS = 0;
    public static final double BLUE_RIGHT_STAGE_ROTATION_SETPOINT_RADIANS = 0;
    public static final double BLUE_CENTER_STAGE_ROTATION_SETPOINT_RADIANS = 2.11;
    public static final double RED_LEFT_STAGE_ROTATION_SETPOINT_RADIANS = 0;
    public static final double RED_RIGHT_STAGE_ROTATION_SETPOINT_RADIANS = 0;
    public static final double RED_CENTER_STAGE_ROTATION_SETPOINT_RADIANS = 0;

    public static final double TIME_TO_COAST_SECONDS = 5;

    // Auto climb
    public static final double DISTANCE_TO_UNDER_CHAIN = 1.2;
    public static final double SECONDS_TO_UNDER_CHAIN = 1.0;
    public static final double DISTANCE_TO_TOUCH_CHAIN = 1.1;
    public static final double SECONDS_TO_TOUCH_CHAIN = 1.25;
    public static final double DISTANCE_TO_ROTATE_PAST_EXTENSION = 0.5;
    public static final double SECONDS_TO_ROTATE_PAST_EXTENSION = 0.75;
    public static final double DISTANCE_TO_READY_TRAP = 0.25;
    public static final double SECONDS_TO_READY_TRAP = 0.5;

    public static final double DISTANCE_TO_READY_CLIMB = 0.25;
    public static final double SECONDS_TO_READY_CLIMB = 0.4;

    // Manual Line Up Climb
    public static final double DISTANCE_FROM_STAGE_TO_CHAIN = 0.8;
    public static final double SECONDS_FROM_STAGE_TO_CHAIN = 1;

    // Auto
    public static final double AUTO_TARGET_LOCK_TIMEOUT_SECONDS = 0.6;
  }

  public static final class CHOREO {
    public static final PIDController X_CONTROLLER = new PIDController(5, 0, 0);
    public static final PIDController Y_CONTROLLER = new PIDController(5, 0, 0);
    public static final PIDController ROTATION_CONTROLLER = new PIDController(1, 0, 0);

    public static final BooleanSupplier CHOREO_AUTO_MIRROR_PATHS = new BooleanSupplier() {
      @Override
      public boolean getAsBoolean() {

        Optional<Alliance> alliance = DriverStation.getAlliance();

        return alliance.isPresent() && alliance.get() == Alliance.Red;
      }
    };
  }
}
