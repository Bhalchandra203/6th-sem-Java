/*
 Write a Java program using Multithreading to display all the alphabets between ‘A’ to 
‘Z’ after every 2 seconds.
 */
package com.mycompany.javaslip;



import java.util.logging.*;

public class slip1_1
{
    public static void main(String[] args) 
    {
        Thread t = new Thread(() -> 
        {
            while(true) 
            {
                for(char ch = 'A'; ch <= 'Z'; ch++)
                    System.out.print(ch + " ");
                System.out.println();
                
                try 
                {
                    Thread.sleep(2000);
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(slip1_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("2 seconds are passed....");
            }
        });
        
        t.start();
    }
}
