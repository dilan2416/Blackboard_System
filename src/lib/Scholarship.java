package lib;

public interface Scholarship {

    void setScholarshipAmount(int num);

    void setScholarshipRate(double rate);

    int getScholarshipAmount();

    double getScholarshipRate();

}

class statusBasedScholar implements Scholarship{
    private String status;
    private int num;
    private double rate;
    private String name;
    statusBasedScholar(String status, int num, double rate, String name){
        setName(name);
        setScholarshipAmount(num);
        setScholarshipRate(rate);
        this.status = status;
    }
    @Override
    public void setScholarshipAmount(int num) {
        // TODO Auto-generated method stub
        this.num = num;
    }

    @Override
    public void setScholarshipRate(double rate) {
        // TODO Auto-generated method stub
        this.rate = rate;
    }

    @Override
    public int getScholarshipAmount() {
        // TODO Auto-generated method stub
        return num;
    }

    @Override
    public double getScholarshipRate() {
        // TODO Auto-generated method stub
        return rate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


}

class MeritBasedScholar implements Scholarship{
    private int num;
    private double rate;
    private int grade;
    private String name;
    MeritBasedScholar(int grade, int num, double rate, String name){
        setName(name);
        setGrade(grade);
        setScholarshipAmount(num);
        setScholarshipRate(rate);
    }
    @Override
    public void setScholarshipAmount(int num) {
        // TODO Auto-generated method stub
        this.num = num;
    }

    @Override
    public void setScholarshipRate(double rate) {
        // TODO Auto-generated method stub
        this.rate = rate;
    }

    @Override
    public int getScholarshipAmount() {
        // TODO Auto-generated method stub
        return num;
    }

    @Override
    public double getScholarshipRate() {
        // TODO Auto-generated method stub
        return rate;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}

