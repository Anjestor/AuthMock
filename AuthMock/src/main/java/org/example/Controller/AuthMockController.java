package org.example.Controller;

import jakarta.validation.Valid;
import org.example.models.Request;
import org.example.models.ResponseForm;
import org.example.models.StaticForm;
import org.example.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping
public class AuthMockController implements WebMvcConfigurer{
    private AuthService au;


    @GetMapping({"getForm"})
    public ResponseEntity<StaticForm> getForm() {
        StaticForm sf = this.au.sendForm();
        return ResponseEntity.ok(sf);
    }

    @PostMapping({"postForm"})
    public ResponseEntity<ResponseForm> postForm(@Valid @RequestBody Request req) {
        ResponseForm rf = this.au.getForm(req);
        return ResponseEntity.ok(rf);
    }

    public AuthMockController(final AuthService authService) {
        this.au = authService;
    }
}
