package gms.SE.model;

import gms.SE.controller.*;

import java.io.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler extends persistenceHandler {
    String line = "";
    String splitBy = ",";

    public int verifyMember(member m) {

        int authentication = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("members.txt"));

            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);

                if (credentials[0].equals(m.getUsername()) && credentials[1].equals(m.getPassword())) {
                    m.setCnic(credentials[2]);
                    m.setName(credentials[3]);
                    m.setGender(credentials[4]);

                    m.setPhone(credentials[5]);
                    return 1;
                }
                else if(credentials[0].equals(m.getUsername())){
                    return 2;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return authentication;
    }


    public void updateMember(member m) throws IOException {

        File originalFile = new File("members.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        // Construct the new file that will later be renamed to the original
        // filename.
        File tempFile = new File("temp.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));


        // Read from the original file and write to the new
        // unless content matches data to be removed.
        while ((line = br.readLine()) != null) {
            String[] credentials = line.split(splitBy);
            if (credentials[2].equals(m.getCnic())) {


            } else {
                pw.write(credentials[0] + "," + credentials[1] + "," + credentials[2] + "," + credentials[3] + "," + credentials[4] + "," + credentials[5] + ","+credentials[6]+"," + "NULL" + "," + "NULL");
                pw.write("\n");
            }

        }

        pw.write(m.getUsername()+","+m.getPassword()+","+m.getCnic()+ "," + m.getName() + "," + m.getGender() + "," + m.getPhone() + "," +m.getStatusFLag()+","+ "NULL" + "," + "NULL");


        pw.println(line);
        pw.flush();

        pw.close();
        br.close();


        // Delete the original file


       // if (!originalFile.delete()) {

       // }

        // Rename the new file to the filename the original file had.
        //if (!tempFile.renameTo(originalFile)){}

        PrintWriter writer = new PrintWriter("members.txt");
        writer.print("");
        writer.close();



        File originalFile2 = new File("temp.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(originalFile2));

        // Construct the new file that will later be renamed to the original
        // filename.
        File tempFile2 = new File("members.txt");
        PrintWriter pw2 = new PrintWriter(new FileWriter(tempFile2));


        // Read from the original file and write to the new
        // unless content matches data to be removed.
        while ((line = br2.readLine()) != null) {
            String[] credentials = line.split(splitBy);

                pw2.write(credentials[0] + "," + credentials[1] + "," + credentials[2] + "," + credentials[3] + "," + credentials[4] + "," + credentials[5] + ","+credentials[6]+"," + "NULL" + "," + "NULL");
                pw2.write("\n");


        }

        //pw2.println(line);
        pw2.flush();

        pw2.close();
        br2.close();


      tempFile2.delete();


    }



        public boolean registerMember(customer c) {
        try {
            FileWriter fw = new FileWriter("members.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);


            bw.write(c.getUsername() + "," + c.getPassword() + "," + c.getCnic() + "," + c.getName() + "," + c.getGender() + "," + c.getNumber() + ","+ c.getStatusFlag()+","+ "NULL" + "," + "NULL");
            bw.write("\n");
            bw.close();

            return true;

        } catch (IOException io) {
            io.printStackTrace();
        }
        return false;
    }


    public void updateStatus(member m) throws IOException {



        File originalFile = new File("members.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        // Construct the new file that will later be renamed to the original
        // filename.
        File tempFile = new File("temp2.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));


        // Read from the original file and write to the new
        // unless content matches data to be removed.

        while ((line = br.readLine()) != null) {

            String[] credentials = line.split(splitBy);
            if (credentials[2].equals(m.getCnic())) {

                pw.write(credentials[0] + "," + credentials[1] + "," + credentials[2] + "," + credentials[3] + "," + credentials[4] + "," + credentials[5] + "," + m.getStatusFLag() + "," + "NULL" + "," + "NULL");
                pw.write("\n");
            } else {

                pw.write(credentials[0] + "," + credentials[1] + "," + credentials[2] + "," + credentials[3] + "," + credentials[4] + "," + credentials[5] + "," + credentials[6] + "," + "NULL" + "," + "NULL");
                pw.write("\n");
            }
        }



           // pw.println(line);
            pw.flush();

            pw.close();
            br.close();


            // Delete the original file


            // if (!originalFile.delete()) {

            // }

            // Rename the new file to the filename the original file had.
            //if (!tempFile.renameTo(originalFile)){}

            PrintWriter writer = new PrintWriter("members.txt");
            writer.print("");
            writer.close();



            File originalFile2 = new File("temp2.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(originalFile2));

            // Construct the new file that will later be renamed to the original
            // filename.
            File tempFile2 = new File("members.txt");
            PrintWriter pw2 = new PrintWriter(new FileWriter(tempFile2));


            // Read from the original file and write to the new
            // unless content matches data to be removed.
            while ((line = br2.readLine()) != null) {
                String[] credentials2 = line.split(splitBy);

                pw2.write(credentials2[0] + "," + credentials2[1] + "," + credentials2[2] + "," + credentials2[3] + "," + credentials2[4] + "," + credentials2[5] + "," +credentials2[6]+","+ "NULL" + "," + "NULL");
                pw2.write("\n");


            }

            //pw2.println(line);
            pw2.flush();

            pw2.close();
            br2.close();


            tempFile2.delete();





        }



        public boolean pauseMemberVerify(member m){


            try {
                BufferedReader br2 = new BufferedReader(new FileReader("members.txt"));
                while ((line = br2.readLine()) != null) {
                    String[] credentials2 = line.split(splitBy);

                    if (m.getStatusFLag().equals(credentials2[6].equals("pause"))) {
                        return true;
                    }

                }



            } catch (IOException e) {
                e.printStackTrace();
            }

            return false;
        }






    //----------------------------TRAINER---------------------------------

    public boolean verifyTrainer(trainer t) {

        boolean authentication = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader("trainers.txt"));

            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);

                if (credentials[0].equals(t.getUsername()) && credentials[1].equals(t.getPassword())) {
                    t.setID(credentials[2]);
                    t.setName(credentials[3]);
                    t.setNumber(credentials[4]);
                    t.setSpeciality(credentials[5]);
                    t.setAge(credentials[6]);

                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return authentication;
    }

    public boolean registerTrainer(trainer t) {
        try {
            FileWriter fw = new FileWriter("trainers.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);


            bw.write(t.getUsername() + "," + t.getPassword() + "," + t.getID() + "," + t.getName() + "," + t.getNumber() + "," + t.getSpeciality() + "," + t.getAge());
            bw.write("\n");
            bw.close();

            return true;

        } catch (IOException io) {
            io.printStackTrace();
        }
        return false;
    }

    public ArrayList<String> getSpecialityList() {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("speciality.txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);

                list.add(credentials[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ArrayList<String>> getPlanList() {
        List<ArrayList<String>> s = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("plan.txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);

                ArrayList<String> data = new ArrayList<>();
                data.add(credentials[0]);
                data.add(credentials[1]);
                data.add(credentials[2]);
                data.add(credentials[3]);

                s.add(data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public ArrayList<String> getScheduleList() {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("plan.txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);

                list.add(credentials[3]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean createPlan(plan p) {
        try {
            FileWriter fw = new FileWriter("plan.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("\n");
            bw.write(p.getID() + "," + p.getPlanName() + "," + p.getDescription() + "," + p.getSchedule());
            bw.close();

            return true;

        } catch (IOException io) {
            io.printStackTrace();
        }
        return false;
    }

    public boolean setMemberPlan(plan p, member m) {

        List<ArrayList<String>> s = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("members.txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);

                ArrayList<String> data = new ArrayList<>();
                data.add(credentials[0]);
                data.add(credentials[1]);
                data.add(credentials[2]);
                data.add(credentials[3]);
                data.add(credentials[4]);
                data.add(credentials[5]);
                data.add(credentials[6]);

                s.add(data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter("members.txt");
            BufferedWriter bw = new BufferedWriter(fw);


            for (ArrayList<String> strings : s) {
                if (strings.get(0).equals(m.getUsername()))
                    strings.set(5, p.getID());
            }

            for (ArrayList<String> strings : s) {
                for (int j = 0; j < strings.size(); j++) {
                    if (j == 6  )
                        bw.write(strings.get(j));
                    else
                        bw.write(strings.get(j) + ",");
                }
                bw.write("\n");
            }
            bw.close();

        } catch (IOException io) {
            io.printStackTrace();
        }
        return true;

    }

    public List<ArrayList<String>> getEquipmentList() {
        List<ArrayList<String>> s = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("equipment.txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);

                ArrayList<String> data = new ArrayList<>();
                data.add(credentials[0]);
                data.add(credentials[1]);
                data.add(credentials[2]);

                s.add(data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    public boolean setMemberSchedule(schedule s, member m) {

        List<ArrayList<String>> as = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("members.txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);

                ArrayList<String> data = new ArrayList<>();
                data.add(credentials[0]);
                data.add(credentials[1]);
                data.add(credentials[2]);
                data.add(credentials[3]);
                data.add(credentials[4]);
                data.add(credentials[5]);
                data.add(credentials[6]);

                as.add(data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter("members.txt");
            BufferedWriter bw = new BufferedWriter(fw);


            for (ArrayList<String> a : as) {
                if (a.get(0).equals(m.getUsername()))
                    a.set(6, s.getID());
            }

            for (ArrayList<String> a : as) {
                for (int j = 0; j < a.size(); j++) {
                    if (j == 6)
                        bw.write(a.get(j));
                    else
                        bw.write(a.get(j) + ",");
                }
                bw.write("\n");
            }
            bw.close();

        } catch (IOException io) {
            io.printStackTrace();
        }
        return true;

    }

    public boolean StorePayment( int a, String i,String rec){

        try {
            FileWriter fw = new FileWriter("PaymentRecieved.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("\n");
            bw.write(a + "," + i+ "," +rec);
            bw.close();

            return true;

        } catch (IOException io) {
            io.printStackTrace();
        }
        return false;
    }

    public List<ArrayList<String>> getTrainerList() {
        List<ArrayList<String>> s = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("trainers.txt"));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);

                ArrayList<String> data = new ArrayList<>();
                data.add(credentials[3]);
                data.add(credentials[5]);
                data.add(credentials[2]);

                s.add(data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }


    public boolean paymentMade(member m) {
       // String line2 = null;

        try {
            BufferedReader br2 = new BufferedReader(new FileReader("PaymentRecieved.txt"));
            while ((line = br2.readLine()) != null) {
                String[] credentials2 = line.split(splitBy);

                if (m.getCnic().equals(credentials2[1])) {
                    return true;
                }

            }



        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }



    public boolean setMemberTrainer(trainer t, member m){

        try {
            FileWriter fw = new FileWriter("HireTrainer.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);


            bw.write(m.getUsername() + "," + m.getCnic()+ "," +t.getName()+","+t.getID());
            bw.write("\n");
            bw.close();

            return true;

        } catch (IOException io) {
            io.printStackTrace();
        }
        return false;



    }

}
