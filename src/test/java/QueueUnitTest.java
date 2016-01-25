/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.thesoftwareguild.queue.LinkedListQueue;
import com.thesoftwareguild.queue.Queue;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ilyagotfryd
 */
public class QueueUnitTest {
    
    public QueueUnitTest() {
    }
    
    Queue<Integer> queue = null;
    
    @Before
    public void setUp() {
        queue = new LinkedListQueue<>();
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
    public void properEmptyResponse()
    {
        
        try{
            queue.peek();
            Assert.assertFalse(true);
        }catch(IndexOutOfBoundsException exp)
        {
            Assert.assertTrue(true);
        }catch(Exception exp)   
        {
            Assert.assertFalse("Peek : wrong exception type thrown",true);
        }
        
        try{
            queue.dequeue();
            Assert.assertFalse(true);
        }catch(IndexOutOfBoundsException exp)
        {
            Assert.assertTrue(true);
        }catch(Exception exp)   
        {
            Assert.assertFalse("Dequeue : wrong exception type thrown",true);
        }
        
    }
    
    @Test
    public void enqueueDequeueOneElement()
    {
        queue.enqueue(20);
        Integer expected = 20;
        Assert.assertEquals(expected, queue.peek());
        Assert.assertEquals(1, queue.size());
        Integer result = queue.dequeue();
        Assert.assertEquals(expected, result);
        Assert.assertEquals(0, queue.size());
    }
    
    @Test
    public void fifoIsFunctional()
    {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(42);
        Assert.assertEquals((Integer)10, queue.dequeue());
        Assert.assertEquals((Integer)20, queue.dequeue());
        Assert.assertEquals(2, queue.size());
        Assert.assertEquals((Integer)30, queue.dequeue());
        Assert.assertEquals((Integer)42, queue.dequeue());
    }
    
    @Test
    public void fifoCanEmptyAndRefill()
    {
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.enqueue(14);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(42);
        Assert.assertEquals((Integer)10, queue.dequeue());
        Assert.assertEquals((Integer)20, queue.dequeue());
        Assert.assertEquals(2, queue.size());
        Assert.assertEquals((Integer)30, queue.dequeue());
        Assert.assertEquals((Integer)42, queue.dequeue());
    }
    
    @Test
    public void fifoCanPartiallyEmptyAndRefill()
    {
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        queue.dequeue();
 
        queue.enqueue(30);
        queue.enqueue(42);
        
        Assert.assertEquals((Integer)10, queue.dequeue());
        Assert.assertEquals((Integer)20, queue.dequeue());
        Assert.assertEquals(2, queue.size());
        Assert.assertEquals((Integer)30, queue.dequeue());
        Assert.assertEquals((Integer)42, queue.dequeue());
    }
}
