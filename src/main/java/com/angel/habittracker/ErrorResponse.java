package com.angel.habittracker;
import java.time.LocalDateTime;
public record ErrorResponse(int status, String message, LocalDateTime timestamp) { }
