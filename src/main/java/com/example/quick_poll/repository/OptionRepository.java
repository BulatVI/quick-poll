package com.example.quick_poll.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.quick_poll.model.Option;

public interface OptionRepository extends PagingAndSortingRepository<Option,Long>{


}
