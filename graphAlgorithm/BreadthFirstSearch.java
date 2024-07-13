package com.zufar.algorithm.graphAlgorithm;

import com.zufar.algorithm.structures.trees.TreeNode;

import java.util.*;
import java.util.function.Predicate;

public class BreadthFirstSearch {

    public static TreeNode<Integer> findFirstByPredicate(TreeNode<Integer> root, 
                                                         Predicate<Integer> condition) {
        ArrayDeque<TreeNode<Integer>> numbersQueue = new ArrayDeque<>(root.getChildren());
        Set<TreeNode<Integer>> checkedNodes = new HashSet<>();
        TreeNode<Integer> current;
        do {
            current = numbersQueue.pollFirst();
            if (checkedNodes.contains(current) || current == null) {
                continue;
            }
            if (condition.test(current.getValue())) {
                return current;
            }
            numbersQueue.addAll(current.getChildren());
            checkedNodes.add(current);

        } while (current != null);
        return null;
    }
}
