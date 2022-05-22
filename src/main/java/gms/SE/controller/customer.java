package gms.SE.controller;

import java.sql.SQLException;

public class customer {

    private String username;
    private String password;
    private String name;
    private String cnic;
    private String number;
    private String gender;
    private String statusFlag="active";

    //SETTERS
    public void setUsername(String username)
    {
        this.username = username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setCnic(String cnic)
    {
        this.cnic = cnic;
    }
    public void setNumber(String number)
    {
        this.number = number;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    public void setStatusFlag(String f){this.statusFlag=f; }

    //GETTERS
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public String getName()
    {
        return name;
    }
    public String getCnic()
    {
        return cnic;
    }
    public String getNumber()
    {
        return number;
    }
    public String getGender()
    {
        return gender;
    }
    public String getStatusFlag(){ return statusFlag; }

    public boolean registerCustomer(customer c) throws SQLException {
        member m = new member();
        boolean status = m.registerMember(c);
        return status;
    }



}
