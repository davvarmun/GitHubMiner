package aiss.GitHubMiner.services;
import aiss.GitLabMiner.models.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IssuesService {
    @Autowired
    RestTemplate restTemplate;
    public Issue[] findIssues()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + "glpat-UByBki6qeqekMyVbkpCx");
        String url = "https://gitlab.com/api/v4/projects/3472737/issues";
        HttpEntity<String> entity = new HttpEntity<String>(url,headers);
        ResponseEntity<Issue[]> issues = restTemplate.exchange(url, HttpMethod.GET, entity, Issue[].class);
        return issues.getBody();
    }
}
