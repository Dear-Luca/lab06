package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Queue;
import java.util.Collections;

public class BFS<N> {
    private Map<N, Boolean> visited = new HashMap<>();
    private Map<N, N> parent = new HashMap<>();
    private N source;
    private N target;
    private Map<N, Set<N>> graph;

    public BFS(N source, N target, Map<N, Set<N>> graph) {
        this.source = source;
        this.target = target;
        this.graph = graph;
    }

    public List<N> search() {
        // initializing the nodes
        for (var u : graph.keySet()) {
            visited.put(u, false);
            parent.put(u, null);
        }
        // creating queue for BFS
        Queue<N> queue = new LinkedList<>();
        // visiting the source
        queue.add(source);
        visited.put(source, true);

        while (!queue.isEmpty()) {
            var u = queue.remove();
            for (var v : graph.get(u)) {
                if (visited.get(v) == false) {
                    queue.add(v);
                    visited.put(v, true);
                    parent.put(v, u);
                }
            }
        }
        List<N> path = new ArrayList<>();
        N tmp = target;
        while (tmp != source) {
            path.add(tmp);
            tmp = parent.get(tmp);
        }
        path.add(source);
        System.out.println(path.toString());
        Collections.reverse(path);
        return path;
    }

}
