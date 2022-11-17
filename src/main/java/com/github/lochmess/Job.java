package com.github.lochmess;

public interface Job {
    // Larger values mean the job is more urgent, i.e. urgency = 5 is more urgent than 4.
    int getUrgency();

}
