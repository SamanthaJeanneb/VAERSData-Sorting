import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {
    public static void insertionSort(List<SYMPTOMDATA> data) {
        for(int i = 1; i < data.size(); i++) {
            SYMPTOMDATA key = data.get(i);
            int j = i - 1;
            while(j >= 0 && data.get(j).VAERS_ID > key.VAERS_ID) {
                data.set(j + 1, data.get(j));
                j = j - 1;
            }
            data.set(j + 1, key);
        }
    }

    public static void quickSort(List<SYMPTOMDATA> data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }
    private static int partition(List<SYMPTOMDATA> data, int low, int high) {
        SYMPTOMDATA pivot = data.get(high);
        int i = (low - 1);
        for(int j = low; j < high; j++) {
            if (data.get(j).VAERS_ID < pivot.VAERS_ID) {
                i++;
                Collections.swap(data, i, j);
            }
        }
        Collections.swap(data, i + 1, high);
        return i + 1;
    }

    public static void mergeSort(List<SYMPTOMDATA> data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }
    private static void merge(List<SYMPTOMDATA> data, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<SYMPTOMDATA> leftList = new ArrayList<>(n1);
        List<SYMPTOMDATA> rightList = new ArrayList<>(n2);

        for(int i = 0; i < n1; i++) {
            leftList.add(data.get(left + i));
        }
        for(int j = 0; j < n2; j++) {
            rightList.add(data.get(mid + 1 + j));
        }

        int i = 0, j = 0;
        int k = left;
        while(i < n1 && j < n2) {
            if (leftList.get(i).VAERS_ID <= rightList.get(j).VAERS_ID) {
                data.set(k, leftList.get(i));
                i++;
            } else {
                data.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        while(i < n1) {
            data.set(k, leftList.get(i));
            i++;
            k++;
        }

        while(j < n2) {
            data.set(k, rightList.get(j));
            j++;
            k++;
        }
    }

}
