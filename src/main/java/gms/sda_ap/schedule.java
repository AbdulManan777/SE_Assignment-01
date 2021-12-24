package gms.sda_ap;


import gms.sda_ap.view.ScheduleController;

public class schedule {

    private String ID;
    private String schedule;

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
        FileHandler fh = new FileHandler();

        return fh.setMemberSchedule(s, m);
    }
}
