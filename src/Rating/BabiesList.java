package Rating;

import java.util.ArrayList;
import java.util.Comparator;

public class BabiesList extends ArrayList<Baby>{
    private String ethnicity;
    private final ArrayList<Baby> babies = new ArrayList<>();

    public BabiesList(String ethnicity) {
        this.ethnicity = ethnicity;
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
        return babies.add(baby);
    }

    @Override
    public void clear() {
        babies.clear();
    }

    @Override
    public void sort(Comparator<? super Baby> c) {
        babies.sort(c);
    }

    @Override
    public String toString() {
        return babies.toString();
    }
}
