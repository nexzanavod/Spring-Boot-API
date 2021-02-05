package com.example.demo.api;


import com.example.demo.model.person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
   public void addPerson(@RequestBody person person){
    personService.addPerson(person);
    }

    @GetMapping
    public List<person> getAllPeople(){
        return personService.getAllPeople();

    }

    @GetMapping(path="{id}")
    public person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);
    }
}