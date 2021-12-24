package gms.sda_ap;

import java.util.ArrayList;

public class speciality {

    private ArrayList<String> speciality;

    public ArrayList<String> getSpecialityList(){
        FileHandler fh = new FileHandler();
        return fh.getSpecialityList();
    }

}
