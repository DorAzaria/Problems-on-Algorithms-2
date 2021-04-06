package GasStationProblem;

import java.util.Arrays;

public class GasStationTest {

    public static void main(String[] args) {
        int[] a = {50,80,4,48};
        int[] b = {44,6,5,45};
        System.out.println(Arrays.toString(GasStationAlgorithm.GasStation(a,b)));

        a = new int[] {3,6,2,8};
        b = new int[] {5,4,3,4};
        System.out.println(Arrays.toString(GasStationAlgorithm.GasStation(a,b)));

        a = new int[] {5,10,12,100};
        b = new int[] {6,11,13,50};
        System.out.println(Arrays.toString(GasStationAlgorithm.GasStation(a,b)));

        a = new int[] {8,10,12,100};
        b = new int[] {6,11,13,50};
        System.out.println(Arrays.toString(GasStationAlgorithm.GasStation(a,b)));

        a = new int[] {6, 0, 0, 6, 7, 0, 7, 8, 5, 5};
        b = new int[] {7, 4, 6, 5, 3, 3, 8, 0, 1, 0};
        System.out.println(Arrays.toString(GasStationAlgorithm.GasStation(a,b)));

        a = new int[] {6,11,13,50};
        b = new int[] {8,10,12,100};
        System.out.println(Arrays.toString(GasStationAlgorithm.GasStation(a,b)));

    }
}
