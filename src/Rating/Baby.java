package Rating;

public class Baby {
    private String name;
    private int birthDate;
    private String gender;
    private String ethnicity;
    private int count;
    private int rnk;

    public Baby(String name, int birthDate, String gender, String ethnicity, int count, int rnk) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.count = count;
        this.rnk = rnk;
    }

    @Override
    public String toString() {
        return "Baby{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", count=" + count +
                ", rnk=" + rnk +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRnk() {
        return rnk;
    }

    public void setRnk(int rnk) {
        this.rnk = rnk;
    }
}
