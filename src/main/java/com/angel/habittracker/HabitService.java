package com.angel.habittracker;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

public class HabitService {
    private final HabitRepository repository;

    public HabitService(HabitRepository repository) {
        this.repository = repository;
    }

    public List<HabitResponse> findAll(String name) {
        if(name == null) {
            return repository.findAll().stream()
                    .map(h -> toResponse(h)).toList();
        }
        return repository.findByNameContaining(name).stream()
                .map(h -> toResponse(h)).toList();
    }

    private HabitResponse toResponse(Habit habit){
        return new HabitResponse(habit.getId(), habit.getName(), habit.getFrequency());
    }

    public HabitResponse findById(Long id) {
        Habit habit = repository.findById(id)
                .orElseThrow(() -> new HabitNotFoundException(id));
        return toResponse(habit);
    }

    public HabitResponse create(HabitRequest request) {
        Habit habit = new Habit(null, request.name(),  request.frequency());
        Habit saved = repository.save(habit);
        return toResponse(saved);
    }

    public int count() {
        return repository.count();
    }

    public HabitResponse update(Long id, HabitRequest request){
        if(repository.existsById(id)){
            Habit habit = new Habit(id, request.name(), request.frequency());
            repository.save(habit);
            return toResponse(habit);
        }
        throw new HabitNotFoundException(id);
    }

    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new HabitNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
