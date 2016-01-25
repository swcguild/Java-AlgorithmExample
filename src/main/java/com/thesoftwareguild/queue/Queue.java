/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesoftwareguild.queue;

/**
 *
 * @author ilyagotfryd
 */
public interface Queue<T> {
    void enqueue(T element);
    T dequeue();
    T peek();
    int size();
    Boolean isEmpty();
}
