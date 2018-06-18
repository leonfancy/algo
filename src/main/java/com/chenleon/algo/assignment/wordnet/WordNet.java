package com.chenleon.algo.assignment.wordnet;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class WordNet {
    private ST<String, Bag<Integer>> wordsST;
    private ArrayList<String> keys;
    private Digraph G;
    private SAP sap;

    // constructor takes the name of the two input files linearithmic
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null) throw new IllegalArgumentException();

        wordsST = new ST<>();
        keys = new ArrayList<>();

        In in = new In(synsets);
        int count = 0;
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(",");
            int id = parseInt(a[0]);
            keys.add(id, a[1]);

            String[] words = a[1].split(" ");
            for (String word : words) {
                Bag<Integer> ids = wordsST.get(word);
                if (ids == null) ids = new Bag<>();

                ids.add(id);
                wordsST.put(word, ids);
            }

            count++;
        }

        in = new In(hypernyms);
        G = new Digraph(count);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(",");
            int v = parseInt(a[0]);

            for (int i = 1; i < a.length; i++)
                G.addEdge(v, parseInt(a[i]));
        }
        sap = new SAP(G);
    }

    // returns all WordNet wordsST
    public Iterable<String> nouns() {
        return wordsST.keys();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        return wordsST.get(word) != null;
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) throw new IllegalArgumentException();
        return sap.length(wordsST.get(nounA), wordsST.get(nounB));
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) throw new IllegalArgumentException();
        int ancestor = sap.ancestor(wordsST.get(nounA), wordsST.get(nounB));
        return keys.get(ancestor);
    }
}
