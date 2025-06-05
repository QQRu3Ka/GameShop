package qqru3ka.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import qqru3ka.dto.DeveloperDto;
import qqru3ka.entities.Developer;
import qqru3ka.repositories.DeveloperRepository;

@Service
public class DeveloperService {
    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public Developer findById(Integer id) {
        return developerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Developer findByUserId(Integer id) {
        return developerRepository.findByUserId(id).orElseThrow(EntityNotFoundException::new);
    }

    public Developer storeDeveloper(DeveloperDto developerDto) {
        if(developerRepository.findByUserId(developerDto.getUserId()).isPresent()) {
            throw new IllegalArgumentException();
        }
        if(developerRepository.findByName(developerDto.getName()).isPresent()) {
            throw new IllegalArgumentException();
        }
        if(developerRepository.findByEmail(developerDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException();
        }
        Developer developer = new Developer();
        developer.setUserId(developerDto.getUserId());
        developer.setName(developerDto.getName());
        developer.setEmail(developerDto.getEmail());
        return developerRepository.save(developer);
    }
}
