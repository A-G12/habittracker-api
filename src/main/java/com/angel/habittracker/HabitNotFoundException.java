package com.angel.habittracker;

public class HabitNotFoundException extends RuntimeException {
    public HabitNotFoundException(Long id) {
        super("Hábito no encontrado: " + id);
    }
}