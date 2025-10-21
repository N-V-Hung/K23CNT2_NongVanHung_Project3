package k23cnt2.nvh.day2.dependency_injection.tight_loosely_coupling;

import java.util.Arrays;

// Tight coupling
class BubbleSortAlgorithm {
    public void sort(int[] arr) {
        System.out.println("Sắp xếp theo giải thuật BubbleSort");
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}

class TightCouplingService {
    private BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();

    public void complexBusinessSort(int[] arr) {
        bubbleSortAlgorithm.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void main(String[] args) {
        TightCouplingService service = new TightCouplingService();
        service.complexBusinessSort(new int[]{11, 21, 13, 42, 15});
    }
}
