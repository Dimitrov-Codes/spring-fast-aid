package com.example.springfastaidserver;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class SpringFastAidServerApplication {

    public static void main(String[] args) throws IOException {
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://fast-aid-80b5d-default-rtdb.asia-southeast1.firebasedatabase.app")
                .build();

        FirebaseApp.initializeApp(options);

        SpringApplication.run(SpringFastAidServerApplication.class, args);
    }

}
