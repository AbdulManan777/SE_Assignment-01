package gms.sda_ap;

import java.util.ArrayList;
import java.util.List;

public class equipment {

    private String id;
    private String name;
    private String manufacture_date;

    public equipment(String id, String name, String man_date){
        this.id = id;
        this.name = name;
        this.manufacture_date = man_date;
    }

    public equipment() {

    }

    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setManufacture_date(String name){
        this.manufacture_date = manufacture_date;
    }
    public String getManufacture_date(){
        return manufacture_date;
    }

    public List<ArrayList<String>> getEquipmentList(){
        FileHandler fh = new FileHandler();

        return fh.getEquipmentList();
    }
}
