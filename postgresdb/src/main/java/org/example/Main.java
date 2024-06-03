package org.example;

//STEP 1. Import required packages

public class Main {

    public static void main(String[] argv) {
        Query q = new Query();
        User user = q.getUser("user1");
        System.out.println(user);
        System.out.println(q.insertData(new User("user65234regf", "new_pass", new java.sql.Date(System.currentTimeMillis()),"newEmail@mail.ru")));

        user = q.getUser("user6");
        System.out.println(user);

    }
}