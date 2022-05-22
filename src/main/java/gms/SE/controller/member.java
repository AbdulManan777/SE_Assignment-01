package gms.SE.controller;

import gms.SE.model.DBHandler;
import gms.SE.model.FileHandler;
import gms.SE.model.persistenceHandler;

import java.io.IOException;
import java.sql.SQLException;

public class member {

    private String username;
    private String password;
    private String name;
    private String cnic;
    private String gender;
    private String planid;
    private String phone;
    private String statusFLag="active";

    public persistenceHandler ph = new FileHandler();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {

        return phone;
    }

    public boolean setStatusFLag(member m) throws IOException, SQLException {
       /* this.statusFLag=s;
        FileHandler f=new FileHandler();
        f.updateStatus(this);*/

        DBHandler d=new DBHandler();
        return d.pauseMembership(m);
    }

    public String getStatusFLag2(member m) throws IOException, SQLException {
        DBHandler d=new DBHandler();
        return d.getStatusFlag2(m);
    }



    public void setPhone(String p){ this.phone=p; }





    public void setPassword(String password) {
        this.password = password;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanid() {
        return planid;
    }

    public void setPlanid(String planid) {
        this.planid = planid;
    }

    public int validateMember(member m) throws SQLException {
        //FileHandler fh = new FileHandler();

        /*int verify = ph.verifyMember(m);
        return verify;*/

        DBHandler d=new DBHandler();
       return d.verifyMember(m);
    }

    public boolean registerMember(customer c) throws SQLException {
        //FileHandler fh = new FileHandler();

        /*boolean verify = ph.registerMember(c);
        return verify;*/
        DBHandler d=new DBHandler();
        boolean verify=d.dbconnect(c);
        return verify;
    }

    public boolean setMemberPlan(plan p, member m) {
        return p.setMemberPlan(p, m);

    }

    public boolean setMemberSchedule(schedule s, member m) {
        return s.setMemberSchedule(s, m);

    }

    public String makePayment(int amount, member m) {

        Payment p = new Payment();
        String rec = p.makePayment(amount, m);
        return rec;
        // r.CashDeposit(p);

    }

    public boolean paymentverify(member m) throws SQLException {
        Payment p=new Payment();
        boolean s=p.PaymentChecker(m);
        return s;
    }

    public void UpdateMember(member m) throws SQLException {
        DBHandler d=new DBHandler();
        d.updateProfile(m);
    }


    public boolean setMemberTrainer(trainer t, member m) throws SQLException {
        return t.setMemberTrainer(t,m);
    }

    public boolean statusVerify(member m) throws SQLException {

       /* FileHandler f=new FileHandler();
        return f.pauseMemberVerify(m);*/
        DBHandler d=new DBHandler();
        return d.pauseMemberVerify(m);
    }



    public void cancelMember(member m) throws IOException, SQLException {

        // ph.cancelMember(m);

        DBHandler d=new DBHandler();
        d.CancelMembership(m);
    }


    public void ResumeMembrship(member m) throws IOException, SQLException {

       // ph.ResumeMembership(m);
        DBHandler d=new DBHandler();
        d.ResumeMembership(m);

    }

    public String getStatusFLag() {

        return this.statusFLag;
    }

    /*public void getmemberReciept(Reciept r) {

        this.RecipetDate = r.getDate();
        gy.getRecipetGym(this.RecipetDate);

    }*/

}