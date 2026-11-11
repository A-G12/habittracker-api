package com.angel.habittracker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/habits")          // prefijo para todos los endpoints de esta clase
public class HabitController {
    private final HabitService service;

    public HabitController(HabitService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Habit> getAll(@RequestParam(required = false) String name) {
        return service.findAll();
    }

    @GetMapping("/count")
    public int getCount() {
        return service.count();
    }

    @GetMapping("/{id}")
    public Habit getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Habit> create(@Valid @RequestBody Habit habit){
        Habit created = service.create(habit);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public Habit update(@PathVariable Long id, @Valid @RequestBody Habit habit){
        return service.update(id, habit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
