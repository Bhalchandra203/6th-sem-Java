/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaslip;


import java.util.Scanner;
import java.util.logging.*;

public class slip18_1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter any string:");
        String str = sc.nextLine();
        
        Thread t = new Thread(() -> {
            for(int i=0; i<str.length(); i++) {
                String str2 = str.toLowerCase();
                char ch = str2.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    System.out.println(ch);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(slip18_1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("3 seconds are passed....");
                }
            }
        });
        
        t.start();
    }
}