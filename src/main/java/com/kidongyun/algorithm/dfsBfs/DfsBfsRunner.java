package com.kidongyun.algorithm.dfsBfs;

import com.kidongyun.algorithm.queue.Queue;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Stack;

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;
    Graph(int size) {
        nodes = new Node[size];
        for(int i=0; i<size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }

        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;

        while(!stack.isEmpty()) {
            Node r = stack.pop();

            for(Node n : r.adjacent) {
                if(!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }

            visit(r);
        }
    }

    void bfs() {
        bfs(0);
    }

    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        root.marked = true;

        while(!queue.isEmpty()) {
            Node r = queue.dequeue();

            for(Node n : r.adjacent) {
                if(!n.marked) {
                    n.marked = true;
                    queue.enqueue(n);
                }
            }

            visit(r);
        }
    }

    void dfsR(Node r) {

    }

    void visit(Node n) {
        System.out.print(n.data + " ");
    }
}

@Component
public class DfsBfsRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
