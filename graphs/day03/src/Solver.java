/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to find a path to the goal
 */

import java.util.*;

public class Solver {

    public int minMoves = -1;
    private State solutionState;
    private boolean solved = false;

    /**
     * State class to make the cost calculations simple
     * This class holds a board state and all of its attributes
     */
    private class State implements Comparable<State> {
        // Each state needs to keep track of its cost and the previous state
        private Board board;
        private int moves; // equal to g-cost in A*
        public int cost; // equal to f-cost in A*
        private State prev;

        public State(Board board, int moves, State prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            // TODO
            this.cost =  this.board.manhattan() *2 +  moves;
        }

        public int compareTo(State s) {

            return this.cost - s.cost;
            //return this.moves - s.moves;
        }

        @Override
        public boolean equals(Object s) {
            if (s == this) return true;
            if (s == null) return false;
            if (!(s instanceof State)) return false;
            return ((State) s).board.equals(this.board);
        }
    }

    /*
     * Return the root state of a given state
     */
    private State root(State state) {
        // TODO: Your code here

        State newState = state;

        while (newState.prev != null) {
            newState = newState.prev;
        }

        return newState;
    }

    /*
     * A* Solver
     * Find a solution to the initial board using A* to generate the state tree
     * and a identify the shortest path to the the goal state
     */
    public Solver(Board initial) {
        // TODO: Your code here

        PriorityQueue<State> q = new PriorityQueue<>();
        Map<Board, Integer> V = new HashMap<>();


        State initState = new State(initial, 0,null);

        if (!initial.solvable()) {
            return;
        }

        solutionState = initState;

        V.put(initState.board, initState.cost);

        q.add(initState);

        while (!q.isEmpty()) {



            State vertex = q.poll();
            //System.out.println(vertex.moves);

            if (vertex.board.isGoal()) {

                solutionState = vertex;
                 //Iterable<Board> ans = this.solution() ;
                minMoves = vertex.moves;
                solved = true;
                break;
            } else {

                for (Board n : vertex.board.neighbors()) {

                    if (V.get(n) == null || V.get(n) > vertex.cost) {
                        V.put(n, vertex.cost + 1);
                        State temp = new State(n, vertex.moves + 1, vertex);
                        q.add(temp);
                    }
                }
            }
        }



    }

    /*
     * Is the input board a solvable state
     * Research how to check this without exploring all states
     */
    public boolean isSolvable() {
        // TODO: Your code here

        return solved;
    }

    /*
     * Return the sequence of boards in a shortest solution, null if unsolvable
     */
    public Iterable<Board> solution() {
        // TODO: Your code here

        List<Board> solutions = new LinkedList<>();

        if (!isSolvable()) {
            return null;
        }

        while (solutionState.prev != null) {
            solutions.add(solutionState.prev.board);
            solutionState = solutionState.prev;
        }


        return solutions;
    }

    public State find(Iterable<State> iter, Board b) {
        for (State s : iter) {
            if (s.board.equals(b)) {
                return s;
            }
        }
        return null;
    }

    /*
     * Debugging space
     */
    public static void main(String[] args) {
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board initial = new Board(initState);

        Solver solver = new Solver(initial);
    }


}
