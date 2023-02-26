package com.example.springfastaidserver.models;

import lombok.Data;

@Data
public class User {
    public String id;
    public Double latitude;
    public Double longitude;
    public String name;
    public String phone_number;
    public String status;
}
