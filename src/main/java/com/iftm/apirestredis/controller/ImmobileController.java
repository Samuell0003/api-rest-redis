package com.iftm.apirestredis.controller;

import com.iftm.apirestredis.model.Immobile;
import com.iftm.apirestredis.services.ImmobileService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("immobile")
public class ImmobileController {
    @Autowired
    private ImmobileService immobileService;

    @GetMapping
    public ResponseEntity<List<Immobile>> findAll() {
        return ResponseEntity.ok(immobileService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Immobile> findById(@PathVariable ObjectId id) {
        return ResponseEntity.ok(immobileService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Immobile> save(@RequestBody Immobile immobile) {
        return ResponseEntity.ok(immobileService.save(immobile));
    }

    @PutMapping
    public ResponseEntity<Immobile> update(@RequestBody Immobile immobile) {
        return ResponseEntity.ok(immobileService.update(immobile));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable ObjectId id) {
        return ResponseEntity.ok(immobileService.delete(id));
    }
}
