package com.example.demo.service;

import com.example.demo.dao.PersonDeo;
import com.example.demo.model.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class PersonService {
    private final PersonDeo personDeo;

    @Autowired
    public PersonService(@Qualifier("FakeDao") PersonDeo personDeo) {
        this.personDeo = personDeo;
    }

    public int addPerson(person person){
        return personDeo.insertPerson(person);
    }
     public List<person> getAllPeople(){
        return personDeo.selectAllPeople();
     }

     public Optional<person> getPersonById(UUID id){
        return personDeo.selectPersonById(id);
     }
}
