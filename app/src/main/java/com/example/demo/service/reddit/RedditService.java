package com.example.demo.service.reddit;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface RedditService {
    String getAccessToken() throws URISyntaxException, IOException;

    List<Object> getTop() throws URISyntaxException, IOException;

    List<Object> getTop(String subreddit) throws URISyntaxException, IOException;

    List<Object> getNew() throws URISyntaxException, IOException;

    List<Object> getNew(String subreddit) throws URISyntaxException, IOException;

    List<Object> getRising() throws URISyntaxException, IOException;

    List<Object> getRising(String subreddit) throws URISyntaxException, IOException;

    List<Object> getHot() throws URISyntaxException, IOException;

    List<Object> getHot(String subreddit) throws URISyntaxException, IOException;

    List<Object> getBest() throws URISyntaxException, IOException;

    List<Object> getBest(String subreddit) throws URISyntaxException, IOException;

    List<Object> getControversial() throws URISyntaxException, IOException;

    List<Object> getControversial(String subreddit) throws URISyntaxException, IOException;
}
