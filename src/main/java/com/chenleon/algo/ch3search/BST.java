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

    public Value min() {
        Node x = root;
        if (x == null) return null;
        while (x.left != null) x = x.left;
        return x.value;
    }

    public Value max() {
        Node x = root;
        if (x == null) return null;
        while (x.right != null) x = x.right;
        return x.value;
    }

    public Value floor(Key key) {
        Node x = floor(root, key);
        return x == null ? null : x.value;
    }


    public Value ceil(Key key) {
        Node x = ceil(root, key);
        return x == null ? null : x.value;
    }

    private Node ceil(Node x, Key key) {
        if (x == null) return null;

        int res = key.compareTo(x.key);
        if (res == 0) return x;
        if (res > 0) return ceil(x.right, key);

        Node t = ceil(x.left, key);
        return t == null ? x : t;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;

        int res = key.compareTo(x.key);
        if (res == 0) return x;
        if (res < 0) return floor(x.left, key);

        Node t = floor(x.right, key);
        return t == null ? x : t;
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value);

        int res = key.compareTo(x.key);
        if (res < 0) x.left = put(x.left, key, value);
        else if (res > 0) x.right = put(x.right, key, value);
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
