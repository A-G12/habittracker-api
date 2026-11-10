package com.angel.habittracker;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.*;

@Repository
public class HabitRepository {

    private final Map<Long, Habit> habits = new HashMap<>();
    private Long nextId = 1L;

    public HabitRepository() {            // datos de prueba
        save(new Habit(null, "Leer", "DAILY"));
        save(new Habit(null, "Correr", "WEEKLY"));
    }

    public Habit save(Habit habit) {
        if(habit.getId() == null) {
            habit.setId(nextId++);
        }
        habits.put(habit.getId(), habit);
        return habit;
    }

    public Optional<Habit> findById(Long id) { return Optional.ofNullable(habits.get(id)); }
    public List<Habit> findAll()             { return new ArrayList<>(habits.values()); }
    public boolean existsById(Long id)       { return habits.containsKey(id); }
    public void deleteById(Long id)          { habits.remove(id); }
    public int count()                       { return habits.size(); }
}
