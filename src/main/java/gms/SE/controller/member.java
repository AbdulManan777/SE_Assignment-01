package gms.SE.controller;

import gms.SE.model.FileHandler;
import gms.SE.model.persistenceHandler;

public class member {

    private String username;
    private String password;
    private String name;
    private String cnic;
    private String gender;
    private String planid;

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

    public boolean validateMember(member m) {
        //FileHandler fh = new FileHandler();

        boolean verify = ph.verifyMember(m);
        return verify;
    }

    public boolean registerMember(customer c) {
        //FileHandler fh = new FileHandler();

        boolean verify = ph.registerMember(c);
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

    /*public void getmemberReciept(Reciept r) {

        this.RecipetDate = r.getDate();
        gy.getRecipetGym(this.RecipetDate);

    }*/

}