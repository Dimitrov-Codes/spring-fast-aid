package com.example.springfastaidserver.service;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.util.Arrays;

public class RiderServiceTest {
    @Test
    public void displayServiceFile() throws Exception{
        FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json");
        for(byte i: (serviceAccount.readAllBytes())){
            System.out.print(((char) i ));
        }
        assert true;
    }
}
