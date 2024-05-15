package org.example.service;

import org.example.models.Request;
import org.example.models.ResponseForm;
import org.example.models.StaticForm;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public StaticForm sendForm() {
        return new StaticForm();
    }

    public ResponseForm getForm(@NonNull Request req) {
        if (req == null) {
            throw new NullPointerException("Request.req is null");
        } else {
            String loginFromRequest = req.getLogin();
            String passwordFromRequest = req.getPassword();
            return new ResponseForm(loginFromRequest, passwordFromRequest);
        }
    }

    public AuthService() {
    }

}
