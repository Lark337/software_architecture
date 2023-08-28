package com.rep;

import java.util.List;

public interface PhoneRepository {
    Phone getById(int id);
    List<Phone> getAll();
    void add(Phone phone);
    void update(Phone phone);
    void delete(int id);
    void createTable();

    
}
