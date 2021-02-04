package edu.neu.coe.info6205.sort.simple;

import edu.neu.coe.info6205.sort.GenericSort;
import edu.neu.coe.info6205.util.*;
import org.junit.Test;

import java.util.*;

public class Assignment2_part3 {
    @Test
    public void part3() {
        final int N = 100;

        //Four array order situations:random, ordered, partially-ordered and reverse-ordered.
        List<Double> randomSortedList = new ArrayList<>();
        List<Double> orderedSortedList = new ArrayList<>();
        List<Double> partially_orderSortedList = new ArrayList<>();
        List<Double> reverse_orderSortedList = new ArrayList<>();

        //Make a Random list
        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();
        for (int j = 1000; j < 2000; j++) {
            randomList.add(random.nextInt(j));
        }

        //Make a ordered list.
        List<Integer> orderedList = new ArrayList<>(Arrays.asList(new Integer[randomList.size()]));
        Collections.copy(orderedList, randomList);
        Collections.sort(orderedList);

        //Make a partially random list
        List<Integer> partiallyRandomList = new ArrayList<>();
        for(int i=1000; i<2000;i++){
            if(i<1500){
                partiallyRandomList.add(i);
            }
            else {
                partiallyRandomList.add(random.nextInt(2000-1500)+1500);
            }

        }

        //Make a reverse ordered list
        List<Integer> reverseOrderedList = new ArrayList<>(Arrays.asList(new Integer[orderedList.size()]));
        Collections.copy(reverseOrderedList,orderedList);
        Collections.reverse(reverseOrderedList);

        //*****************************************************************************************************

        //Insertion sort random list
        GenericSort insertionSort = new InsertionSort();

        Benchmark<Integer> benchmark = new Benchmark_Timer<>("RandomList sort test start...",
                blank -> {
                    insertionSort.sort(randomList);
                });

        // warm up
        benchmark.run(0, 10);

        // get average run time
        double res = 0;
        for (int i = 0; i < 10; i++) {
            res += benchmark.run(0, 10);
        }
        randomSortedList.add(res/10);

        //***************************************************************************************
        //Insertion sort ordered list
        benchmark = new Benchmark_Timer<>("ordered list test start...",
                blank -> {
                    insertionSort.sort(orderedList);
                });

        // warm up
        benchmark.run(0, 10);

        // get average run time
        res = 0;
        for (int i = 0; i < 10; i++) {
            res += benchmark.run(0, 10);
        }
        orderedSortedList.add(res/10);

        //*******************************************************************
        //Insertion sort partially random list
        // sort partially ordered list
        benchmark = new Benchmark_Timer<>("partially list test start...",
                blank -> {
                    insertionSort.sort(partiallyRandomList);
                });
        // warm up
        benchmark.run(0, 10);
        // get average run time
        res = 0;
        for (int i = 0; i < 10; i++) {
            res += benchmark.run(0, 10);
        }
        partially_orderSortedList.add(res/10);
        //****************************************************************
        //Insertion reverse ordered list
        benchmark = new Benchmark_Timer<>("reverse ordered test start...",
                blank -> {
                    insertionSort.sort(reverseOrderedList);
                });

        // warm up
        benchmark.run(0, 10);

        // get average run time
        res = 0;
        for (int i = 0; i < 10; i++) {
            res += benchmark.run(0, 10);
        }
        reverse_orderSortedList.add(res/10);

        //check the spend time.
        System.out.println(randomSortedList);
        System.out.println(orderedSortedList);
        System.out.println(partially_orderSortedList);
        System.out.println(reverse_orderSortedList);
    }


    }

