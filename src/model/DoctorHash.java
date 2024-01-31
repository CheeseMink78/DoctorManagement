package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DoctorHash {

    private HashMap<String, Doctor> listDoctor = new HashMap<>();

    public DoctorHash() {
        readTextFile("text.txt");
    }

    public HashMap<String, Doctor> getListDoctor() {
        return listDoctor;
    }

    public void readTextFile(String txt) {
        try ( Scanner scan = new Scanner(new File(txt))) {
            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                String[] data = str.split(",");
                Doctor newDoctor= new Doctor(data[0].trim(),data[1].trim(),data[2].trim(),Integer.parseInt(data[3].trim()));
                addDoctor(newDoctor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        }

    }

    public boolean addDoctor(Doctor doctor) {
        for (String test : listDoctor.keySet()) {
            if (test.matches(doctor.getCode())) {
                return false;
            }
        }
        listDoctor.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean updateDoctor(Doctor doctor) {
        for (String test : listDoctor.keySet()) {
            if (test.matches(doctor.getCode())) {
                listDoctor.get(test).setName(doctor.getName());
                listDoctor.get(test).setSpecialization(doctor.getSpecialization());
                listDoctor.get(test).setAvailability(doctor.getAvailability());
                return true;
            }
        }
        return false;
    }

    public boolean deleteDoctor(String code) {
        for (String test : listDoctor.keySet()) {
            if (test.matches(code)) {
                listDoctor.remove(test);
                return true;
            }
        }
        return false;
    }

    public HashMap<String, Doctor> searchDoctor(String input) {
        HashMap<String, Doctor> searchList = new HashMap<>();
        for (String test : listDoctor.keySet()) {
            if (listDoctor.get(test).toString().contains(input)) {
                searchList.put(test, listDoctor.get(test));
            }
        }
        return searchList;
    }
    public boolean checkAvailability(Doctor doctor) {
        return doctor.getAvailability()>=0;
    }
}
