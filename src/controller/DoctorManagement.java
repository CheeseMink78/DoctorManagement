package controller;

import java.util.HashMap;
import model.Doctor;
import model.DoctorHash;
import view.Menu;

public class DoctorManagement extends Menu {

    public static String[] choices = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"};
    private DoctorHash doctorHash = new DoctorHash();

    public DoctorManagement() {
        super("Doctor Management Program", choices);
    }
    public void addDoctor() {
        System.out.println("-----Add Doctor-----");
        String code, name, specialization;
        int availability;
        code=Input.getString("doctor code");
        name=Input.getString("doctor name");
        specialization=Input.getString("specialization");
        availability=Input.getInt("availability");
        if(doctorHash.addDoctor(new Doctor(code, name, specialization, availability))) {
            System.out.println("Sucessful");
        }
        else System.out.println("Doctor code "+code+" is duplicate");
    }
    public void updateDoctor() {
        System.out.println("-----Update Doctor-----");
        String code, name, specialization;
        int availability;
        code=Input.getString("doctor code");
        name=Input.getString("doctor name");
        specialization=Input.getString("specialization");
        availability=Input.getInt("availability");
        if(doctorHash.updateDoctor(new Doctor(code, name, specialization, availability))) {
            System.out.println("Sucessful");
        }
        else {
            System.out.println("Doctor code "+code+" doesn't exist");
        }
    }
    public void deleteDoctor() {
        System.out.println("-----Delete Doctor-----");
        String code;
        code=Input.getString("code");
        if(doctorHash.deleteDoctor(code)) {
            System.out.println("Sucessful");
        } else {
            System.out.println("Doctor code "+code+" doesn't exist");
        }
    }
    public void searchDoctor() {
        System.out.println("-----Search Doctor-----");
        String text;
        text=Input.getString("text");
        HashMap<String,Doctor> searchList= doctorHash.searchDoctor(text);
        if(searchList.isEmpty()) {
            System.out.println("Can't find");
        } else {
            System.out.println("Search list:");
            for(String test:searchList.keySet()) {
                System.out.println(searchList.get(test));
            }
        }
    }
    @Override
    public void execute(int ch) {
       switch(ch) {
           case 1:addDoctor();break;
           case 2:updateDoctor();break;
           case 3:deleteDoctor();break;
           case 4:searchDoctor();break;
           case 5:exitMenu();break;
           default:break;
       }
    }

}
