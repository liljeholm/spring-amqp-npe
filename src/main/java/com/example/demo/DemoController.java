package com.example.demo;

import org.springframework.http.ContentDisposition;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/file")
    public ResponseEntity<Object> getFile() {
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .headers(httpHeaders -> httpHeaders.setContentDisposition(ContentDisposition
                        .builder("attachment")
                        .filename("this_is_the_filename.txt")
                        .build()))
                .build();
    }
}
