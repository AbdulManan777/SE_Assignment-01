package gms.SE.controller;

import gms.SE.model.FileHandler;
import gms.SE.model.persistenceHandler;

import java.util.ArrayList;
import java.util.List;

public class trainer {

    private String ID;
    private String username;
    private String password;
    private String name;
    private String cnic;
    private String number;
    private String age;
    private String speciality;

    public persistenceHandler ph = new FileHandler();

    public trainer(String ID, String name, String speciality){
        this.ID = ID;
        this.name = name;
        this.speciality = speciality;
    }

    public trainer(){

    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID(String ID) {
        return ID;
    }
    //SETTERS
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //GETTERS
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public String getNumber() { return number; }

    public String getSpeciality() {
        return speciality;
    }

    public String getAge() {
        return age;
    }

    public boolean validateTrainer(trainer t) {
        //FileHandler fh = new FileHandler();

        return ph.verifyTrainer(t);
    }

    public boolean registerTrainer(trainer t) {
        //FileHandler fh = new FileHandler();

        return ph.registerTrainer(t);
    }

    public boolean createPlan(plan p) {
        //FileHandler fh = new FileHandler();
        plan p1=new plan();
        return p1.createPlan(p);
    }

    public List<ArrayList<String>> getTrainerList(){
        //FileHandler fh = new FileHandler();
        return ph.getTrainerList();
    }


}
