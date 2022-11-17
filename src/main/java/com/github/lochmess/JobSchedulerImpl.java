package com.github.lochmess;

public class JobSchedulerImpl implements JobScheduler {
    Node queue;

    @Override
    public Job getNext() {
        Job current = queue.getJob();
        queue = queue.getNext();
        return current;
    }

    @Override
    public void schedule(Job job) {
        if (queue == null) {
            queue = new Node(job);
        } else {
            Node newNode = new Node(job);
            Node current = queue;
            if (queue.getJob().getUrgency() < newNode.getJob().getUrgency()) {
                newNode.setNext(current);
                queue = newNode;
            } else {
                while (current.getNext() != null && current.getNext().getJob().getUrgency() >= job.getUrgency()) {
                    current = current.getNext();
                }
                if (current.getNext() != null) {
                    Node next = current.getNext();
                    newNode.setNext(next);
                }
                current.setNext(newNode);
            }
        }
    }
}
