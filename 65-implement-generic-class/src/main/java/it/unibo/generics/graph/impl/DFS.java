package it.unibo.generics.graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Collections;

public class DFS<N> {
    private N source;
    private N target;
    private Map<N, Set<N>> graph;
    private Map<N, Boolean> visited = new HashMap<>();
    private Map<N, N> parent = new HashMap<>();
    private List<N> path = new ArrayList<>();

    public DFS(N source, N target, Map<N, Set<N>> graph) {
        this.source = source;
        this.target = target;
        this.graph = graph;
    }

    public void search() {
        // initializig nodes
        for (var node : graph.keySet()) {
            visited.put(node, false);
            parent.put(node, null);
        }

        dfs(source);

    }

    private void dfs(N node) {
        visited.put(node, true);
        for (var v : graph.get(node)) {
            if (visited.get(v) == false) {
                parent.put(v, node);
                dfs(v);
            }
        }
    }

    public List<N> path() {
        N tmp = target;
        System.out.println(tmp);
        while (!tmp.equals(source)) {
            path.add(tmp);
            tmp = parent.get(tmp);
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }

}
