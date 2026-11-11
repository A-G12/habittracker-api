package com.angel.habittracker;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Habit {
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre no puede pasar de 50 caracteres")
    private String name;

    @NotBlank(message = "La frecuencia es obligatoria")
    @Pattern(regexp = "DAILY|WEEKLY", message = "La frecuencia debe ser DAILY o WEEKLY")
    private String frequency;   // "DAILY", "WEEKLY"... (en la capa 3 será un enum)

    public Habit() { }          // ← Jackson lo necesita para leer el JSON

    public Habit(Long id, String name, String frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
}