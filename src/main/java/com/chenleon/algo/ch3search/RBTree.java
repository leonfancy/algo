package com.chenleon.algo.ch3search;

public class RBTree<Key extends Comparable<Key>, Value> {
    private Node root = null;

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        return x == null ? 0 : x.count;
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;

        x.count = 1 + size(x.left) + size(x.right);

        return x;
    }

    private class Node {
        private Node left;
        private Key key;
        private Value value;
        private Node right;
        private int count;

        public Node(Key key, Value value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }
}