package com.angel.habittracker;

public class Habit {
    private Long id;
    private String name;
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