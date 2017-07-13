/**
 * This Java Class is part of the Impro-Visor Application
 *
 * Copyright (C) 2017 Robert Keller and Harvey Mudd College
 *
 * Impro-Visor is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Impro-Visor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * merchantability or fitness for a particular purpose.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Impro-Visor; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package imp.style;

import imp.data.Chord;
import imp.data.ChordPart;
import imp.roadmap.brickdictionary.Block;
import imp.roadmap.brickdictionary.ChordBlock;
import imp.style.stylePatterns.Interpolant;
import java.util.ArrayList;
import polya.Polylist;
import polya.PolylistBuffer;

/**
 *
 * @author Isys Johnson
 */
public class Interpolate
  {
//    private static final Polylist INTERPOLANTLIST_TABLE
//            = Polylist.list(
//                    Polylist.list(Polylist.list("C7"), "G7", .5, 120),
//                    Polylist.list(Polylist.list("C7"), "Db7", .3, 120),
//                    Polylist.list(Polylist.list("C7"), "Gm7", .2, 120),
//                    Polylist.list(Polylist.
//                            list("CM9", "CM7", "Cm7", "C6", "Cm6"), "G7", .25,
//                                  120),
//                    Polylist.list(Polylist.
//                            list("CM9", "CM7", "Cm7", "C6", "Cm6"), "Db7", .25,
//                                  120),
//                    Polylist.list(Polylist.
//                            list("CM9", "CM7", "Cm7", "C6", "Cm6"), "G7b9", .25,
//                                  120),
//                    Polylist.list(Polylist.
//                            list("CM9", "CM7", "Cm7", "C6", "Cm6"), "G7alt", .25,
//                                  120),
//                    Polylist.list(Polylist.list("C7b9", "C7alt"), "Gm7b5", .5,
//                                  120),
//                    Polylist.
//                            list(Polylist.list("C7b9", "C7alt"), "Db7", .2, 120),
//                    Polylist.
//                            list(Polylist.list("C7b9", "C7alt"), "Gm7", .3, 120),
//                    Polylist.list(Polylist.list("default"), "G7", .5, 120),
//                    Polylist.list(Polylist.list("default"), "Db7", .5, 120)
//            );
//    public static Polylist INTERPOLANT_TABLE = setTable(INTERPOLANTLIST_TABLE);
//
//    private static Polylist setTable(Polylist P)
//    {
//        //System.out.println(P);
//        //System.out.println("hello, inside set table" + P.first());
//        Polylist L = Polylist.nil;
//        for( Polylist A = P; A.nonEmpty(); A = A.rest() )
//          {
//            // System.out.println("hihi  " + Interpolant.makeInterpolant((Polylist)A.first()));
//            L = L.append(Polylist.list(Interpolant.makeInterpolant((Polylist) A.first())));
//          }
//        //System.out.println("table " + L);
//        return L;
//    }
//
//    public static Polylist getRows(Chord c)
//    {
//        //System.out.println(setTable(INTERPOLANTLIST_TABLE));
//        Polylist rows = Polylist.nil;
//        for( Polylist P = INTERPOLANT_TABLE; P.nonEmpty(); P = P.rest() )
//          {
//
//            Interpolant currentRow = (Interpolant) P.first();
//            //  System.out.println(currentRow);
//            if( currentRow.getTARGETS().member(c.getName()) )
//              {
//                rows = rows.append(Polylist.list(currentRow));
//              }
//            else if( rows.nonEmpty() )
//              {
//                return rows;
//              }
//          }
//        Polylist defaults = INTERPOLANT_TABLE.reverse();
//        rows = Polylist.list(defaults.first(), defaults.second());
//        return rows;
//    }

    public static Polylist ArraytoPoly(ArrayList array)
    {
        PolylistBuffer buffer = new PolylistBuffer();
        for( Object item : array )
          {
            buffer.append(item);
          }
        return buffer.toPolylist();
    }

    //returns a Polylist of booleans to decide where interpolants will lie
    public static Polylist willInterpolate(ChordPart chordPart, int index)
    {
        // System.out.println("inside willInterpolate, current index: " + index + " chord at index: " + chordPart.getChord(index));
        if( chordPart.getChord(index) == null )
          {
            return Polylist.nil;
          }
        Block currentblock = chordPart.getBlockAtSlot(index);
        //   System.out.println("currentBlock: " + currentblock);
        String type = currentblock.getType();
        ArrayList<ChordBlock> chrds = currentblock.flattenBlock();
        Polylist chords = ArraytoPoly(chrds);
        Chord currentChord = chordPart.getChord(index);

        // System.out.println("current chord: " + currentChord.getName() +" chords: " + chords);
        ChordBlock ccBlock = new ChordBlock(currentChord.getName(),
                                            currentChord.getRhythmValue());

        int chordDex = 0;
        for( Polylist A = chords; A.nonEmpty(); A = A.rest() )
          {
            if( ccBlock.getChord().getName().equals(((ChordBlock) A.first()).
                    getChord().getName()) )
              {
                break;
              }
            else
              {
                chordDex++;
              }
          }

        int steps;
        Polylist list = Polylist.nil;

        if( currentChord.getRhythmValue() <= 120 )
          {
            steps = 0;
          }
        else
          {
            steps = currentChord.getRhythmValue() / 120 - 1;
          }
        // System.out.println("ChordDex: " + chordDex + " steps: " +steps);
        //System.out.println("currentChord in Interpolate: " + currentChord);
        boolean overrun = false;
        for( int a = 0; a < steps; a++ )
          {
            if( chords.length() == 1 && steps <= 5 )
              {
                list = list.append(Polylist.list(false));
              }
            else
              {
                switch( type )
                  {
                    case "Overrun":
                        overrun = true;
                        if( chordDex == chords.length() - 1 )
                          {
                            list = list.append(Polylist.list(false));
                          }
                    case "Cadence":
                        if( overrun && chordDex == chords.length() - 1 )
                          {
                            break;
                          }
                        else
                          {
                            if( a == 0 || a == steps - 1 )
                              {
                                list = list.append(Polylist.list(false));
                              }
                            else if( (chordDex >= chords.length() / 2 || steps >= 7) && a % 2 == 1 )
                              {
                                list = list.append(Polylist.list(true));
                              }
                            else
                              {
                                list = list.append(Polylist.list(false));
                              }
                            break;
                          }
                    case "Opening":
                        list = list.append(Polylist.list(false));
                        break;
                    case "Turnaround":
                        if( a == 0 || a % 2 == 0 )
                          {
                            list = list.append(Polylist.list(false));
                          }
                        else
                          {
                            int random = (int) (Math.random() * 100 + 1);
                            if( random > 40 )
                              {
                                list = list.append(Polylist.list(true));
                              }
                            else
                              {
                                list = list.append(Polylist.list(false));
                              }
                          }
                    case "Approach":
                    case "On-Off":
                        list = list.append(Polylist.list(false));
                        break;
                    case "Deceptive Cadence":
                    case "Dropback":
                    case "Ending":
                    case "On":
                    case "Pullback":
                    case "Misc":
                    default:
                        break;
                  }
              }
          }
        Polylist result = Polylist.list(currentChord, list);
        index += currentChord.getRhythmValue();
        return willInterpolate(chordPart, index).cons(result);
    } // willInterpolate
  }
