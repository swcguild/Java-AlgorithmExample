/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.algorithmexample;

import com.thesoftwareguild.queue.LinkedListQueue;
import com.thesoftwareguild.queue.Queue;
import java.util.PriorityQueue;


/**
 *
 * @author ilyagotfryd
 */
public class MazeRunner {
    
    Queue<MazeNode> bfsQueue;

    public MazeRunner() {
        this.bfsQueue = new LinkedListQueue<>();
    }
    
    public void runMaze(MazeNode headNode)
    {
        bfsQueue.enqueue(headNode);
        MazeNode node = headNode;
        
        if(node.mazeExit)
        {
            System.out.println("Exit was found!");
        }else
        {
            for(MazeNode nextNode: node.exits){

            }
        }
    }
}
