/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.ex2_searching;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import xyz.rulle.algorithmssolutions.shared.datastructures.ArraySymbolTable;
import xyz.rulle.algorithmssolutions.shared.utilities.FileUtility;
import xyz.rulle.algorithmssolutions.shared.utilities.Stopwatch;

/**
 *
 * @author Michael
 */
public class TestArraySymbolTable {
    public static void main(String[] args) throws IOException {
        String filepath = new File("/src/main/resources/shakespeare-complete-works.txt").getAbsolutePath();
        String basepath = new File("").getAbsolutePath();
        String path = basepath + filepath.replaceFirst("C:", "");
        String delimiterPattern = "[^A-Za-z]";
        String[] allShake = FileUtility.toStringArray(path, delimiterPattern);
        
        String[] subShake = Arrays.copyOfRange(allShake, 0, 100000);
        
        ArraySymbolTable lst = new ArraySymbolTable();
        
        Stopwatch sw = new Stopwatch();
        
        sw.start();
        for (String string : allShake){
            lst.put(string, 1);
        }
        sw.stop();
        System.out.println("putting took " + sw.timeElapsed() + " milliseconds");
        
        //List<String> keys = lst.keys();
        
        sw.start();
        for (String string : lst.keys()){
            lst.get(string);
        }
        sw.stop();
        System.out.println("getting took " + sw.timeElapsed() + " milliseconds");
    }
}
