package org.example.Controller;

import org.example.models.User;
import org.example.usersFile.userFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.postgresdb.Query;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping
public class AuthMockController {
    @Autowired
    private Query q;
    @Autowired
    private userFile f;

    @GetMapping({"getUser"})
    public ResponseEntity<?> getUser(@RequestParam(value = "login", required = true) String login) {
        try {
            User u = q.getUser(login);
            f.writeUserToFile(u);
            return ResponseEntity.ok(u);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.toString(), e);
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
            catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.toString(), e);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping({"getLine"})
    public ResponseEntity<?> getLine() {
        try {

            return ResponseEntity.ok(f.getRandLine());
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.toString(), e);
        }
    }
}
