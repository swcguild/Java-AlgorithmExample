/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.queue;

import java.util.Iterator;

/**
 *
 * @author ilyagotfryd
 */
public class LinkedListQueue<Item> implements Queue<Item>, Iterable<Item> {

    Node<Item> head = null;
    Node<Item> tail = null;
    Integer size = 0;
    
    //enqueue to the tail of linked list
    @Override
    public void enqueue(Item element) {
       
        Node<Item> node = new Node<>();
        node.nodeItem = element;
            
        if(size == 0)
        {
            tail = node;
            head = tail;
        } else
        {
            
            tail.next = node;
            tail = node;
        }
        
         size ++;
    }

    //dequeue from head of linked list
    @Override
    public Item dequeue() {
        if(size == 0)
        {
            throw new IndexOutOfBoundsException("Can not dequeue an empty quque. Index is out of bounds.");
        }
        
        Item result = head.nodeItem;
        head = head.next;
        size --;
        
        if(size == 0)
        {
         tail = null;
        }
        
        return result;
    }

    //peek at head of linked list
    @Override
    public Item peek() {
        if(head!= null)
        {
            return head.nodeItem;
        }
        throw new IndexOutOfBoundsException("Can not peek at an element of an empty quque. Index is out of bounds.");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator<Item>(head);
    }
    
    private class Node<T>
    {
        T nodeItem;
        Node<T> next = null;
    }
    
    private class QueueIterator<E> implements Iterator<E>
    {

        Node<E> currentNode = null;
        
        QueueIterator(Node<E> head)
        {
            currentNode = head;
        }
        
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E result = currentNode.nodeItem;
            currentNode = currentNode.next;
            return result;
        }
    
    }
    
}
