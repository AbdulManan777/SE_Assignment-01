package gms.sda_ap.controller;

public class Payment {

private member m;

private int regFee;

private int trainFee;

public void setMemberID(String i){

    m.setCnic(i);
}

public void setRegistration(int f){

    this.regFee=f;
}

public void setTrainerFee(int tf){

    this.trainFee=tf;
}

    public String getMemberID(){

        return this.m.getCnic();
    }

    public int getTrainerFee(){

        return this.trainFee;
    }

    public int getRegisterFee(){

        return this.regFee;
    }

    public String makePayment(int amount, member m){

          this.setRegistration(amount);
          Reciept r=new Reciept();
        String rec=  r.CashDeposit(this,m);
        return rec;
    }



    
}
