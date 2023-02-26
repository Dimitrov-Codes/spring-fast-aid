package com.example.springfastaidserver.controllers;

import com.example.springfastaidserver.models.User;
import com.example.springfastaidserver.services.RiderService;
import com.google.cloud.firestore.DocumentSnapshot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/rider/")

public class RiderController {

    private final RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @GetMapping("getAllRiders")
    public ResponseEntity<List<User>> getAllRiders() throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(riderService.getUserDetails(), HttpStatus.OK);
    }
    @GetMapping("id={id}")
    public ResponseEntity<User> getRiderByName(@PathVariable String id) throws ExecutionException, InterruptedException{
        return new ResponseEntity<>(riderService.getRiderById(id), HttpStatus.OK);
    }

}
