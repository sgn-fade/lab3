package Rating;

import java.util.ArrayList;
import java.util.Comparator;

public class BabiesList extends ArrayList<Baby>{
    private final String ethnicity;
    private final ArrayList<Baby> babies = new ArrayList<>();

    public BabiesList(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getEthnicity() {
        return ethnicity;
    }
    @Override
    public boolean isEmpty() {
        return babies.isEmpty();
    }

    @Override
    public int size() {
        return babies.size();
    }

    @Override
    public boolean add(Baby baby) {
        babies.add(baby);
        sortList();
        return true;
    }
    public void sortList() {
        babies.sort(new Comparator<Baby>() {
            @Override
            public int compare(Baby baby1, Baby baby2) {
                return Integer.parseInt(baby2.getCount()) - (Integer.parseInt(baby1.getCount()));
            }
        });
        while (babies.size() > 5) {
            babies.remove(babies.size() - 1);
        }
    }

    public ArrayList<Baby> getBabies() {
        return babies;
    }

    @Override
    public void clear() {
        babies.clear();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Baby baby : babies){
            sb.append(baby);
        }
        return sb.toString();
    }
}
