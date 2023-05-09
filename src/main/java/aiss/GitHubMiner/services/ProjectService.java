package aiss.GitHubMiner.services;
import aiss.GitLabMiner.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProjectService {
    @Autowired
    RestTemplate restTemplate;
    public Project findProject()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + "glpat-UByBki6qeqekMyVbkpCx");
        String url = "https://gitlab.com/api/v4/projects/3472737";
        HttpEntity<String> entity = new HttpEntity<String>(url,headers);
        ResponseEntity<Project> project = restTemplate.exchange(url, HttpMethod.GET, entity, Project.class);
        return project.getBody();
    }
}
