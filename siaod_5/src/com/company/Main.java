package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Graph graph=new Graph();
        //5 8
        //1 5 10
        //1 2 1
        //1 3 2
        //2 5 6
        //3 5 7
        //2 4 3
        //3 4 4
        //5 11 4

        // 7 12
        //1 2 20
        //2 3 15
        //3 4 3
        //4 5 17
        //5 6 28
        //6 7 36
        //1 7 1
        //2 7 4
        //7 3 9
        //7 4 16
        //7 5 25
        //6 1 23
        System.out.println(graph.kruskala());
        graph.showKrustal();
    }
}
