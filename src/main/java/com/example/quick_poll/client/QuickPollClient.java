package com.example.quick_poll.client;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.quick_poll.model.Option;
import com.example.quick_poll.model.Poll;

public class QuickPollClient {

    private static final String QUICK_POLL_URI_V1 = "http://localhost:8080/v1/polls";
    private RestTemplate restTemplate = new RestTemplate();

    public Poll getPollById(Long pollId) {
        return restTemplate.getForObject(QUICK_POLL_URI_V1 + "/{pollId}", Poll.class, pollId);
    }

    public List<Poll> getAllPolls() {
        ParameterizedTypeReference<List<Poll>> responseType = new ParameterizedTypeReference<List<Poll>>() {
        };
        ResponseEntity<List<Poll>> responseEntity = restTemplate
                .exchange(QUICK_POLL_URI_V1, HttpMethod.GET, null, responseType);

        // Other possible implementations
        // List allPolls = restTemplate.getForObject(QUICK_POLL_URI_V1, List.class);
        // Poll[] allPolls = restTemplate.getForObject(QUICK_POLL_URI_V1, Poll[].class);

        return responseEntity.getBody();
    }

    public URI createPoll(Poll poll) {
        return restTemplate.postForLocation(QUICK_POLL_URI_V1, poll);
    }

    public void updatePoll(Poll poll) {
        restTemplate.put(QUICK_POLL_URI_V1 + "/{pollId}", poll, poll.getId());
    }

    public void deletePoll(Long pollId) {
        restTemplate.delete(QUICK_POLL_URI_V1 + "/{pollId}", pollId);
    }

    public static void main(String[] args) {
        QuickPollClient client = new QuickPollClient();

        // Test GetPoll
        Poll poll = client.getPollById(1L);
        System.out.println(poll);
        System.out.println();

        // Test GetAllPolls
        List<Poll> allPolls = client.getAllPolls();
        System.out.println(allPolls);
        System.out.println();

        // Test Create Poll
        Poll newPoll = new Poll();
        newPoll.setQuestion("What is your favourate color?");
        Set<Option> options = new HashSet<>();
        newPoll.setOptions(options);

        Option option1 = new Option();
        option1.setValue("Red");
        options.add(option1);

        Option option2 = new Option();
        option2.setValue("Blue");
        options.add(option2);
        System.out.println(newPoll);
        System.out.println();

        URI pollLocation = client.createPoll(newPoll);
        System.out.println("Newly Created Poll Location " + pollLocation);
        System.out.println();

        // Test Update Poll with Id 6
        Poll pollForId6 = client.getPollById(6L);
        // Add a new Option
        Option newOption = new Option();
        newOption.setValue("The Incredibles");
        pollForId6.getOptions().add(newOption);

        client.updatePoll(pollForId6);

        pollForId6 = client.getPollById(6L);
        System.out.println("Updated poll has " + pollForId6.getOptions().size() + " options");
        System.out.println();

        // Test Delete
        client.deletePoll(5L);
        System.out.println();

    }
}
