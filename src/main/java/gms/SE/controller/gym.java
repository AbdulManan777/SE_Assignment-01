package gms.SE.controller;

import gms.SE.model.DBHandler;
import gms.SE.model.FileHandler;
import gms.SE.model.persistenceHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class gym {
    public persistenceHandler ph = new FileHandler();

    private String RecipetDate;

    private int a;
    private String id;

    public int authenticateMember(member m) throws SQLException {
        return m.validateMember(m);
    }

    public boolean registerMember(customer c) throws SQLException {
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




    public void UpdateMember(member m) throws SQLException {
        m.UpdateMember(m);
    }

    public void getRecipetGym(String r) {
        this.RecipetDate = r;

    }

    public void StorePayment(String rec) throws SQLException {

        //FileHandler f = new FileHandler();
       // boolean paymentMade = ph.StorePayment(a, id, rec);
        DBHandler d=new DBHandler();
        d.StorePayment(a,id,rec);

    }

    public List<ArrayList<String>> getTrainerList() {
        trainer t = new trainer();
        return t.getTrainerList();
    }

    public boolean setMemberTrainer(trainer t, member u) throws SQLException {

        return u.setMemberTrainer(t, u);


    }

    public void cancelMember(member m) throws IOException, SQLException {


        m.cancelMember(m);

    }

    public void ResumeMembership(member m) throws IOException, SQLException {
           m.ResumeMembrship(m);


    }

    public void setTrainerSchedule(trainer t,String s1,String s2) throws IOException {

        t.setTrainerSchedule(t,s1,s2);


    }

    public void quitJob(trainer t) throws IOException {

       t.quitJob(t);
    }


}
