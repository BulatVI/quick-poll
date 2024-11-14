package com.example.quick_poll.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.quick_poll.model.Poll;
import com.example.quick_poll.repository.PollRepository;
import com.example.quick_poll.v1.controller.PollController;

public class PollControllerMockTest {

    @Mock
    private PollRepository pollRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPolls() {
        PollController pollController = new PollController();
        ReflectionTestUtils.setField(pollController, "pollRepository", pollRepository);

        /*
         * либо можно так сделать, как я понял, вместо верхних 2 строк
         * PollController pollController = new PollController(pollRepository);
         */

        when(pollRepository.findAll()).thenReturn(new ArrayList<Poll>());
        ResponseEntity<Iterable<Poll>> allPollsEntity = pollController.getAllPolls();
        verify(pollRepository, times(1)).findAll();
        assertEquals(HttpStatus.OK, allPollsEntity.getStatusCode());
        assertEquals(0, Lists.newArrayList(allPollsEntity.getBody()).size());
    }
}
