package gms.sda_ap;

public class trainer {

    private String username;
    private String password;
    private String name;
    private String cnic;
    private String number;
    private String age;
    private String speciality;

    //SETTERS
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //GETTERS
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public String getNumber() { return number; }

    public String getSpeciality() {
        return speciality;
    }

    public String getAge() {
        return age;
    }

    public boolean validateTrainer(trainer t) {
        FileHandler fh = new FileHandler();

        return fh.verifyTrainer(t);
    }

    public boolean registerTrainer(trainer t) {
        FileHandler fh = new FileHandler();

        return fh.registerTrainer(t);
    }

    public boolean createPlan(plan p) {
        FileHandler fh = new FileHandler();

        return fh.createPlan(p);
    }


}
