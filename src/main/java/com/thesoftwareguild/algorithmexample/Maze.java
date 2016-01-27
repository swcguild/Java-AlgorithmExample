/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.algorithmexample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author ilyagotfryd
 */
public class Maze {
    
    private MazeNode entrance;
    
    private static final String DELIMITER = "::";
    
    List<List<MazeNode>> mazeGrid = new ArrayList<List<MazeNode>>();
    private int height;
    private int width;
    
    public Maze(int width, int height)
    {
        for(int i =0; i<height;i++)
        {
            mazeGrid.add(new ArrayList<MazeNode>());
            for(int j=0; j< width; j++)
            {
                MazeNode node = new MazeNode();
                node.setGridRow(i);
                node.setGridColumn(j);
                mazeGrid.get(i).add(node);
            }
        }
    
        this.height = height;
        this.width = width;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.entrance);
        hash = 17 * hash + Objects.hashCode(this.mazeGrid);
        hash = 17 * hash + this.height;
        hash = 17 * hash + this.width;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Maze other = (Maze) obj;
        if (!Objects.equals(this.entrance, other.entrance)) {
            return false;
        }
        if (!Objects.equals(this.mazeGrid, other.mazeGrid)) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        if (this.width != other.width) {
            return false;
        }
        return true;
    }
    
    public static Maze loadMaze(String fileName) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
        String dimsLine = sc.nextLine();
        String[] dims = dimsLine.split(DELIMITER);
        int mazeWidth = Integer.parseInt(dims[0]);
        int mazeHeight = Integer.parseInt(dims[1]);
        Maze maze = new Maze(mazeWidth,mazeHeight);
        while(sc.hasNextLine())
        {
            String currentLine = sc.nextLine();
            String[] tokens = currentLine.split(DELIMITER);
            int column = Integer.parseInt(tokens[0]);
            int row = Integer.parseInt(tokens[1]);
            Set<ExitDirections> exitDirections = new HashSet<>();
            for(int i=2;i<tokens.length;i++)
            {
                ExitDirections dir = ExitDirections.valueOf(tokens[i]);
                exitDirections.add(dir);
            }
            
            maze.configureCell(row,column,exitDirections);
        }
        
        return maze;
    }
    
    public void saveMaze(String fileName) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(fileName);
        writer.println(width+DELIMITER+height);
        for(int i =0; i<height;i++)
        {
            for(int j=0; j< width; j++)
            {
                MazeNode node = mazeGrid.get(i).get(j);
                writer.print(node.getGridRow()+DELIMITER+node.getGridColumn());
                for(MazeNode link: node.getExits())
                {
                    if(link.getGridColumn()-j==1)
                    {
                        writer.print(DELIMITER+ExitDirections.EAST.name());
                    }else if(link.getGridColumn()-j==-1){
                        writer.print(DELIMITER+ExitDirections.WEST.name());
                    }else if(link.getGridRow()-i==1){
                        writer.print(DELIMITER+ExitDirections.SOUTH.name());
                    }else if(link.getGridRow()-j==-1){
                        writer.print(DELIMITER+ExitDirections.NORTH.name());
                    }
                }
                writer.println("");
            }
        }
        writer.flush();
        writer.close();
    }

    public void configureCell(int row, int column,Set<ExitDirections> exitDirections)
    {
        MazeNode node = mazeGrid.get(row).get(column);
        MazeNode linkMe=null;
        for(ExitDirections dir: exitDirections)
        {
            switch(dir){
                case NORTH:
                    linkMe = (row>0)?mazeGrid.get(row-1).get(column):null;    
                    break;
                case SOUTH:
                    linkMe = (row<height-1)?mazeGrid.get(row+1).get(column):null;
                    break;
                case EAST:
                    linkMe = (column<width-1)?mazeGrid.get(row).get(column+1):null;
                    break;
                case WEST:
                    linkMe = (column>0)?mazeGrid.get(row).get(column-1):null;
                    break;
            }
                
            if(linkMe!= null)
            {
                node.getExits().add(linkMe);
                linkMe.getExits().add(node);
            }
        }
    }

    public MazeNode getEntrance() {
        return entrance;
    }

    public void setEntrance(MazeNode entrance) {
        this.entrance = entrance;
    }
    
}
