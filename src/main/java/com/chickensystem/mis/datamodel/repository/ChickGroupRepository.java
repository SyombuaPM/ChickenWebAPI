package com.chickensystem.mis.datamodel.repository;

import java.util.List;

import com.chickensystem.mis.datamodel.ChickGroup;

public interface ChickGroupRepository {
    void addChickGroup(ChickGroup _chickGroup);
    void removeChickGroup(ChickGroup _chickGroup);
    ChickGroup getChickGroup(String id);
    void updateChickGroup(ChickGroup chickGroup);
    List<ChickGroup> getAllChickGroups();

}
