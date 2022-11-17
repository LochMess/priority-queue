package com.github.lochmess;

public class Node {
    private Node next;
    private final Job job;

    public Node(Job job) {
        this.job = job;
        this.next = null;
    }

    public Node(Job job, Node next) {
        this.job = job;
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Job getJob() {
        return this.job;
    }
}
