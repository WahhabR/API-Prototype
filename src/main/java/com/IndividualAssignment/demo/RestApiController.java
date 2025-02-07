package com.IndividualAssignment.demo;

import org.springframework.web.bind.annotation.GetMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RestApiController {

    @GetMapping("/wikisummary")
    public Object getWikiSummary(@RequestParam(value = "title", defaultValue = "Lion") String title) {
        try{
        String url = "https://en.wikipedia.org/api/rest_v1/page/summary/" + title;

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

            String jsonListResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonListResponse);


        WikiSummary summary = new WikiSummary(root.get("title").asText(), root.get("pageid").asDouble(), root.get("description").asText());
        return summary;

    } catch (JsonProcessingException ex) {
        Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE,
                null, ex);
        return "error in /wikisummary";
    }

    }
}
