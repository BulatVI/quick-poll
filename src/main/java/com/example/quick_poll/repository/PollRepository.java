package com.example.quick_poll.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.quick_poll.model.Poll;

public interface PollRepository extends PagingAndSortingRepository<Poll, Long>{

    void deleteById(Long pollId);

    Optional<Poll> findById(Long pollId);

    Iterable<Poll> findAll();
}
