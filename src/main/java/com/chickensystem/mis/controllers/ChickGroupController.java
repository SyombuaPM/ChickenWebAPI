package com.chickensystem.mis.controllers;

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

import com.chickensystem.mis.datamodel.ChickGroup;
import com.chickensystem.mis.services.ChickGroupService;

@RestController
@RequestMapping("/ChickGroups")

public class ChickGroupController {
     private final ChickGroupService chickGroupService;

    //@Autowired
    public ChickGroupController(ChickGroupService chickGroupService) {
        this.chickGroupService = chickGroupService;
    }

    @PostMapping
    public void addChickGroup(@RequestBody ChickGroup chickGroup) {
        chickGroupService.addChickGroup(chickGroup);
    }

    @GetMapping
    public List<ChickGroup> getChickGroups() {
        return chickGroupService.getChickGroups();
    }

    @GetMapping("/{groupId}")
    public ChickGroup getChickGroupById(@PathVariable String groupId) {
        return chickGroupService.getChickGroupById(groupId);
    }

    @PutMapping("/{groupId}")
    public void updateChickGroup(@PathVariable String groupId, @RequestBody ChickGroup chickGroup) {
        chickGroup.setGroupId(groupId);;
        chickGroupService.updateChickGroup(chickGroup);
    }

    @DeleteMapping("/{groupId}")
    public void removeChickGroup(@PathVariable String groupId) {
        ChickGroup chickGroup = chickGroupService.getChickGroupById(groupId);
        if (chickGroup != null) {
            chickGroupService.removeChickGroup(chickGroup);
        }
    }
     @GetMapping("/{groupId}/total-required-feed")
    public void displayTotalRequiredFeed(@PathVariable String groupId, @RequestParam int day) {
        String result = chickGroupService.displayTotalRequiredFeed(groupId, day);
        ResponseEntity.ok(result);
    }

}
