package com.github.lochmess;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobSchedulerImplTest {

    @Test
    void should_schedule_multiple_jobs_in_order() {
        var js = new JobSchedulerImpl();
        var jobs = new ArrayList<Job>();
        jobs.add(new JobImpl());
        jobs.add(new JobImpl());
        jobs.add(new JobImpl());

        jobs.forEach(js::schedule);

        assertEquals(3, jobs.size());
        jobs.forEach(job -> assertEquals(job, js.getNext()));
    }


    @Test
    void should_schedule_priority_jobs_ahead() {
        var js = new JobSchedulerImpl();
        var lowPriorityJobs = new ArrayList<Job>();
        lowPriorityJobs.add(new JobImpl(0));
        lowPriorityJobs.add(new JobImpl(0));
        lowPriorityJobs.add(new JobImpl(0));

        var highPriorityJobs = new ArrayList<Job>();
        highPriorityJobs.add(new JobImpl(99));
        highPriorityJobs.add(new JobImpl(99));
        highPriorityJobs.add(new JobImpl(99));

        lowPriorityJobs.forEach(js::schedule);
        highPriorityJobs.forEach(js::schedule);

        /**
         * Asserting list sizes to ensure test will fail if the list is empty
         */
        assertEquals(3, lowPriorityJobs.size());
        assertEquals(3, highPriorityJobs.size());
        highPriorityJobs.forEach(job -> assertEquals(job, js.getNext()));
        lowPriorityJobs.forEach(job -> assertEquals(job, js.getNext()));
    }
}