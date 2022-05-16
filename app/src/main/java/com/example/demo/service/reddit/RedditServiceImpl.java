package com.example.demo.service.reddit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class RedditServiceImpl implements RedditService {
    private final String CLIENT_ID = "slEytwGD66icenhhx5BcNA";
    private final String CLIENT_SECRET = "UoIR0vzyGjWN0Bh2zTIXbGH-ZPIe6A";
    private final String BASE_URL = "https://www.reddit.com/";

    private final String OAUTH_URL = "https://oauth.reddit.com/";

    private final Logger logger = LoggerFactory.getLogger(RedditServiceImpl.class);

    private HttpClient getHttpClient() {
        return HttpClients.custom().build();
    }

    private CloseableHttpClient getClosableHttpClient() {
        return HttpClients.createDefault();
    }

    private String getBase64EncodedCredentials() {
        String credentials = String.format("%s:%s", CLIENT_ID, CLIENT_SECRET);
        return new String(Base64.getEncoder().encode(credentials.getBytes()));
    }

    private HttpPost getAuthenticatedPostRequest(String url) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);

        // Basic authentication with username = client_id and password = client_secret
        httpPost.setHeader("Authorization", String.format("Basic %s", getBase64EncodedCredentials()));
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "ABCbum Reddit App");

        // Set Body to form data with grant_type = client_credentials
        List<NameValuePair> formData = new ArrayList<>();
        formData.add(new BasicNameValuePair("grant_type", "client_credentials"));
        httpPost.setEntity(new UrlEncodedFormEntity(formData));

        return httpPost;
    }

    private HttpGet getAuthenticatedGetRequest(String url, String accessToken) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Authorization", String.format("Bearer %s", accessToken));
        httpGet.setHeader("Content-Type", "application/json");
        httpGet.setHeader("User-Agent", "ABCbum Reddit App");

        return httpGet;
    }

    private List<Object> getRedditData(String url, String accessToken) throws URISyntaxException, IOException {
        HttpGet httpGet = getAuthenticatedGetRequest(url, accessToken);
        HttpResponse response = getHttpClient().execute(httpGet);
        HttpEntity entity = response.getEntity();
        logger.info("Response: {}", response);
        logger.info("Entity: {}", response.getEntity().toString());
        JSONObject jsonObject = new JSONObject(EntityUtils.toString(entity));
        JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("children");

        return jsonArray.toList();
    }

    @Override
    public String getAccessToken() throws URISyntaxException, IOException {
        CloseableHttpClient httpClient = getClosableHttpClient();
        URIBuilder uriBuilder = new URIBuilder(BASE_URL + "api/v1/access_token");
        HttpPost httpPost = getAuthenticatedPostRequest(uriBuilder.build().toString());

        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
//        logger.info("Response status code: {}", response.getStatusLine().getStatusCode());
//        logger.info("Response status message: {}", response.getStatusLine().getReasonPhrase());
//        logger.info("Response headers: {}", (Object) response.getAllHeaders());
//        logger.info("Request URL {}", httpPost.getURI());
//        logger.info("Request URL {}", (Object) httpPost.getAllHeaders());
//        logger.info("Request URL {}", httpPost.getEntity());
        logger.info(String.valueOf(response));

        JSONObject jsonObject = new JSONObject(EntityUtils.toString(entity));

        httpClient.close();
        return jsonObject.getString("access_token");
    }

    @Override
    public List<Object> getTop() throws URISyntaxException, IOException {
        String accessToken = getAccessToken();
        return getRedditData(OAUTH_URL + "top?sr_detail=true&show=true", accessToken);
    }

    @Override
    public List<Object> getTop(String subreddit) throws URISyntaxException, IOException {
        String accessToken = getAccessToken();
        return getRedditData(OAUTH_URL + "r/" + subreddit + "/top", accessToken);
    }

    @Override
    public List<Object> getNew() throws URISyntaxException, IOException {
        String accessToken = getAccessToken();
        return getRedditData(OAUTH_URL + "new?sr_detail=true&show=true", accessToken);
    }

    @Override
    public List<Object> getNew(String subreddit) throws URISyntaxException, IOException {
        String accessToken = getAccessToken();
        return getRedditData(OAUTH_URL + "r/" + subreddit + "/new", accessToken);
    }

    @Override
    public List<Object> getRising() throws URISyntaxException, IOException {
        String accessToken = getAccessToken();
        URIBuilder uriBuilder = new URIBuilder(OAUTH_URL + "rising?sr_detail=true&show=true");
        return getRedditData(uriBuilder.build().toString(), accessToken);
    }

    @Override
    public List<Object> getRising(String subreddit) throws URISyntaxException, IOException {
        String accessToken = getAccessToken();
        URIBuilder uriBuilder = new URIBuilder(OAUTH_URL + "r/" + subreddit + "/rising");
        return getRedditData(uriBuilder.build().toString(), accessToken);
    }

    @Override
    public List<Object> getHot() throws URISyntaxException, IOException {
        String accessToken = getAccessToken();
        URIBuilder uriBuilder = new URIBuilder(OAUTH_URL + "hot?sr_detail=true&show=true");
        return getRedditData(uriBuilder.build().toString(), accessToken);
    }

    @Override
    public List<Object> getHot(String subreddit) throws URISyntaxException, IOException {
        String accessToken = getAccessToken();
        URIBuilder uriBuilder = new URIBuilder(OAUTH_URL + "r/" + subreddit + "/hot");
        return getRedditData(uriBuilder.build().toString(), accessToken);
    }

    @Override
    public List<Object> getBest() throws URISyntaxException, IOException {
        String accessToken = getAccessToken();
        URIBuilder uriBuilder = new URIBuilder(OAUTH_URL + "best?sr_detail=true&show=true");
        return getRedditData(uriBuilder.build().toString(), accessToken);
    }

    @Override
    public List<Object> getBest(String subreddit) throws URISyntaxException, IOException {
        String accessToken = getAccessToken();
        URIBuilder uriBuilder = new URIBuilder(OAUTH_URL + "r/" + subreddit + "/best");
        return getRedditData(uriBuilder.build().toString(), accessToken);
    }

    @Override
    public List<Object> getControversial() throws URISyntaxException, IOException {
        String accessToken = getAccessToken();
        URIBuilder uriBuilder = new URIBuilder(OAUTH_URL + "controversial?sr_detail=true&show=true");
        return getRedditData(uriBuilder.build().toString(), accessToken);
    }

    @Override
    public List<Object> getControversial(String subreddit) throws URISyntaxException, IOException {
        String accessToken = getAccessToken();
        URIBuilder uriBuilder = new URIBuilder(OAUTH_URL + "r/" + subreddit + "/controversial");
        return getRedditData(uriBuilder.build().toString(), accessToken);
    }
}
