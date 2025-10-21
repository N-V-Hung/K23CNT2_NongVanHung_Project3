package k23cnt2.nvh.day2.dependency_injection.tight_loosely_coupling;

import java.util.Arrays;

interface SortAlgorithm {
    void sort(int[] array);
}

class LooselyBubbleSortAlgorithm implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorted using bubble sort algorithm");
        Arrays.stream(array).sorted().forEach(System.out::println);
    }
}

public class LooselyCoupledService {
    private SortAlgorithm sortAlgorithm;

    public LooselyCoupledService(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public void complexBusiness(int[] array) {
        sortAlgorithm.sort(array);
    }

    public static void main(String[] args) {
        LooselyCoupledService service = new LooselyCoupledService(new LooselyBubbleSortAlgorithm());
        service.complexBusiness(new int[]{11, 21, 13, 42, 15});
    }
}
