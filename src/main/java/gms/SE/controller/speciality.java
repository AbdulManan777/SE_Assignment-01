package gms.SE.controller;

import gms.SE.model.FileHandler;
import gms.SE.model.persistenceHandler;

import java.util.ArrayList;

public class speciality {

    private ArrayList<String> speciality;

    public persistenceHandler ph = new FileHandler();

    public ArrayList<String> getSpecialityList(){
        //FileHandler fh = new FileHandler();
        return ph.getSpecialityList();
    }

}
