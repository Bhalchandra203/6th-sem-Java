/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaslip;


import java.util.*;

public class slip19_1
{
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many values:");
        int n = sc.nextInt();
        
        System.out.println("Enter " + n + " values:");
        for(int i=0; i<n; i++)
            l.add(sc.nextInt());
        
        System.out.println("Negative integers are:");
        Iterator itr = l.iterator();
        while(itr.hasNext()) {
            int num = (int)itr.next();
            if(num < 0)
                System.out.println(num);
        }
    }
}