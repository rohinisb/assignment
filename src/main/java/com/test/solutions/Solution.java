package com.test.solutions;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

/**
 *
 */
public class Solution {

    private static final HttpClient client = HttpClient.newBuilder().build();
    private static ObjectMapper objectMapper = new ObjectMapper();

    private static int pageSize = 100;


    public static void main(String args[]) {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Solution s = new Solution();
        List<RepositoryInfo> repositoryInfos = s.getReposByStars();
        int i = 0;
        for(RepositoryInfo repoInfo : repositoryInfos) {
            System.out.println(repoInfo.getName() + " " + repoInfo.getStargazers_count());
            i++;
            if(i > 5) break;
        }
    }
    public List<RepositoryInfo> getReposByStars () {
        List<RepositoryInfo> response = new ArrayList();
        Comparator<RepositoryInfo> repositoryInfoComparator = (RepositoryInfo x, RepositoryInfo y)
                -> Integer.compare(y.getStargazers_count(), x.getStargazers_count());
        int page = 1;
        while(true) {
            try {
                HttpRequest request = HttpRequest.newBuilder(new URI("https://api.github.com/orgs/segmentio/repos?pageSize=" + pageSize + "&page=" + page))
                        .GET()
                        .header("accept","application/vnd.github.v3+json")
                        .build();
                String res = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
                List<RepositoryInfo> currResp = Arrays.asList(objectMapper.readValue(res, RepositoryInfo[].class));
                if(currResp.isEmpty()) {
                    break;
                }
                response.addAll(currResp);
                page++;
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        response.sort(repositoryInfoComparator);
        return response;
    }


}
