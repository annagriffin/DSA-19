import java.util.*;

public class MCCR {
    public static int MCCR(EdgeWeightedGraph G) {
        // TODO

//        IndexPQ<Integer> vertices = new IndexPQ<>(G.numberOfE());
//        int dist = 0;
//        HashSet<Integer> seen = new HashSet<>();
//
//        HashMap<Integer, Integer> weights = new HashMap<>();
//
//
//        for (int i = 0; i < G.numberOfV(); i++) {
//
//
//            seen.add(i);
//
//            for (Edge e : G.edges(i)) {
//
//
//
//
//                if (seen.contains(e.either())) {
//
//
//                    if (seen.contains(e.other(i))) {
//                        continue;
//                    } else {
//
//                        if (weights.containsKey(e.other(i))) {
//                            if (weights.get(e.other(i)) < e.weight()) {
//                                continue;
//                            } else {
//                                vertices.changeKey(e.other(i), e.weight());
//                                weights.put(e.other(i), e.weight());
//                                seen.add(e.other(i));
//                            }
//
//                        } else {
//                            vertices.insert(e.other(i), e.weight());
//                            weights.put(e.other(i), e.weight());
//                            seen.add(e.other(i));
//                        }
//
//                    }
//                } else {
//                    if (weights.containsKey(e.either())) {
//                        if (weights.get(e.either()) < e.weight()) {
//                            continue;
//                        } else {
//                            vertices.changeKey(e.either(), e.weight());
//                            weights.put(e.either(), e.weight());
//                            seen.add(e.either());
//                        }
//
//                    } else {
//                        vertices.insert(e.either(), e.weight());
//                        weights.put(e.either(), e.weight());
//                        seen.add(e.either());
//                    }
//                }
//
//
//            }
//
//
//
//        }
//
//
//        while (!vertices.isEmpty()) {
//            int min = vertices.delMin();
//            dist = dist + min;
//    }
//
//
//
//
//        return dist;
//    }

        // number of vertices
        int v = G.numberOfV();

        // min path
        int dist = 0;

        // minimum spanning tree
        boolean[] mstSet = new boolean[v];

        // holds minimum weights
        int[] weights = new int[v];


        for (int i=0; i < v; i++) {
            weights[i] = Integer.MAX_VALUE;
            mstSet[i] = false;

        }

        // first is 0 becuase it is 0 from itself
        weights[0] = 0;

        for (int i=0; i<v;i++) {

            // gets the index of key with the index of the minimum
            int minIdx = getMin(v, weights, mstSet);
            mstSet[minIdx] = true;

            // adds minimum to the total path distance
            dist = dist + weights[minIdx];


            // goes through all of the edges
            Iterable<Edge> potentialPaths = G.edges(minIdx);
            for (Edge e : potentialPaths) {

                // gets the other endpoint and the weight of the edge
                int endpoint = e.other(minIdx);
                int w = e.weight();

                // if found smaller
                if (endpoint != 0 && !mstSet[endpoint] && w < weights[endpoint]) {
                    weights[endpoint] = w;
                }
            }
        }

        return dist;
    }

    private static int getMin(int v, int[] weights, boolean[] mstSet) {

        int min = Integer.MAX_VALUE;
        int idx = -1;

        for (int i=0; i<v;i++) {
            if (!mstSet[i] && weights[i] < min) {
                min = weights[i];
                idx = i;
            }
        }




        return idx;
    }

}