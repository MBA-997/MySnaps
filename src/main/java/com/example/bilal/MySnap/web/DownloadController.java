package com.example.bilal.MySnap.web;

import com.example.bilal.MySnap.model.MySnap;
import com.example.bilal.MySnap.service.MySnapService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {
    private final MySnapService mySnapService;
    public DownloadController(MySnapService mySnapService) {
        this.mySnapService = mySnapService;
    }
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadPhoto(@PathVariable Integer id){

        MySnap mySnap = mySnapService.get(id);

        byte[] data = mySnap.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.valueOf(mySnap.getContentType()) );
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(mySnap.getFileName())
                .build();
        headers.setContentDisposition(build);

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
