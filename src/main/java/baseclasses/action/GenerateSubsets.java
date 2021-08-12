package baseclasses.action;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {
    static <T> List<List<T>> generateSetOfAllSubsets(List<T> list) {
        if (list.size() == 0) {
            List<List<T>> ones = new ArrayList<>();
            List<T> empty = new ArrayList<>(1);
            ones.add(empty);
            return ones;
        }
        List<List<T>> sublist = generateSetOfAllSubsets(list.subList(1, list.size()));
        List<List<T>> copy = new ArrayList<>(sublist.size());
        for (List<T> i : sublist) {
            List<T> newList = new ArrayList<>(i);
            newList.add(list.get(0));
            copy.add(new ArrayList<>(newList));
        }
        sublist.addAll(copy);
        return sublist;
    }
}
