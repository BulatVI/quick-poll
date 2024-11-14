package com.example.quick_poll.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.quick_poll.model.Poll;

public interface PollRepository extends PagingAndSortingRepository<Poll, Long>{
}
