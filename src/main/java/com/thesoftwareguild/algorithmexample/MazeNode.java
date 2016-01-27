/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.algorithmexample;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author ilyagotfryd
 */
public class MazeNode{
        private Set<MazeNode> exits = new HashSet<>();
        private Boolean visited = false;
        private Boolean mazeExit = false;
        private int gridRow = 0;
        private int gridColumn = 0;

    public Set<MazeNode> getExits() {
        return exits;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.visited);
        hash = 89 * hash + Objects.hashCode(this.mazeExit);
        hash = 89 * hash + this.gridRow;
        hash = 89 * hash + this.gridColumn;
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
        final MazeNode other = (MazeNode) obj;
        if (!Objects.equals(this.visited, other.visited)) {
            return false;
        }
        if (!Objects.equals(this.mazeExit, other.mazeExit)) {
            return false;
        }
        if (this.gridRow != other.gridRow) {
            return false;
        }
        if (this.gridColumn != other.gridColumn) {
            return false;
        }
        return true;
    }

    

    

    public void setExits(Set<MazeNode> exits) {
        this.exits = exits;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Boolean getMazeExit() {
        return mazeExit;
    }

    public void setMazeExit(Boolean mazeExit) {
        this.mazeExit = mazeExit;
    }

    public int getGridRow() {
        return gridRow;
    }

    public void setGridRow(int gridRow) {
        this.gridRow = gridRow;
    }

    public int getGridColumn() {
        return gridColumn;
    }

    public void setGridColumn(int gridColumn) {
        this.gridColumn = gridColumn;
    }
        
    }
