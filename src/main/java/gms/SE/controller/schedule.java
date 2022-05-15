package gms.SE.controller;


import gms.SE.model.FileHandler;
import gms.SE.model.persistenceHandler;

import java.io.IOException;

public class schedule {

    private String ID;
    private String schedule;

    public persistenceHandler ph = new FileHandler();

    public schedule(String ID, String schedule){
        this.ID = ID;
        this.schedule = schedule;
    }

    public schedule(){

    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getID(){
        return ID;
    }

    public void setSchedule(String schedule){
        this.schedule = schedule;
    }
    public String getSchedule(){
        return schedule;
    }

    public Boolean setMemberSchedule(schedule s, member m){
        //FileHandler fh = new FileHandler();

        return ph.setMemberSchedule(s, m);
    }

    public void setTrainerSchedule(trainer t,String s1,String s2) throws IOException {

       ph.setTrainerSchedule(t,s1,s2);
    }
}
