package aiss.GitHubMiner.services;

import aiss.GitLabMiner.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CommentsService {
    @Autowired
    RestTemplate restTemplate;
    public Comment[] findComments(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + "glpat-UByBki6qeqekMyVbkpCx");
        String url = "https://gitlab.com/api/v4/projects/3472737/issues/4256/notes";
        HttpEntity<String> entity = new HttpEntity<String>(url,headers);
        ResponseEntity<Comment[]> comments = restTemplate.exchange(url, HttpMethod.GET, entity, Comment[].class);
        return comments.getBody();

    }
}
