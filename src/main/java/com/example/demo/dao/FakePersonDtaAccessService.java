


package com.example.demo.dao;

import com.example.demo.model.person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("FakeDao")

public class FakePersonDtaAccessService implements PersonDeo {
    private static List<person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, person person) {
        DB.add(new person(id,person.getName()));
        return 1;
    }

    @Override
    public List<person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, person person) {
        return 0;
    }
}
