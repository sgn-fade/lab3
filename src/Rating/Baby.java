package Rating;

public class Baby {
    private String name;
    private String birthDate;
    private String gender;
    private String ethnicity;
    private String count;
    private String rnk;

    public Baby(String name, String birthDate, String gender, String ethnicity, String count, String rnk) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.count = count;
        this.rnk = rnk;
    }

    @Override
    public String toString() {
        return "\nBaby{" +
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getRnk() {
        return rnk;
    }

    public void setRnk(String rnk) {
        this.rnk = rnk;
    }
}
