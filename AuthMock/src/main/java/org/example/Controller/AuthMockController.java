package org.example.Controller;

import org.example.models.ResponseForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class AuthMockController {

    @GetMapping({"getForm"})
    public ResponseEntity<?> getForm() {
        return ResponseEntity.ok("{\"login\":\"login\",\"password\":\"password\"}");

    }

    @PostMapping({"postForm"})
    public ResponseEntity<ResponseForm> postForm(@RequestBody Map<String, String> map) {
        if (map.size() == 2 && map.containsKey("login") && map.containsKey("password")) {
            ResponseForm rf = new ResponseForm(map.get("login"), map.get("password"));
            return ResponseEntity.ok(rf);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }
}
