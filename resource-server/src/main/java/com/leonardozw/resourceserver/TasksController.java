package com.leonardozw.resourceserver;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasks")
public class TasksController {
    
    @GetMapping
    public String getTasks(
        @AuthenticationPrincipal Jwt jwt
    ){
        return """
            <h1>Top secret task for %s</h1>
            <p>Do not share with anyone!</p>
            <ol>
                <li>Buy milk</li>
                <li>Buy eggs</li>
                <li>Buy bread</li>
            </ol>
            """.formatted(jwt.getSubject());
    }
}
