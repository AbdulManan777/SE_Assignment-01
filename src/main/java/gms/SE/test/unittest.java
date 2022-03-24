package gms.SE.test;

import gms.SE.controller.*;
import gms.SE.model.FileHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class unittest {
    @Test
    public void test1() {
        member obj = new member();
        obj.setUsername("Saad");
        String get = obj.getUsername();
        assertTrue("Saad".equals(get));
    }
    @Test
    public void test2(){
        member obj = new member();
        obj.setUsername("Saad");
        String get = obj.getUsername();
        assertTrue("Saad".equals(get));
    }
    @Test
    public void test3(){
        member obj = new member();
        obj.setGender("Male");
        String get = obj.getGender();
        assertTrue("Male".equals(get));
    }
    @Test
    public void test4(){
        member obj = new member();
        obj.setPassword("abc123");
        String get = obj.getPassword();
        assertFalse("ncjjdah".equals(get));
    }
    @Test
    public void test5(){
        member obj = new member();
        obj.setCnic("123457890123");
        String get = obj.getCnic();
        assertFalse("342467578654".equals(get));
    }
    @Test
    public void test6(){
        FileHandler obj = new FileHandler();
        ArrayList<String> get = obj.getSpecialityList();
        assertFalse("1,Cardio".equals(get));
    }
    @Test
    public void test7(){
        FileHandler obj = new FileHandler();
        List<ArrayList<String>> get = obj.getPlanList();
        assertFalse(Boolean.parseBoolean("1,plan1,hehehehehehe,time1\n" +
                "2,plan2,hehehehehehe,time2\n" +
                "3,plan3,hehehehehehe,time3\n" +
                "4,plan4,hehehehehehe,time4\n" +
                "5,plan5,hehehehehehe,time5\n" +
                "4,test,asdafsdfsdfs,time4".equals(get)));
    }
    @Test
    public void test8(){
        Payment obj = new Payment();
        obj.setRegistration(200);
        int get = obj.getRegisterFee();
        assertEquals(200,get);
    }
    @Test
    public void test9(){
        customer c=new customer();
        boolean flag=false;
        flag=c.registerCustomer(c);
        assertEquals(true,flag);
    }
    /*
    @Test
    public void test10(){
       plan p=new plan();
       p.setID("3");
       member m=new member();
       m.setUsername("talha");
       boolean fl;
       FileHandler f=new FileHandler();
       fl=f.setMemberPlan(p,m);
        assertEquals(true,fl);
    }*/
    @Test
    public void test11(){
       gym g=new gym();
        assertNotEquals("12",g.makePayment(200,"3"));
    }

    @Test
    public void test12() {
        trainer obj = new trainer();
        obj.setUsername("talha");
        String get = obj.getUsername();
        assertTrue("talha".equals(get));
    }
    @Test
    public void test13() {
        trainer obj = new trainer();
        obj.setPassword("t12345");
        String get = obj.getPassword();
        assertTrue("t12345".equals(get));
    }
    @Test
    public void test14() {
        trainer obj = new trainer();
        obj.setCnic("3740685671");
        String get = obj.getCnic();
        assertTrue("3740685671".equals(get));
    }
    @Test
    public void test15() {
        trainer obj = new trainer();
        obj.setName("Manan");
        String get = obj.getName();
        assertTrue("Manan".equals(get));
    }
    @Test
    public void test16() {
        trainer obj = new trainer();
        obj.setAge("30");
        String get = obj.getAge();
        assertTrue("30".equals(get));
    }
    @Test
    public void test17() {
        trainer obj = new trainer();
        obj.setSpeciality("Cardio");
        String get = obj.getSpeciality();
        assertTrue("Cardio".equals(get));
    }
    @Test
    public void test18() {
        trainer obj = new trainer();
        obj.setNumber("122330");
        String get = obj.getNumber();
        assertTrue("122330".equals(get));
    }

}

