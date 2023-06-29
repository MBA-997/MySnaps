package com.example.bilal.MySnap.web;

import com.example.bilal.MySnap.model.MySnap;
import com.example.bilal.MySnap.service.MySnapService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class MySnapController {

    private final MySnapService photoService;
    public MySnapController(MySnapService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/mysnaps")
    public Iterable<MySnap> get(){
        return photoService.get();
    }

    @GetMapping("/mysnaps/{id}")
    public MySnap get(@PathVariable Integer id){
        MySnap mySnap = photoService.get(id);

        if(mySnap == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return mySnap;
    }

    @DeleteMapping("/mysnaps/{id}")
    public void deletePhoto( @PathVariable Integer id){
        photoService.remove(id);
    }

    @PostMapping("/mysnaps/")
    public MySnap createPhoto(@RequestPart("data") MultipartFile file) throws IOException {

        return photoService.put(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
