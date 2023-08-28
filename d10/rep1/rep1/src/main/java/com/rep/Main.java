package com.rep;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String connectioString = "jdbc:sqlite:phonesRep.db";
        PhoneRepository phoneRepository = new SQLiteRepository(connectioString);
        phoneRepository.createTable();
        Phone phone = new Phone(1,"Nokia 3212","Nokia", "Details", 30.00);
        phoneRepository.add(phone);

        Phone retrivedPhone = phoneRepository.getById(1);
        if(retrivedPhone != null){
            System.out.println("Телефон: " + retrivedPhone.getName());
        }


        List<Phone> allPhones = phoneRepository.getAll();
        for (Phone phone1 : allPhones) {
            System.out.println("Телефон: " + phone1.getId());
        }
        
    }
}