package gms.sda_ap;

public class Account {


    private String ID;
    private String Type;
    private String amount;
    private String RecipetDate;
    public void getReciept(Reciept r){


        RecipetDate=r.getDate();



    }
}
