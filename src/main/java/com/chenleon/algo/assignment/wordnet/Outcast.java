package com.chenleon.algo.assignment.wordnet;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

public class Outcast {
    private WordNet wordnet;

    // constructor takes a WordNet object
    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        int dt = 0;
        int t = 0;

        HashMap<String, Integer> cache = new HashMap<>();
        for (int i = 0; i < nouns.length; i++) {
            for (int j = i; j < nouns.length; j++) {
                cache.put((i + "," + j), wordnet.distance(nouns[i], nouns[j]));
            }
        }

        for (int i = 0; i < nouns.length; i++) {
            int di = 0;
            for (int j = 0; j < nouns.length; j++) {
                String key = i < j ? (i + "," + j) : (j + "," + i);
                di += cache.get(key);
            }

            if(di > dt) {
                dt = di;
                t = i;
            }
        }

        return nouns[t];
    }

    // see test client below
    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
}
