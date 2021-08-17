package baseclasses.action;

import java.util.*;

public class GenerateSubsets {
    static <T> Set<List<T>> generateSetOfAllSubsets(List<T> list) {
        if (list.size() == 0) {
            Set<List<T>> ones = new LinkedHashSet<>();
            List<T> empty = new ArrayList<>(1);
            ones.add(empty);
            return ones;
        }
        Set<List<T>> sublists = generateSetOfAllSubsets(list.subList(1, list.size()));
        Set<List<T>> copy = new HashSet<>(sublists.size());
        for (List<T> sublist : sublists) {
            List<T> newList = new ArrayList<>(sublist);
            newList.add(list.get(0));
            copy.add(new ArrayList<>(newList));
        }
        sublists.addAll(copy);
        return sublists;
    }
}
