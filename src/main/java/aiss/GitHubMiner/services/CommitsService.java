package aiss.GitHubMiner.services;

import aiss.GitHubMiner.models.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CommitsService {
    @Autowired
    RestTemplate restTemplate;
    public Commit[] findCommits(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + "glpat-UByBki6qeqekMyVbkpCx");
        String url = "https://gitlab.com/api/v4/projects/3472737/repository/commits";
        HttpEntity<String> entity = new HttpEntity<String>(url,headers);
        ResponseEntity<Commit[]> commits = restTemplate.exchange(url, HttpMethod.GET, entity, Commit[].class);
        return commits.getBody();

    }
}