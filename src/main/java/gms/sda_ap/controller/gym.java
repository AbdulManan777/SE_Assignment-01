package gms.sda_ap.controller;

import gms.sda_ap.model.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class gym {
    public persistenceHandler ph = new FileHandler();

    private String RecipetDate;

    private int a;
    private String id;

    public boolean authenticateMember(member m) {
        return m.validateMember(m);
    }

    public boolean registerMember(customer c) {
        return c.registerCustomer(c);
    }

    public boolean authenticateTrainer(trainer t) {
        return t.validateTrainer(t);
    }

    public boolean registerTrainer(trainer t) {
        return t.registerTrainer(t);
    }

    public ArrayList<String> getSpecialityList() {
        speciality sp = new speciality();
        return sp.getSpecialityList();
    }

    public List<ArrayList<String>> getPlanList() {
        plan p = new plan();
        return p.getPlanList();
    }

    public ArrayList<String> getScheduleList() {
        plan p = new plan();
        return p.getScheduleList();
    }

    public boolean createPlan(plan p) {
        trainer t = new trainer();
        return t.createPlan(p);
    }

    public boolean setMemberPlan(plan p, member m) {
        return m.setMemberPlan(p, m);
    }

    public List<ArrayList<String>> getEquipmentList() {
        equipment e = new equipment();
        return e.getEquipmentList();
    }

    public boolean setMemberSchedule(schedule s, member m) {
        return m.setMemberSchedule(s, m);
    }

    public String makePayment(int amount, String MID) {

        member m = new member();
        a = amount;
        id = MID;
        m.setCnic(MID);
        String rec = m.makePayment(amount, m);
        return rec;


    }

    public void getRecipetGym(String r) {
        this.RecipetDate = r;

    }

    public void StorePayment(String rec) {

        //FileHandler f = new FileHandler();
        boolean paymentMade = ph.StorePayment(a, id, rec);

    }

    public List<ArrayList<String>> getTrainerList() {
        trainer t = new trainer();
        return t.getTrainerList();
    }


}
