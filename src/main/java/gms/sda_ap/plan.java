package gms.sda_ap;

import java.util.ArrayList;
import java.util.List;

public class plan {
    private String ID;

    private String planName;

    private String description;

    private String schedule;

    public plan(String idp, String pn, String desc) {
        this.ID = idp;
        this.planName = pn;
        this.description = desc;
    }

    public plan()
    {
        ID = null;
        planName = null;
        description = null;
    }

    public void setID(String id){
        this.ID = id;
    }

    public void setPlanName(String planName){
        this.planName = planName;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getID(){
        return ID;
    }

    public String getPlanName(){
        return planName;
    }

    public String getDescription(){
        return description;
    }

    public void setSchedule(String schedule){
        this.schedule = schedule;
    }

    public String getSchedule(){
        return schedule;
    }

    public List<ArrayList<String>> getPlanList(){
        FileHandler fh = new FileHandler();
        return fh.getPlanList();
    }

    public ArrayList<String> getScheduleList(){
        FileHandler fh = new FileHandler();
        return fh.getScheduleList();
    }

    public Boolean setMemberPlan(plan p, member m){
        FileHandler fh = new FileHandler();

        return fh.setMemberPlan(p, m);
    }
}
