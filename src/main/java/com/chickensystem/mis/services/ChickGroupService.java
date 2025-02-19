package com.chickensystem.mis.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chickensystem.mis.datamodel.ChickGroup;
import com.chickensystem.mis.datamodel.repository.ChickGroupRepository;
import com.chickensystem.mis.datamodel.repository.inmemory.inmemoryChickGroupRepository;

@Service

public class ChickGroupService {
    private final ChickGroupRepository chickGroupRepository;

    //@Autowired
    public ChickGroupService(ChickGroupRepository chickGroupRepository) {
        this.chickGroupRepository = chickGroupRepository;
    }

    public void addChickGroup(ChickGroup chickGroup) {
        chickGroupRepository.addChickGroup(chickGroup);
    }

    public List<ChickGroup> getChickGroups() {
        return chickGroupRepository.getAllChickGroups();
    }

    public void removeChickGroup(ChickGroup chickGroup) {
        chickGroupRepository.removeChickGroup(chickGroup);
    }

    public ChickGroup getChickGroupById(String groupId) {
        ChickGroup chickGroup = chickGroupRepository.getChickGroup(groupId);
        if (chickGroup != null && chickGroup.getGroupId().equals(groupId)) {
            return chickGroup;
        }
        return null;
    }
    public void updateChickGroup(ChickGroup chickGroup) {
        chickGroupRepository.updateChickGroup(chickGroup);
    }
    private final inmemoryChickGroupRepository inmemoryRepo = new inmemoryChickGroupRepository();
    
    public String displayTotalRequiredFeed(String groupId, int day) {
        return inmemoryRepo.displayTotalRequiredFeed(groupId, day);
    }

}
