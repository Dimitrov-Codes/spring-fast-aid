package com.example.springfastaidserver.controllers;

import com.example.springfastaidserver.models.User;
import com.example.springfastaidserver.services.DriverService;
import com.example.springfastaidserver.services.RiderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/api/driver/")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("getAllDrivers")
    public ResponseEntity<List<User>> getAllRiders() throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(driverService.getUserDetails(), HttpStatus.OK);
    }
    @GetMapping("id={id}")
    public ResponseEntity<User> getRiderByName(@PathVariable String id) throws ExecutionException, InterruptedException{
        return new ResponseEntity<>(driverService.getDriverById(id), HttpStatus.OK);
    }
}
