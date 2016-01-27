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
    
    public void runMaze(Maze maze)
    {
        bfsQueue.enqueue(maze.getEntrance());
        MazeNode node = null;
        while(!bfsQueue.isEmpty())
        {
            node = bfsQueue.dequeue();
            if(node.getMazeExit())
            {
                System.out.println("Exit was found!");
            }else
            {
                for(MazeNode nextNode: node.getExits()){
                    bfsQueue.enqueue(nextNode);
                }
            }
        }
    }
}
