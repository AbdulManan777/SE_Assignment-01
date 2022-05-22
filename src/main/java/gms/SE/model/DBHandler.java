package gms.SE.model;

import gms.SE.controller.customer;
import gms.SE.controller.member;
import gms.SE.controller.trainer;

import java.sql.*;

public class DBHandler {

    public boolean dbconnect(customer c) throws SQLException {

        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);
        /*(Statement s=connection.createStatement();
        ResultSet r=s.executeQuery("INSERT INTO member VALUES();*/

        String sql="INSERT INTO member (ID,username,password,name,gender,phone,statusflag) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement s=connection.prepareStatement(sql);
        s.setString(1,c.getCnic());
        s.setString(2,c.getUsername());
        s.setString(3,c.getPassword());
        s.setString(4,c.getName());
        s.setString(5,c.getGender());
        s.setString(6,c.getNumber());
        s.setString(7,c.getStatusFlag());
        int r=s.executeUpdate();
        if(r>0){
            return true;
        }
        else{
            return false;
        }




    }

    public int verifyMember(member m) throws SQLException {


        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);
        String sql="select username,password from member where username='"+m.getUsername()+"';";
        PreparedStatement s=connection.prepareStatement(sql);

        ResultSet r=s.executeQuery(sql);

        String un = "";
        String pw = "";
        while (r.next()) {
            un = r.getString("username");
            pw = r.getString("password");
        }


        if (m.getUsername().equals(un) && m.getPassword().equals(pw)) {
            return 1;
        }
        else if(m.getUsername().equals(un)){
            return 2;
        }
        else{
            return 0;
        }






    }



    public void StorePayment(int a,String id,String rec) throws SQLException {

        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);

        String sql="INSERT INTO Payment (Registration_Fee,MID,Date) VALUES(?,?,?);";

        PreparedStatement s=connection.prepareStatement(sql);
        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        s.setInt(1,a);
        s.setString(2,id);
        s.setString(3, rec);

        s.executeUpdate();
        s.close();
        connection.close();








    }


    public boolean pauseMembership(member m) throws SQLException {


        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);
        String sql="UPDATE member SET statusflag='pause' WHERE ID='"+m.getCnic()+"';";
        PreparedStatement s=connection.prepareStatement(sql);
        //s.setString(6,"pause");
        int r=s.executeUpdate();
        if(r>0){
            return true;
        }
        else{
            return false;
        }


    }

    public String getCNIC(member m) throws SQLException {


        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);

        String sql="SELECT ID from member WHERE username='"+m.getUsername()+"';";

        PreparedStatement s=connection.prepareStatement(sql);

        ResultSet r=s.executeQuery(sql);


        String un = "";
        while (r.next()) {
            un = r.getString("ID");

        }

        return un;





    }


    public boolean pauseMemberVerify(member m) throws SQLException {

        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);

        String sql="SELECT statusflag from member WHERE username='"+m.getUsername()+"';";

        System.out.println(m.getCnic());
        PreparedStatement s=connection.prepareStatement(sql);

        ResultSet r=s.executeQuery(sql);

        String un = "";
        while (r.next()) {
            un = r.getString("statusflag");

        }
        System.out.println(un);
        if(un.equals("active")){
            return false;
        }
        else {
            return true;
        }




    }

    public boolean paymentVerify(member m) throws SQLException {


        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);

        String sql="SELECT MID from payment WHERE MID='"+m.getCnic()+"';";


        PreparedStatement s=connection.prepareStatement(sql);

        ResultSet r=s.executeQuery(sql);

        String un = "";
        while (r.next()) {
            un = r.getString("MID");

        }

        if(un.equals(m.getCnic())){
            return true;
        }
        else{
            return false;
        }

    }

    public String getPhoneN(member m) throws SQLException {

        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);

        String sql="SELECT phone from member WHERE username='"+m.getUsername()+"';";

        PreparedStatement s=connection.prepareStatement(sql);

        ResultSet r=s.executeQuery(sql);


        String un = "";
        while (r.next()) {
            un = r.getString("phone");

        }

        return un;


    }

    public void updateProfile(member m) throws SQLException {


        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";
        System.out.println(m.getPhone());
        Connection connection= DriverManager.getConnection(jdbc,username,password);
        String sql="UPDATE member SET password='"+m.getPassword()+"',phone='"+m.getPhone()+"' WHERE ID='"+m.getCnic()+"';";
        PreparedStatement s=connection.prepareStatement(sql);
        //s.setString(6,"pause");
        s.executeUpdate();



    }

    public String getStatusFlag2(member m) throws SQLException {

        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);

        String sql="SELECT statusflag from member WHERE username='"+m.getUsername()+"';";

        PreparedStatement s=connection.prepareStatement(sql);

        ResultSet r=s.executeQuery(sql);


        String un = "";
        while (r.next()) {
            un = r.getString("statusflag");

        }

        return un;



    }

    public void ResumeMembership(member m) throws SQLException {

        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);
        String sql="UPDATE member SET statusflag='active' WHERE ID='"+m.getCnic()+"';";
        PreparedStatement s=connection.prepareStatement(sql);
        //s.setString(6,"pause");
        s.executeUpdate();




    }

    public boolean getIDmemberTrainer(member m) throws SQLException {

        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);

        String sql="SELECT MID from membertrainer WHERE MID='"+m.getCnic()+"';";

        PreparedStatement s=connection.prepareStatement(sql);

        ResultSet r=s.executeQuery(sql);


        String un = null;
        while (r.next()) {
            un = r.getString("MID");

        }

        System.out.println("Un=:"+un);

        if(un==null) {
            return false;
        }
        else{

            return true;
        }



    }

    public boolean HireTrainer(trainer t, member m) throws SQLException {


        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);

        boolean i=getIDmemberTrainer(m);
        if (i == false) {


            String sql = "INSERT INTO membertrainer (MID,TID,TrainerFee,speciality) VALUES(?,?,?,?);";

            System.out.println("hello");
            PreparedStatement s = connection.prepareStatement(sql);

            s.setString(1, m.getCnic());
            s.setString(2, t.getID());
            s.setInt(3, 500);
            s.setString(4, t.getSpeciality());

            int r = s.executeUpdate();
            if (r > 0) {
                return true;
            } else {
                return false;
            }
        }
        else{
            return false;
        }








    }


    public void CancelMembership(member m) throws SQLException {

        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);
        String sql="DELETE FROM member WHERE ID='"+m.getCnic()+"';";
        PreparedStatement s=connection.prepareStatement(sql);
        //s.setString(6,"pause");
        s.executeUpdate();




    }

    public boolean userName(String s2) throws SQLException {


        String jdbc="jdbc:mysql://localhost:3306/gymmanagment";

        String username="root";
        String password="1234";

        Connection connection= DriverManager.getConnection(jdbc,username,password);

        String sql="SELECT username from member WHERE username='"+s2+"';";

        PreparedStatement s=connection.prepareStatement(sql);

        ResultSet r=s.executeQuery(sql);


        String un = null;
        while (r.next()) {
            un = r.getString("username");

        }



        if(un==null) {
            return true;
        }
        else{

            return false;
        }





    }


}
