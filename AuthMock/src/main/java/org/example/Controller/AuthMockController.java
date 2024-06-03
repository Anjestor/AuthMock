package org.example.Controller;

import org.example.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.postgresdb.Query;
import java.util.Map;

@RestController
@RequestMapping
public class AuthMockController {
    Query q = new Query();

    @GetMapping({"getUser"})
    public ResponseEntity<?> getUser(@RequestParam(value = "login", required = true) String login) {
        try {
            User u = q.getUser(login);
            return ResponseEntity.ok(u);
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>("User not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping({"postForm"})
    public ResponseEntity<?> postUser(@RequestBody Map<String, String> map) {
        if (map.size() == 3 && map.containsKey("login") && map.containsKey("password") && map.containsKey("email")) {
            try {
                return ResponseEntity.ok(
                        q.addUser(new User(map.get("login"),
                                map.get("password"),
                                new java.sql.Date(System.currentTimeMillis()),
                                map.get("email")
                        )));
            }
            catch (RuntimeException e) {
                return new ResponseEntity<>("User already exists or invalid data type", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
