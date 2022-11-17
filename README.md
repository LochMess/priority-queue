# Job Scheduler
There is a producer that emits jobs to a job scheduler that provides the jobs to the consumer upon request. The current highest priority job is provided to the consumer.

## Complexity 
- insertion O(n)
- removal O(1)
- space O(n)