package com.luxoft.meta;

import com.luxoft.domain.ForeignKey;
import com.luxoft.domain.Table;
import com.luxoft.domain.TableName;
import es.usc.citius.hipster.algorithm.Algorithm;
import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.graph.GraphBuilder;
import es.usc.citius.hipster.graph.GraphSearchProblem;
import es.usc.citius.hipster.graph.HipsterDirectedGraph;
import es.usc.citius.hipster.model.impl.WeightedNode;
import es.usc.citius.hipster.model.problem.SearchProblem;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ma29379 on 2/13/2017.
 */
public class PathFinder {

    private final Metadata metadata;
    private HipsterDirectedGraph<String, Integer> tableGraph;

    public PathFinder(Metadata metadata) {
        this.metadata = metadata;
        buildGraph();
    }


    public List<Table> findShortestJoinPath(Collection<Table> startPoints, Table toTab) {
        int minJoinPathLength = Integer.MAX_VALUE;
        List<Table> minJoinPath = Collections.emptyList();

        for(Table fromTab : startPoints) {

            List<Table> joinPath = findJoinPath(fromTab, toTab);

            if(joinPath.size() < minJoinPathLength){
                minJoinPath = joinPath;
                minJoinPathLength = minJoinPath.size();
            }
        }
        return minJoinPath;
    }

    private void buildGraph() {
        GraphBuilder<String, Integer> graphBuilder = GraphBuilder.create();

        for(Table table : metadata) {
            for(ForeignKey fk : table.getForeignKeys()){
                TableName parentTableName = fk.getReferencedKey().getTableName();

                //connect tables in both directions
                graphBuilder.connect(table.getName()).to(parentTableName.getName()).withEdge(1);
                graphBuilder.connect(parentTableName.getName()).to(table.getName()).withEdge(1);
            }
        }

        tableGraph = graphBuilder.createDirectedGraph();
    }

    private List<Table> findJoinPath(Table fromTable, Table toTable){

        SearchProblem<Integer, String, WeightedNode<Integer, String, Double>> problem = GraphSearchProblem
                .startingFrom(fromTable.getName())
                .in(tableGraph)
                .takeCostsFromEdges()
                .build();

        Algorithm<Integer, String, WeightedNode<Integer, String, Double>>.SearchResult searchResult =
                Hipster.createDijkstra(problem).search(toTable.getName());

        List<String> path = Algorithm.recoverStatePath(searchResult.getGoalNode());

        List<Table> tablePath = path.stream()
                .map(metadata::requireTable)
                .collect(Collectors.toList());

        return tablePath;
    }
}
