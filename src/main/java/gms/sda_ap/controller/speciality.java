package gms.sda_ap.controller;

import gms.sda_ap.model.FileHandler;

import java.util.ArrayList;

public class speciality {

    private ArrayList<String> speciality;

    public persistenceHandler ph = new FileHandler();

    public ArrayList<String> getSpecialityList(){
        //FileHandler fh = new FileHandler();
        return ph.getSpecialityList();
    }

}
