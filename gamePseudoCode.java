package com.company;

import java.util.Stack;

public class game {
    public void play(node n, int x, int y) {

        while (!winning(n.state, x, y)) {

            n.state = move(n.state, n);

        }
        n.print(n.state, x, y);
        System.out.print("\n\n CONGRATULATIONS");
    }


    public char[][] move(char[][] s, node n) {

        Upwards(n.state, n);
        Right(n.state, n);
        Downwards(n.state, n);
        Left(n.state, n);


        return s;
    }


    public void Upwards(char[][] s, node n) {
        while (true) {
            try {
                if (s[n.bx][n.by] == 'x') {
                    s[n.bx + 1][n.by] = 'B';
                    n.bx++;
                    break;
                }
            } catch (Exception e) {
                return;
            }
            s[n.bx][n.by] = '1';
            n.bx--;
        }
        BFS(n.state);
    }

    public void Right(char[][] s, node n) {

        while (true) {
            try {
                if (s[n.bx][n.by] == 'x') {
                    s[n.bx][n.by - 1] = 'B';
                    n.by--;
                    break;
                }
            } catch (Exception e) {
                return;
            }

            s[n.bx][n.by] = '1';
            n.by++;
        }
        BFS(n.state);
    }

    public void Downwards(char[][] s, node n) {
        while (true) {
            try {
                if (s[n.bx][n.by] == 'x') {
                    s[n.bx - 1][n.by] = 'B';
                    n.bx--;
                    break;
                }
            } catch (Exception e) {
                return;
            }
            s[n.bx][n.by] = '1';
            n.bx++;
        }
        BFS(n.state);
    }


    public void Left(char[][] s, node n) {
        while (true) {
            try {
                if (s[n.bx][n.by] == 'x') {
                    s[n.bx][n.by + 1] = 'B';
                    n.by++;
                    break;
                }
            } catch (Exception e) {
                return;
            }
            s[n.bx][n.by] = '1';
            n.by--;
        }
        BFS(n.state);
    }


    public boolean winning(char[][] s, int x, int y) {
        for (int i = 1; i <= x; i++)
            for (int j = 1; j <= y; j++)
                if (s[i][j] == '.') return false;
        return true;
    }


    public void DFS(State state) {
        Stack<node> stack = new Stack<node>();
        ArrayList<State> visited = new ArrayList();
        stack.push(new node(bx, by));
        node current;
        node next;
        while (!stack.empty()) {
            visited.add(next);
            current = stack.pop();
            if (winning(current[bx][by], bx, by)) {
                System.out.print("Congratz");
                return;
            }
            next = current.Upwards();
            stack.push(next(n.bx, n.by));
            next = current.Right();
            stack.push(next(n.bx, n.by));
            next = current.Downwards();
            stack.push(next(n.bx, n.by));
            next = current.Left();
            stack.push(next(n.bx, n.by));

        }

    }

    public LinkedList<node> BFS(State state) {
        LinkedList<node> list = new LinkedList<node>();
        ArrayList<State> visited = new ArrayList();
        visited.add(new node(bx, by));
        node current, next;

        current = s[n.bx][n.by];
        while (!list.isEmpty()) {

            LinkedList<node> adjacents = current.getAdjacents();
            current = list.removeFirst();

            for (node n : adjacents) {
                if (!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }
                current = queue.remove(); // goes to the next node
            }


            next = current.Upwards();
            list.add(next(n.bx, n.by));
            next = current.Right();
            list.add(next(n.bx, n.by));
            next = current.Downwards();
            list.add(next(n.bx, n.by));
            next = current.Left();
            list.add(next(n.bx, n.by));
        }
        LinkedList<node> path = new LinkedList<>();
        path.addFirst(current);
        while (current != s[n.bx][n.by]) {
            current = visited.get(current);
            path.addFirst(current);
        }

        return path;

    }

    public LinkedList<node> UCS(State state) {

        ArrayList<State> visited = new ArrayList();
        PriorityQueue<node> pq = new PriorityQueue<node>();
        priority = assign_cost(node, s[bx][by]);
        visited.add(new node(bx, by));
        int path_count = 0;
        node current, next;

        current = s[n.bx][n.by];


        while (!pq.isEmpty()) {

            LinkedList<node> adjacents = current.getAdjacents();
           // current = list.removeFirst();

            for (node current : adjacents) {
                if (!visited.contains(current)) {
                    pq.add(current);
                    visited.add(n);
                    path[path_cost]= current;
                    path_count++;
                } else if (path[path_cost of current] > path[path_cost of visited]){
                    current = pq.remove(current);
                               else{
                        pq.remove(visited);
                        visited.add(current);
                        path_count++;
                    }
                }
            }



            next = current.Upwards();
            list.add(next(n.bx, n.by));
            next = current.Right();
            list.add(next(n.bx, n.by));
            next = current.Downwards();
            list.add(next(n.bx, n.by));
            next = current.Left();
            list.add(next(n.bx, n.by));



            //منشان طباعة الطريق بس يخلص
            if (is_goal(current)){
            LinkedList<node> path = new LinkedList<>();
            path.addFirst(current);
            while (current != s[n.bx][n.by]) {
                current = visited.get(current);
                path.addFirst(current);
            }

            return path;
        }
            else {System.out.print("There's no possible path!");}
        }

    }
}
