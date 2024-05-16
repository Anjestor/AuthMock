package org.example.Controller;

import jakarta.validation.Valid;
import org.example.models.Request;
import org.example.models.ResponseForm;
import org.example.models.StaticForm;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Validated
public class AuthMockController {

    @GetMapping({"getForm"})
    public ResponseEntity<StaticForm> getForm() {
        StaticForm sf = new StaticForm();
        return ResponseEntity.ok(sf);
    }

    @PostMapping({"postForm"})
    public ResponseEntity<ResponseForm> postForm(@Valid @RequestBody Request req) {
        ResponseForm rf = new ResponseForm(req.getLogin(), req.getPassword());
        return ResponseEntity.ok(rf);
    }

}
