package gms.SE.model;

import gms.SE.controller.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class persistenceHandler {

    public abstract int verifyMember(member m);
    public abstract boolean registerMember(customer c);
    public abstract boolean verifyTrainer(trainer t);
    public abstract boolean registerTrainer(trainer t);
    public abstract ArrayList<String> getSpecialityList();
    public abstract List<ArrayList<String>> getPlanList();
    public abstract ArrayList<String> getScheduleList();
    public abstract boolean createPlan(plan p);
    public abstract boolean setMemberPlan(plan p, member m);
    public abstract List<ArrayList<String>> getEquipmentList();
    public abstract boolean setMemberSchedule(schedule s, member m);
    public abstract boolean setMemberTrainer(trainer t, member m);
    public abstract boolean StorePayment( int a, String i,String rec);
    public abstract void cancelMember(member m) throws IOException;
    public abstract void ResumeMembership(member m) throws IOException;
    public abstract String getStatusFlag2(member m) throws IOException;
    public abstract void setTrainerSchedule(trainer t,String s1,String s2) throws IOException;
    public abstract void quitJob(trainer t) throws IOException;
    public abstract List<ArrayList<String>> getTrainerList();

}
