package org.example.usersFile;

import org.example.models.User;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Component("f")
public class userFile {
    private File users_txt;


    public String getRandLine() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(this.users_txt.getName()));
            if (!lines.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(lines.size());
                return lines.get(randomIndex);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String("File is empty");
    }

    public void writeUserToFile(User u) {
        try {
            FileWriter myWriter = new FileWriter(this.users_txt, true);
            myWriter.write(u.userData() + '\n');
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public userFile() {
        try {
            this.users_txt = new File("users");
            if (this.users_txt.createNewFile()) {
                System.out.println("File created: " + this.users_txt.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
