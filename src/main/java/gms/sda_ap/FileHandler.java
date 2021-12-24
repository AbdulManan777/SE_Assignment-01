package gms.sda_ap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    String line = "";
    String splitBy = ",";

    public boolean verifyMember(member m) {

        boolean authentication = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader("members.txt"));

            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(splitBy);

                if (credentials[0].equals(m.getUsername()) && credentials[1].equals(m.getPassword())) {
                    m.setCnic(credentials[2]);
                    m.setName(credentials[3]);
                    m.setGender(credentials[4]);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return authentication;
    }

    public boolean registerMember(customer c) {
        try {
            FileWriter fw = new FileWriter("members.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("\n");
            bw.write(c.getUsername() + "," + c.getPassword() + "," + c.getCnic() + "," + c.getName() + "," + c.getGender() + "," + c.getNumber() + "," + "NULL");
            bw.close();

            return true;

        } catch (IOException io) {
            io.printStackTrace();
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
                    t.setCnic(credentials[2]);
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

            bw.write("\n");
            bw.write(t.getUsername() + "," + t.getPassword() + "," + t.getCnic() + "," + t.getName() + "," + t.getNumber() + "," + t.getSpeciality() + "," + t.getAge());
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

                s.add(data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter("members.txt");
            BufferedWriter bw = new BufferedWriter(fw);


            for (int i = 0; i < s.size(); i++) {
                if(s.get(i).get(0).equals(m.getUsername()))
                    s.get(i).set(5, p.getID());
            }

            for (int i = 0; i < s.size(); i++) {
                for (int j = 0; j < s.get(i).size(); j++) {
                    if (j == 5)
                        bw.write(s.get(i).get(j));
                    else
                        bw.write(s.get(i).get(j) + ",");
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


            for (int i = 0; i < as.size(); i++) {
                if(as.get(i).get(0).equals(m.getUsername()))
                    as.get(i).set(6, s.getID());
            }

            for (int i = 0; i < as.size(); i++) {
                for (int j = 0; j < as.get(i).size(); j++) {
                    if (j == 6)
                        bw.write(as.get(i).get(j));
                    else
                        bw.write(as.get(i).get(j) + ",");
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
}
