package com.angel.habittracker;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record HabitRequest(
        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 50, message = "El nombre no puede pasar de 50 caracteres")
        String name,

        @NotBlank(message = "La frecuencia es obligatoria")
        @Pattern(regexp = "DAILY|WEEKLY", message = "La frecuencia debe ser DAILY o WEEKLY")
        String frequency
) { }