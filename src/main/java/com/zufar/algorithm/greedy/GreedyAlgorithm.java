package com.zufar.algorithm.greedy;

import java.util.*;

public class GreedyAlgorithm {

    public static void main(String[] args) {
        Set<String> statesNeeded = new HashSet<>(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az")); // Все существующие штаты

        Map<String, Set<String>> stations = new HashMap<>(); // Все станции вместе со штатами, которые они покрывают
        stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));

        Set<String> finalStations = new HashSet<>();
        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();
            for (String station: stations.keySet()) {
                Set<String>  covered = new HashSet<>(statesNeeded);
                Set<String> currentStationStates = stations.get(station);
                covered.retainAll(currentStationStates); // Находим пересечение
                if (covered.size() > statesCovered.size()) {
                    bestStation = station;
                    statesCovered = covered;
                }
            }
            statesNeeded.removeAll(statesCovered);
            finalStations.add(bestStation);
        }
        System.out.println(finalStations);
    }
}
