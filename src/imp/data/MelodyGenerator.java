/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp.data;

import imp.Constants;
import static imp.Constants.OCTAVE;
import static imp.data.GuideLineGenerator.ASCENDING;
import static imp.data.GuideLineGenerator.DESCENDING;
import imp.gui.Notate;
import imp.lickgen.Grammar;
import imp.lickgen.LickGen;
import java.util.ArrayList;
import java.util.Random;
import polya.Polylist;
import polya.PolylistEnum;

/**
 *
 * @author muddCS15
 */
public class MelodyGenerator {

    private double [][] probabilities;
    private MelodyPart rhythm;
    private ChordPart chords;
    private int [] range;

    private static final int NO_DATA = Integer.MAX_VALUE;
    private static final boolean IN_RANGE = true;
    
    public MelodyGenerator(double[][] probabilities, MelodyPart rhythm, ChordPart chords, int [] range) {
        this.probabilities = probabilities;
        this.rhythm = rhythm;
        this.chords = chords;
        this.range = range;
    }
    
    public MelodyGenerator(double [][] probabilities, Polylist rhythm, ChordPart chords, int [] range){
        this(probabilities, polylistToMelodyPart(rhythm), chords, range);
    }
    
    public MelodyGenerator(double [][] probabilities, Notate notate, ChordPart chords, int [] range){
        this(probabilities, rhythm(notate), chords, range);
    }
    
    public static Polylist rhythm(Notate notate){
        Grammar gram = new Grammar(notate.getGrammarFileName());
        //System.out.println(gram.getRules());
        return justRhythm(gram.run(0, notate.getScoreLength(), notate, false, notate.getImprovisorTradeFirst(), notate.getTradingQuantum()));
//        LickGen gen = notate.getLickGen();
//        Polylist abstractMelody = gen.generateRhythmFromGrammar(0, notate.getScoreLength());
//        return justRhythm(abstractMelody);
    }
    
//    public static Polylist rhythm(Notate notate){
//        LickGen gen = new LickGen(notate.getGrammarFileName(), notate);
//        int slots = notate.getScoreLength();
//        Grammar gram = gen.getGrammar();
//        ArrayList<Polylist> params = gram.getParams();
//        int minDur = 0, maxDur = 0;
//        double restProb = 0;
//        for(Polylist param : params){
//            String paramName = (String)param.first();
//            if(paramName.equals("min-duration")){
//                minDur = (int)(long)(Long)param.second();
//            }else if(paramName.equals("max-duration")){
//                maxDur = (int)(long)(Long)param.second();
//            }else if(paramName.equals("rest-prob")){
//                restProb = (Double)param.second();
//            }
//        }
//        minDur = 16; maxDur = 4; restProb = .1;
//        //System.out.println("slots: "+slots+"; minDur: "+minDur+"; maxDur: "+maxDur+"; restProb: "+restProb);
//        Polylist rhythm = gen.generateRandomRhythm(slots, minDur, maxDur, restProb);
//        //System.out.println("generated rhythm: "+rhythm);
//        return rhythm;
//    }
    
    private static Polylist justRhythm(Polylist abstractMelody){
        //System.out.println(abstractMelody);
        PolylistEnum iterator = abstractMelody.elements();
        Polylist justRhythm = new Polylist();
        while(iterator.hasMoreElements()){
            Object nextElem = iterator.nextElement();
            try{
                Polylist note = (Polylist)nextElem;
                if(note.first().toString().equals("triadic")){
                    int totalDur = Duration.getDuration(note.second().toString());
                    int smallDur = Duration.getDuration(note.third().toString());
                    int numberOfNotes = totalDur/smallDur;
                    for(int i = 0; i<numberOfNotes; i++){
                        justRhythm = justRhythm.addToEnd("X"+note.third().toString());
                    }
                }else{
                    PolylistEnum i = note.elements();
                    while(i.hasMoreElements()){
                        try{
                            String elem = i.nextElement().toString();
                            //System.out.println("elem: "+elem);
                            if(elem.matches("[A-Z].*")){
                                //System.out.println("elem matches");
                                if(elem.charAt(0)=='R'){
                                    justRhythm = justRhythm.addToEnd(elem);
                                    //System.out.println(justRhythm);
                                }else{
                                    justRhythm = justRhythm.addToEnd("X"+elem.substring(1));
                                    //System.out.println(justRhythm);
                                }
                            }
                        }catch(Exception e){

                        }
                    }
                }
                
            }catch(Exception ex){
                try{
                    String elem = nextElem.toString();
                    if(elem.matches("[A-Z].*")){
                        //System.out.println("elem matches");
                        if(elem.charAt(0)=='R'){
                            justRhythm = justRhythm.addToEnd(elem);
                            //System.out.println(justRhythm);
                        }else{
                            justRhythm = justRhythm.addToEnd("X"+elem.substring(1));
                            //System.out.println(justRhythm);
                        }
                    }
                }catch(Exception exp){
                    
                }
            }
        }
        //System.out.println(justRhythm);
        return justRhythm;
    }
    
    public static MelodyPart polylistToMelodyPart(Polylist rhythm){
        MelodyPart result = new MelodyPart();
        PolylistEnum iterator = rhythm.elements();
        while(iterator.hasMoreElements()){
            String s = (String)iterator.nextElement();
            //System.out.println(s);
            char restOrNote = s.charAt(0);
            String RorX = Character.toString(restOrNote);
            
            int duration = Duration.getDuration(s.substring(1));
            
            Note n;
            if(RorX.equals("R")){
                n = new Rest(duration);
            }else{//N, C, L, A, X, S
                n = new Note(Constants.C4, duration);
            }
            result.addNote(n);
        }
        return result;
    }

    public MelodyPart melody() {
        MelodyPart result = new MelodyPart();
        int prevInterval = NO_DATA;
        Note prevNote = null; //always a note, never a rest
        int slot = 0;
        Note n = rhythm.getNote(slot);
        int duration = n.getRhythmValue();
        Chord chord = chords.getCurrentChord(slot);

        while(slot < rhythm.size()){
            Note toAdd;
            
            if(n.isRest()){
                //System.out.println("n is rest");
                toAdd = n.copy();
            }
            //should only be true for first note
            else if(prevNote == null){
                //System.out.println("prevNote is null or rest");
                toAdd = new Note(rootPitch(chord), duration);
                prevInterval = NO_DATA;
            //should only be true for second note (we ignore rests)
            }else if(prevInterval == NO_DATA){
                //System.out.println("prevInterval is NO_DATA");
                toAdd = new Note(rootPitch(chord), duration);
                prevInterval = toAdd.getPitch() - prevNote.getPitch();
            }
            else{
                //System.out.println("in else");
                //System.out.println(chord + " at slot "+slot);
                toAdd = bestChoice(prevInterval, prevNote, duration, chord);
                prevInterval = toAdd.getPitch() - prevNote.getPitch();
            }
            
            //if n is a rest, skip right over it like it was never there
            if(!n.isRest()){
               prevNote = toAdd; 
            }
            
            result.addNote(toAdd);
            
            slot += duration;
            if(slot < rhythm.size()){
                n = rhythm.getNote(slot);
                duration = n.getRhythmValue();
                chord = chords.getCurrentChord(slot);
            }

            
        }
        
        return result;
    }
    
    //always start melody on the root of the first chord
    //specifically, the one that lies closest to the middle of the range
    private int rootPitch(Chord c){
        if(c.isNOCHORD()){
            return middleOfRange();
        }else{
            return closestToMiddle(new Note(Constants.C4 + c.getRootSemitones())).getPitch();
        }
    }
    
        /**
     * middleOfRange
     * returns the midi value located at the middle of the range
     * (rounds down)
     * @return midi value of middle of range
     */
    private int middleOfRange(){
        return range[0]+((range[1]-range[0])/2);//rounds down for odd numbers
    }
    
    /**
     * closestToMiddle
     * Returns the version of note n that is closest to the middle of the range
     * Below the middle if ascending, above is descending, closest if no pref
     * @param n Note
     * @param line line
     * @return version of note closest to middle of range
     */
    private Note closestToMiddle(Note n){
        
        int rv = n.getRhythmValue();
        
        int closestBelow = closestBelowMiddle(n);
        boolean belowInRange = inRange(closestBelow)==IN_RANGE;
        int closestAbove = closestAboveMiddle(n);
        boolean aboveInRange = inRange(closestAbove)==IN_RANGE;
        
        int pitch;

        if(belowInRange && aboveInRange){
            int middle = middleOfRange();
            //closest of the two - tiebreak goes to above note if distances equal
            pitch = ((middle-closestBelow)<(closestAbove-middle)?closestBelow:closestAbove);
        }else if(belowInRange){
            pitch = closestBelow;
        }else{//above guaranteed to be in range because we limit the user to an octave
            pitch = closestAbove;
        }

        return new Note(pitch, rv);
    }
    
    /**
     * closestBelowMiddle
     * Returns version of note n that is in the octave below the middle of range
     * @param n note
     * @return version of note in octave below middle of range
     */
    private int closestBelowMiddle(Note n){
        int notePitch = n.getPitch();
        int middle = middleOfRange();
        int pitch;
        for(pitch = middle; !samePitchClass(pitch, notePitch); pitch--){
                
        }
        return pitch;
    }
    
    /**
     * closestAboveMiddle
     * Returns version of note n that is in the octave above the middle of range
     * @param n note
     * @return version of note in octave above middle of range
     */
    private int closestAboveMiddle(Note n){
        int notePitch = n.getPitch();
        int middle = middleOfRange();
        int pitch;
        for(pitch = middle; !samePitchClass(pitch, notePitch); pitch++){
                
        }
        return pitch;
    }
    
    //problems if you pass in a negative pitch...
    /**
     * samePitchClass
     * Returns whether two pitches have the same pitch class
     * @param pitch1 first pitch
     * @param pitch2 second pitch
     * @return true if pitches have the same pitch class, false otherwise
     */
    private boolean samePitchClass(int pitch1, int pitch2){
        return getMod(pitch1) == getMod(pitch2);
    }
    
    /**
     * getMod
     * returns an int representing the pitch class of the midi value
     * (0 for C, ... , 11 for B)
     * @param midi midivalue
     * @return int representing a midi value's pitch class
     */
    private int getMod(int midi){
        return midi%OCTAVE;
    }
    
     /**
     * chordTones
     * Returns an ArrayList of all the chord tones of a given chord
     * (includes color tones if allowColor is true)
     * @param chord chord from which chord tones are to be extracted
     * @param duration duration that these notes are to have
     * @return ArrayList of chord tones - NOTE: default pitches used
     */
//    private ArrayList<Note> chordTones(Chord chord, int duration){
//        PolylistEnum noteList = chord.getSpell().elements();
//        ArrayList<Note> chordTones = new ArrayList<Note>();
//        while(noteList.hasMoreElements()){
//            Note note = ((NoteSymbol)noteList.nextElement()).toNote();
//            note.setRhythmValue(duration);
//            chordTones.add(note);
//        }
//        if(allowColor){
//            PolylistEnum colorList = chord.getColor().elements();
//            while(colorList.hasMoreElements()){
//                Note note = ((NoteSymbol)colorList.nextElement()).toNote();
//                note.setRhythmValue(duration);
//                chordTones.add(note);
//            }
//        }
//        return chordTones;
//    }

    private Note bestChoice(int prevInterval, Note prevNote, int duration, Chord chord) {
        int prevPitch = prevNote.getPitch();
        ArrayList<Integer> pitches = new ArrayList<Integer>();
        ArrayList<Double> pitchProbs = new ArrayList<Double>();
        
        int sourceIndex = intervalToIndex(prevInterval);
        for(int destIndex = 0; destIndex < probabilities[sourceIndex].length; destIndex ++){
            double prob = probabilities[sourceIndex][destIndex];
            int pitchToAdd = prevPitch + indexToInterval(destIndex);
            int typeIndex = chord.getTypeIndex(new Note(pitchToAdd));
            if(prob != 0 && inRange(pitchToAdd) && (typeIndex == Constants.CHORD_TONE || typeIndex == Constants.COLOR_TONE)){
                pitches.add(pitchToAdd);
                pitchProbs.add(prob);
            }
        }
        
        //if no pitches have nonzero probability, are in range, and are chord/color tones,
        //allow all non chord / color tones
        if(pitchProbs.isEmpty()){
            //System.out.println("Allow non chord/color tones");
            for(int destIndex = 0; destIndex < probabilities[sourceIndex].length; destIndex ++){
                double prob = probabilities[sourceIndex][destIndex];
                int pitchToAdd = prevPitch + indexToInterval(destIndex);
                if(prob != 0 && inRange(pitchToAdd)){
                    pitches.add(pitchToAdd);
                    pitchProbs.add(prob);
                }
            }
        }
        
        //if there are no intervals that have nonzero probability that are in range,
        //allow notes out of range
        if(pitchProbs.isEmpty()){
            //System.out.println("Allow out of range notes");
            for(int destIndex = 0; destIndex < probabilities[sourceIndex].length; destIndex ++){
                double prob = probabilities[sourceIndex][destIndex];
                int pitchToAdd = prevPitch + indexToInterval(destIndex);
                if(prob != 0){
                    pitches.add(pitchToAdd);
                    pitchProbs.add(prob);
                }
            }
        }
        
        //readjust probabilities so that they sum to one again
        //they might not sum to 1 anymore because we eliminated options that were out of range
        //and options that were'nt chord or color tones
        //System.out.println("choices: "+pitchProbs.size());
        double total = 0;
        for(double prob : pitchProbs){
            total += prob;
        }
        for(int i = 0; i<pitchProbs.size(); i++){
            pitchProbs.set(i, pitchProbs.get(i)/total);
        }
        
        Random r = new Random();
        double decision = r.nextDouble();
        double totalProb = 0;
        
        //this'll be unaltered if for some reason the probabilites don't sum
        //exactly to 1 and the random number generator produce exactly 1 (unlikely)
        int bestPitch = pitches.get(0);
        
        for(int i = 0; i < pitchProbs.size(); i++){
            totalProb += pitchProbs.get(i);
            if(totalProb > decision){
                bestPitch = pitches.get(i);
                break;
            }
        }
        
        return new Note(bestPitch, duration);
    }
    
    private static int intervalToIndex(int interval){
        return interval + Constants.OCTAVE;
    }
    
    private static int indexToInterval(int index){
        return index - Constants.OCTAVE;
    }

    private boolean inRange(int pitchToAdd) {
        return pitchToAdd >= range[0] && pitchToAdd <= range[1];
    }
    
}
