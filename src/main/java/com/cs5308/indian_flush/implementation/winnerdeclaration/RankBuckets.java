/* @Author: Vikram*/

package com.cs5308.indian_flush.implementation.winnerdeclaration;

import com.cs5308.indian_flush.implementation.winnerdeclaration.interfaces.IRankBuckets;

import java.util.ArrayList;

public class RankBuckets implements IRankBuckets {

    ArrayList<String> triplets;
    ArrayList<String> pureSeq;
    ArrayList<String> seq;
    ArrayList<String> color;
    ArrayList<String> pair;
    ArrayList<String> high;

    public ArrayList<String> getTriplets() {
        return triplets;
    }

    public ArrayList<String> getPureSequence() {
        return pureSeq;
    }

    public ArrayList<String> getSequence() {
        return seq;
    }

    public ArrayList<String> getColor() {
        return color;
    }

    public ArrayList<String> getPair() {
        return pair;
    }

    public ArrayList<String> getHigh() {
        return high;
    }

    public RankBuckets() {
        this.triplets = new ArrayList<>();
        this.pureSeq = new ArrayList<>();
        this.seq = new ArrayList<>();
        this.color = new ArrayList<>();
        this.pair = new ArrayList<>();
        this.high = new ArrayList<>();
    }
}
