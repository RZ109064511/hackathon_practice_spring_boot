package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
public class DataController {
	
    @GetMapping
    @RequestMapping("/api/issues")
    public ResponseEntity<List<Map<String, Object>>> getData() {
        List<Map<String, Object>> data = new ArrayList<>();

        Map<String, Object> item1 = new HashMap<>();
        item1.put("category", Category.A);
        item1.put("title", "TestTitle1");
        item1.put("date", "2024-08-22");
        item1.put("description", "This is the 1 item.");
        item1.put("status", Status.A);

        data.add(item1);

        Map<String, Object> item2 = new HashMap<>();
        item2.put("category", Category.B);
        item2.put("title", "TestTitle2");
        item2.put("date", "2024-08-24");
        item2.put("description", "This is the 2 item.");
        item2.put("status", Status.B);

        data.add(item2);

        Map<String, Object> item3 = new HashMap<>();
        item3.put("category", Category.C);
        item3.put("title", "TestTitle3");
        item3.put("date", "2024-08-24");
        item3.put("description", "This is the third item.");
        item3.put("status", Status.C);

        data.add(item3);

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/api/issue")
    public ResponseEntity<String> postData(@RequestBody Map<String, Object> payload) {
        // Process the incoming data
        String category = (String) payload.get("category");
        String title = (String) payload.get("title");
        String selectedDate = (String) payload.get("selectedDate");
        String description = (String) payload.get("description");

        System.out.println("Received category: " + category);
        System.out.println("Received title: " + title);
        System.out.println("Received selectedDate: " + selectedDate);
        System.out.println("Received description: " + description);

        return new ResponseEntity<>("Data received successfully", HttpStatus.CREATED);
    }
}