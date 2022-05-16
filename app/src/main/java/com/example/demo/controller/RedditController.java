package com.example.demo.controller;

import com.example.demo.service.reddit.RedditService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("/reddit")
public class RedditController {
    private final RedditService redditService;

    public RedditController(RedditService redditService) {
        this.redditService = redditService;
    }

    @GetMapping(value = "/best", produces = "application/json")
    public Callable<List<Object>> redditBest() throws URISyntaxException, IOException {
        return this.redditService::getBest;
    }

    @GetMapping(value = "/best/{subreddit}", produces = "application/json")
    public Callable<List<Object>> redditBestSubreddit(@PathVariable String subreddit) throws URISyntaxException, IOException {
        return () -> this.redditService.getBest(subreddit);
    }

    @GetMapping(value = "/new", produces = "application/json")
    public Callable<List<Object>> redditNew() throws URISyntaxException, IOException {
        return redditService::getNew;
    }

    @GetMapping(value = "/new/{subreddit}", produces = "application/json")
    public Callable<List<Object>> redditNewSubreddit(@PathVariable String subreddit) throws URISyntaxException, IOException {
        return () -> this.redditService.getNew(subreddit);
    }

    @GetMapping(value = "/top", produces = "application/json")
    public Callable<List<Object>> redditTopSubreddit() throws URISyntaxException, IOException {
        return redditService::getTop;
    }

    @GetMapping(value = "/top/{subreddit}", produces = "application/json")
    public Callable<List<Object>> redditTopSubreddit(@PathVariable String subreddit) throws URISyntaxException, IOException {
        return () -> this.redditService.getTop(subreddit);
    }

    @GetMapping(value = "/rising", produces = "application/json")
    public Callable<List<Object>> redditRising() throws URISyntaxException, IOException {
        return redditService::getRising;
    }

    @GetMapping(value = "/rising/{subreddit}", produces = "application/json")
    public Callable<List<Object>> redditRisingSubreddit(@PathVariable String subreddit) throws URISyntaxException, IOException {
        return () -> this.redditService.getRising(subreddit);
    }

    @GetMapping(value = "/hot", produces = "application/json")
    public Callable<List<Object>> redditHot() throws URISyntaxException, IOException {
        return this.redditService::getHot;
    }

    @GetMapping(value = "/hot/{subreddit}", produces = "application/json")
    public Callable<List<Object>> redditHotSubreddit(@PathVariable String subreddit) throws URISyntaxException, IOException {
        return () -> this.redditService.getHot(subreddit);
    }

    @GetMapping(value = "/controversial", produces = "application/json")
    public Callable<List<Object>> redditControversial() throws URISyntaxException, IOException {
        return redditService::getControversial;
    }

    @GetMapping(value = "/controversial/{subreddit}", produces = "application/json")
    public Callable<List<Object>> redditControversialSubreddit(@PathVariable String subreddit) throws URISyntaxException, IOException {
        return () -> this.redditService.getControversial(subreddit);
    }
}
