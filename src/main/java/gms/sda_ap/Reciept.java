package gms.sda_ap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reciept {

    private String date1;

    public String CashDeposit(Payment p,member m){

           if(p.getRegisterFee()==0&&p.getTrainerFee()==0&&p.getMemberID().equals("")){

               this.date1="Receipt cannot be generated";

           }

           else{

               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
               LocalDateTime now = LocalDateTime.now();
               this.date1=dtf.format(now);
           }
       // Account a=new Account();
      //  a.getReciept(this);

      //  m.getmemberReciept(this);
        return this.date1;

    }

    public String getDate(){
        return this.date1;
    }


}
