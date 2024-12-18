package com.phodal.shire.demo.service;

import com.phodal.shire.demo.entity.Personal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalService {

    private final List<Personal> personalList = new ArrayList<>();
    private Long idCounter = 1L;

    public Personal createPersonal(Personal personal) {
        personal.setId(idCounter++);
        personalList.add(personal);
        return personal;
    }

    public List<Personal> getAllPersonals() {
        return personalList;
    }

    public Personal getPersonalById(Long id) {
        return personalList.stream()
                .filter(personal -> personal.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Personal updatePersonal(Long id, Personal updatedPersonal) {
        Optional<Personal> optionalPersonal = personalList.stream()
                .filter(personal -> personal.getId().equals(id))
                .findFirst();

        if (optionalPersonal.isPresent()) {
            Personal existingPersonal = optionalPersonal.get();
            existingPersonal.setName(updatedPersonal.getName());
            existingPersonal.setAge(updatedPersonal.getAge());
            existingPersonal.setEmail(updatedPersonal.getEmail());
            return existingPersonal;
        }
        return null;
    }

    public boolean deletePersonal(Long id) {
        return personalList.removeIf(personal -> personal.getId().equals(id));
    }
}