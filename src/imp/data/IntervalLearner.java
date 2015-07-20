/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp.data;

import imp.Constants;
import java.text.DecimalFormat;

/**
 *
 * @author muddCS15
 */
public class IntervalLearner {
    
    private final MelodyPart melody;
    
    //can go up to an octave in either direction, or stay on the same note
    private static final int range = Constants.OCTAVE;
    public static final int intervals = 2*range+1;
    private static final boolean debug = false;
    
    public IntervalLearner(MelodyPart melody){
        this.melody = melody;
    }
    
    public double[][] probabilities(){
        int [] [] counts = counts();
        if(debug){
            System.out.println("Counts:");
            printArray(counts);
        }
        
        double [] [] probabilities = probabilities(counts);
        if(debug){
            System.out.println("Probabilities:");
            printArray(probabilities);
        }
        
        return probabilities;
    }
    
    public static double[][] probabilities(int [] [] counts){
        
        //initialize probabilities to zero
        double[][] probabilities = new double[intervals][intervals];
        for (double[] row : probabilities) {
            for (int cell = 0; cell < row.length; cell++) {
                row[cell] = 0;
            }
        }
        
        //initialize totals to zero
        int[] totals = new int[counts.length];
        for(int i = 0; i<totals.length; i++){
            totals[i] = 0;
        }
        
        //get row totals
        for(int row = 0; row < counts.length; row++){
            for(int cell = 0; cell<counts[row].length; cell++){
                totals[row] += counts[row][cell];
            }
        }
        
        //fill probability table
        for(int row = 0; row < counts.length; row++){
            if(totals[row]!=0){
                //assign probabilities based on counts
                for(int cell = 0; cell<probabilities[row].length; cell++){
                    probabilities[row][cell] = (double)counts[row][cell]/(double)totals[row];
                }
            }else{
                //no data: make all destination intervals equally likely
                for(int cell = 0; cell<probabilities[row].length; cell++){
                    probabilities[row][cell] = 1.0/(double)probabilities[row].length;
                }
            }
        }
        
        //return probability table
        return probabilities;
    }
    
    public int[][] counts(){
        
        //initialize counts to zero
        int[][] counts = new int[intervals][intervals];
        for (int [] row : counts) {
            for (int j = 0; j < row.length; j++) {
                row[j] = 0;
            }
        }
        
        //first note
        int slot = melody.getFirstIndex();
        //System.out.println("first slot: "+slot);
        Note first = melody.getNote(slot);
        //System.out.println("first note: "+first);
        int size = melody.size();
        
        //go through notes, logging a count whenever there's a valid group of three
        for( ; slot < size; slot = slot + first.getRhythmValue(), first = melody.getNote(slot)){
            //first note note rest
            if(!first.isRest()){
                int slot2 = slot + first.getRhythmValue();
                //second note within list
                if(slot2 < size){
                    Note second = melody.getNote(slot2);
                    //second note not rest
                    if(!second.isRest()){
                        int slot3 = slot2 + second.getRhythmValue();
                        //third note within list
                        if(slot3 < size){
                            Note third = melody.getNote(slot3);
                            //third note not rest
                            if(!third.isRest()){
                                //pitches
                                int pitch1 = first.getPitch();
                                int pitch2 = second.getPitch();
                                int pitch3 = third.getPitch();
                                //intervals
                                int interval1 = pitch2-pitch1;
                                int interval2 = pitch3-pitch2;
                                
                                //both intervals are in range (less than an octave)
                                if(inRange(interval1) && inRange(interval2)){
                                    //System.out.println("interval 1: "+interval1 + "interval 2: "+interval2);
                                    counts[intervalToIndex(interval1)][intervalToIndex(interval2)] ++;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return counts;
    }
    
    private boolean inRange(int interval){
        return Math.abs(interval) <= range;
    }
    
    private static int intervalToIndex(int interval){
        return interval + range;
    }
    
    public static String arrayToString(double [][] array){
        String result = "";
        for(double [] row : array){
            result += rowToString(row);
        }
        return result;
    }
    
    private static String rowToString(double [] row){
        String result = "";
        DecimalFormat df = new DecimalFormat("#.##");
        for(double d : row){
            result += df.format(d)+"\t";
        }
        return result+"\n";
    }
    
    private static void printArray(double [][] array){
        for(double [] row : array){
            printRow(row);
        }
    }
    
    private static void printRow(double [] row){
        for(double cell : row){
            System.out.print(cell+"\t");
        }
        System.out.println();
    }
    
    private static void printArray(int [][] array){
        for(int [] row : array){
            printRow(row);
        }
    }
    
    private static void printRow(int [] row){
        for(int cell : row){
            System.out.print(cell+"\t");
        }
        System.out.println();
    }
    
}
