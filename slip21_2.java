/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaslip;


import java.util.LinkedList;

class SharedResource {
    private LinkedList<String> buffer = new LinkedList<>();
    private int capacity = 1;
    
    public synchronized void produce(String value) {
        while(buffer.size() == capacity) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        buffer.add(value);
        System.out.println("Produced: " + value);
        notifyAll();
    }
    
    public synchronized String consume() {
        while(buffer.size() == 0) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        String value = buffer.removeFirst();
        System.out.println("Consume: " + value);
        notifyAll();
        
        return value;
    }
}

class Producer extends Thread {
    private SharedResource sharedResource;
    
    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    
    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            String value = "Value " + i;
            sharedResource.produce(value);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedResource sharedResource;
    
    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }
    
    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            String value = "Value " + i;
            sharedResource.consume();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class slip21_2
{
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        
        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);
        
        producer.start();
        consumer.start();
    }
}