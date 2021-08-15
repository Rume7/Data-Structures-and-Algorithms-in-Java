package com.packt.datastructuresandalg.lesson1.activity.improveintersection;

import com.packt.datastructuresandalg.lesson1.binarysearch.BinarySearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Intersection {

    private BinarySearch search = new BinarySearch();

    public List<Integer> intersection(int[] a, int[] b) {
        List<Integer> result = new LinkedList<>();
        for (int x : a) {
            for (int y : b) {
                if (x == y) result.add(x);
            }
        }
        return result;
    }

    public List<Integer> intersectionFast(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> intersect = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                int value = map.get(a[i]);
                map.put(a[i], value+1);
            } else {
                map.put(a[i], 1);
            }
        }

        for (int j = 0; j < b.length; j++) {
            if (map.containsKey(b[j])) {
                int value = map.get(b[j]);
                if (value > 0) {
                    intersect.add(b[j]);
                    map.put(b[j], value-1);
                } else {
                    map.remove(b[j]);
                }
            }
        }
        return intersect;
    }

    public void mergeSort(int[] input) {
        Arrays.sort(input);
    }

    public static void main(String[] args) {
        Intersection inter = new Intersection();
        System.out.println(inter.intersection(new int[]{4, 7, 5, 2, 3}, new int[]{4, 2, 3, 9, 1}));
        System.out.println(inter.intersection(new int[]{4, 6, 11, 2, 3}, new int[]{5, 11, 3, 9, 1}));

        System.out.println(inter.intersectionFast(new int[]{4, 7, 5, 2, 3}, new int[]{4, 2, 3, 9, 1}));
        System.out.println(inter.intersectionFast(new int[]{4, 6, 11, 2, 3}, new int[]{5, 11, 3, 9, 1}));
    }
}
