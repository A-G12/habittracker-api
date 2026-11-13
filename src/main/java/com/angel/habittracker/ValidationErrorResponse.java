package com.angel.habittracker;

import java.time.LocalDateTime;
import java.util.Map;

public record ValidationErrorResponse(int status, Map<String, String> errors, LocalDateTime timestamp) {

}
