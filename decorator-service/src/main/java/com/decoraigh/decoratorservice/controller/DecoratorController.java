package com.decoraigh.decoratorservice.controller;

import com.decoraigh.decoratorservice.entity.Decorator;
import com.decoraigh.decoratorservice.service.DecoratorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/decorators")
public class DecoratorController {

    private final DecoratorService decoratorService;

    public DecoratorController(DecoratorService decoratorService) {
        this.decoratorService = decoratorService;
    }

    @GetMapping
    public List<Decorator> getAllDecorators() {
        return decoratorService.getAllDecorators();
    }

    @PostMapping
    public Decorator createDecorator(@RequestBody Decorator decorator) {
        return decoratorService.createDecorator(decorator);
    }

    @GetMapping("/{id}")
    public Decorator getDecorator(@PathVariable Long id) {
        return decoratorService.getDecoratorById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteDecorator(@PathVariable Long id) {
        decoratorService.deleteDecorator(id);
        return "Decorator deleted successfully";
    }

    @GetMapping("/location/{location}")
    public List<Decorator> getByLocation(@PathVariable String location) {
        return decoratorService.getByLocation(location);
    }

    @GetMapping("/specialization/{specialization}")
    public List<Decorator> getBySpecialization(@PathVariable String specialization) {
        return decoratorService.getBySpecialization(specialization);
    }

    @GetMapping("/available")
    public List<Decorator> getAvailableDecorators() {
        return decoratorService.getAvailableDecorators();
    }
}