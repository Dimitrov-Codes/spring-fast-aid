package com.example.springfastaidserver.services;

import com.example.springfastaidserver.models.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
public class RiderService {
    private final Firestore firestore = FirestoreClient.getFirestore();

    public ArrayList<User> getUserDetails() throws InterruptedException, ExecutionException {

        ArrayList<User> users = new ArrayList<>();
        ApiFuture<QuerySnapshot> querySnapshot = firestore.collection("Rider").get();
        querySnapshot.get()
                .getDocuments()
                .forEach(document -> {
                    convertDocumentToUser(document);
                    users.add(convertDocumentToUser(document));
                });

        return users;
    }
    public User getRiderById(String id) throws ExecutionException, InterruptedException {
        DocumentSnapshot document = firestore.collection("Rider").document(id).get().get();
        return convertDocumentToUser(document);

    }

    private User convertDocumentToUser(DocumentSnapshot document) {
        User user = new User();
        user.setLatitude(document.getDouble("Latitude"));
        user.setLongitude(document.getDouble("Longitude"));
        user.setName(document.getString("name"));
        user.setPhone_number(document.getString("phone_number"));
        user.setStatus(document.getString("status"));
        user.setId(document.getId());
        return user;
    }
}
