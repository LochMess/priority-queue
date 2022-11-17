package com.github.lochmess;

public interface JobScheduler {
    // Gets the most urgent job: the job which has been waiting the longest is the most urgent.
    // If no job is available, returns null.
    Job getNext();

    // Schedules a job.
    void schedule(Job job);

}
