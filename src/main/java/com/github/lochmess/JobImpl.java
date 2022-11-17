package com.github.lochmess;

public class JobImpl implements Job {
    private int priority;

    @Override
    public int getUrgency() {
        return priority;
    }

    public JobImpl() {}

    public JobImpl(int priority) {
        this.priority = priority;
    }
}
