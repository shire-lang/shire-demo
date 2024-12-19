package com.phodal.shire.demo.controller;

import com.phodal.shire.demo.entity.Personal;
import com.phodal.shire.demo.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @PostMapping("/")
    public ResponseEntity<Personal> createPersonal(@Validated @RequestBody Personal personal) {
        Personal createdPersonal = personalService.createPersonal(personal);
        return new ResponseEntity<>(createdPersonal, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Personal>> getAllPersonals() {
        List<Personal> personals = personalService.getAllPersonals();
        return new ResponseEntity<>(personals, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personal> updatePersonal(@PathVariable Long id, @Validated @RequestBody Personal personal) {
        Personal updatedPersonal = personalService.updatePersonal(id, personal);
        return updatedPersonal != null ? new ResponseEntity<>(updatedPersonal, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonal(@PathVariable Long id) {
        boolean isDeleted = personalService.deletePersonal(id);
        return isDeleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
