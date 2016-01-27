/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.thesoftwareguild.algorithmexample.ExitDirections;
import com.thesoftwareguild.algorithmexample.Maze;
import java.util.HashSet;
import java.util.Set;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ilyagotfryd
 */
public class MazeManagementJUnitTest {
    
    Maze testMaze = null;
    Set<ExitDirections> east;
    Set<ExitDirections> northEast;
    Set<ExitDirections> southWest;
    public MazeManagementJUnitTest() {
    }
    
    @Before
    public void setUp() {
        testMaze = new Maze(5,5);
        east = new HashSet<>();
        east.add(ExitDirections.EAST);
        northEast = new HashSet<>();
        northEast.add(ExitDirections.NORTH);
        northEast.add(ExitDirections.EAST);
        southWest = new HashSet<>();
        southWest.add(ExitDirections.WEST);
        southWest.add(ExitDirections.SOUTH);
        
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void saveAndLoadMaze()
    {
        testMaze.configureCell(0, 0, east);
        testMaze.configureCell(0, 1, southWest);
        testMaze.configureCell(1, 1, northEast);
        testMaze.configureCell(1, 2, southWest);
        testMaze.configureCell(2, 2, northEast);
        testMaze.configureCell(2, 3, southWest);
        testMaze.configureCell(3, 3, northEast);
        testMaze.configureCell(3, 4, southWest);
        testMaze.configureCell(4, 4, northEast);
        
        try{
            testMaze.saveMaze("testMaze.txt"); 
        }catch(Exception e)
        {
            Assert.fail();
        }
        try{
            Maze resultMaze = Maze.loadMaze("testMaze.txt");
            Assert.assertEquals(testMaze, resultMaze);
        }catch(Exception e)
        {
            Assert.fail();
        }
        
   }
}
