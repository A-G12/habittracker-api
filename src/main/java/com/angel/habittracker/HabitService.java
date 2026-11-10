package com.angel.habittracker;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

public class HabitService {
    private final HabitRepository repository;

    public HabitService(HabitRepository repository) {
        this.repository = repository;
    }

    public List<Habit> findAll() {
        return repository.findAll();
    }

    public Habit findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new HabitNotFoundException(id));   // ← tu línea de la capa 0
    }

    public Habit create(Habit habit) {
        habit.setId(null);      // ¿por qué? → pregunta 2 del checkpoint
        return repository.save(habit);
    }

    public int count() {
        return repository.count();
    }
}
