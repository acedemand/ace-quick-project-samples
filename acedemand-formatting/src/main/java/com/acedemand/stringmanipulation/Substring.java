package com.acedemand.stringmanipulation;

/**
 * @author : Pamir Erdem <pamir.erdem@acedemand.com>
 * @date : 7/27/2015.
 */
public class Substring {
    public static void main(String[] args) {
        String s = "Hello Baby";
        int position = s.indexOf('B');
        System.out.println("s.substring(6) = " + s.substring(6));
        System.out.println("s.substring(position) = " + s.substring(position));
        splittingDemo();
        System.out.println("\n\nsplitting demo 2\n\n");
        splittingDemo2();
                
    }

    private static void splittingDemo(){
        String sentence = "We love you so much Pamir!";
        String[] words = sentence.split("\\s");
        for (String word : words){
            System.out.println("word = " + word);
        }
    }
    private static void splittingDemo2(){
        String sentence = "We  23  4love 7you so much Pamir!";
        String[] words = sentence.split("\\d+");
        for (String word : words){
            System.out.println("word = " + word);
        }
    }
}
