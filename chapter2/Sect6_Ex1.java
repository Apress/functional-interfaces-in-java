/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;

/**
 *
 * @author rlece
 */
public class Sect6_Ex1 
{
    public static void main(String[] args)
    {
        ReceiptPrinter simpleReceiptPrinter = x -> {
            System.out.println("\nItem :\t"  + x.item);
            System.out.println("Price:\t"    + x.price);
            System.out.println("Disc:\t"     + x.discount);
            System.out.println("Tax:\t"      + x.tax);
        };
        
        Receipt receipt = new Receipt("shirt", 20.00, 0.05, 0.07);
        simpleReceiptPrinter.print(receipt);
        System.out.println("Total:\t"    
                         + simpleReceiptPrinter.computeTotal(receipt));
    }
}
