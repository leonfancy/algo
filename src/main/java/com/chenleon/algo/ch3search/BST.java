package com.chenleon.algo.ch3search;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root = null;

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int res = key.compareTo(x.key);
            if (res < 0) x = x.left;
            else if (res > 0) x = x.right;
            else return x.value;
        }
        return null;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if(x == null) return new Node(key, value);

        int res = key.compareTo(x.key);
        if(res < 0) x.left = put(x.left, key, value);
        else if(res > 0) x.right = put(x.right, key, value);
        else x.value = value;

        return x;
    }

    private class Node {
        private Node left;
        private Key key;
        private Value value;
        private Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}
