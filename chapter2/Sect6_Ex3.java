/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter2;
abstract class TwoIntsProcessorAbstract 
    implements TwoArgsProcessor<Integer> 
{
}

/**
 *
 * @author rlece
 */
public class Sect6_Ex3 
{
    public static void main(String[] args)
    {
        TwoIntsProcessorAbstract divideInts = (x,y) -> x / y  // ERROR: ProcessTwoIntsAbstract is 
                                                              //        not a functional interface 
        
    }
}
