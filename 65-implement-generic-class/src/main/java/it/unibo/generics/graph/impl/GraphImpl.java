package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.*;

public class GraphImpl<N> implements Graph<N>{

    protected Map<N, Set<N>> graph = new HashMap<>();

    @Override
    public void addEdge(N source, N target) {
        if(source != null && target != null){
            Set<N> set = graph.get(source);
            set.add(target);
        }
        
    }

    @Override
    public void addNode(N node) {
        if(graph.get(node) == null && node != null){
            Set<N> adj = new HashSet<>();
            graph.put(node, adj);
        }
    }

    private String choose(){
        System.out.println("Insert 1 for BFS, 2 for DFS");
        String val;
        do {
            val = System.console().readLine();
            switch (val) {
                case "1":
                    System.out.println("You have selected BFS");
                    break;
                case "2":
                    System.out.println("You have selected DFS");
                    break;
                default:
                    System.out.println("Error! Insert 1 for BFS or 2 for DFS");
                    break;
            }
        } while (!val.equals("1") && !val.equals("2"));
        return val;
    }

    @Override
    public List<N> getPath(N source, N target) {
        String selection = this.choose();
        if(selection.equals("1")){
            BFS<N> bfs = new BFS<N>(source, target, new HashMap<>(this.graph));
            return bfs.search();
        }else if(selection.equals("2")){
            DFS<N> dfs = new DFS<N>(source, target, new HashMap<>(this.graph));
            dfs.search();
            return dfs.path();
        }

        return null;
    }

    @Override
    public Set<N> linkedNodes(N node) {
       return new HashSet<>(graph.get(node));
    }

    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(graph.keySet());
    }
}
