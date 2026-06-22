package com.decoraigh.decoratorservice.service;

import com.decoraigh.decoratorservice.entity.Decorator;
import com.decoraigh.decoratorservice.repository.DecoratorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecoratorService{

    private final DecoratorRepository decoratorRepository;

    public DecoratorService(DecoratorRepository decoratorRepository) {
        this.decoratorRepository = decoratorRepository;
    }

    public List<Decorator> getAllDecorators() {
        return decoratorRepository.findAll();
    }

    public Decorator createDecorator(Decorator decorator) {
        return decoratorRepository.save(decorator);
    }

    public Decorator getDecoratorById(Long id) {
        return decoratorRepository.findById(id).orElse(null);
    }

    public void deleteDecorator(Long id) {
        decoratorRepository.deleteById(id);
    }

    public List<Decorator> getByLocation(String location) {
        return decoratorRepository.findByLocation(location);
    }

    public List<Decorator> getBySpecialization(String specialization) {
        return decoratorRepository.findBySpecialization(specialization);
    }

    public List<Decorator> getAvailableDecorators() {
        return decoratorRepository.findByAvailable(true);
    }
}