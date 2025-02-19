package com.chickensystem.mis.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chickensystem.mis.datamodel.chicken;
import com.chickensystem.mis.services.ChickenService;

@RestController
@RequestMapping("/Chickens")
public class ChickenController {
     private final ChickenService chickenService;

    //@Autowired
    public ChickenController(ChickenService chickenService) {
        this.chickenService = chickenService;
    }

    @PostMapping()
    public void addChicken(@RequestBody chicken chicken) {
        chickenService.addChicken(chicken);
    }

    @GetMapping(path = "")
    public List<chicken> getChickens() {
        return chickenService.getChickens();
    }

    @GetMapping("/{id}")
    public chicken getChickenById(@PathVariable String id) {
        return chickenService.getChickenById(id);
    }

    @PutMapping("/{id}")
    public void updateChicken(@PathVariable String id, @RequestBody chicken chicken) {
        chicken.setId(id);
        chickenService.updateChicken(chicken);
    }

    @PutMapping("/{id}/Sold")
    public void updateChickenSold(@PathVariable String id, @RequestBody LocalDate dateSold) {
        chicken chicken = chickenService.getChickenById(id);
        if (chicken != null) {
            chicken.setDateSold(dateSold);
            chickenService.updateChicken(chicken);
        }
    }

    @DeleteMapping("/{id}")
    public void removeChicken(@PathVariable String id) {
        chicken chicken = chickenService.getChickenById(id);
        if (chicken != null) {
            chickenService.removeChicken(chicken);
        }
    }
    @GetMapping("/{id}/feeding-schedule")
    public void displayFeedingSchedule(@PathVariable String id, @RequestParam int days) {
        String result = chickenService.displayFeedingSchedule(id, days);
        ResponseEntity.ok(result);
    }

    @GetMapping("/total-required-feed")
    public void displayTotalRequiredFeed(@RequestParam int day) {
        String result = chickenService.displayTotalRequiredFeed(day);
        ResponseEntity.ok(result);
    }

}
