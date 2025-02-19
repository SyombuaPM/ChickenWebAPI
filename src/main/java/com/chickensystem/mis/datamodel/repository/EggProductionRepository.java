package com.chickensystem.mis.datamodel.repository;

import java.time.LocalDate;
import java.util.List;

import com.chickensystem.mis.datamodel.EggProduction;

public interface EggProductionRepository {
    void addEggProduction(EggProduction _eggProduction);
    void removeEggProduction(EggProduction _eggProduction);
    EggProduction getEggProduction(LocalDate date);
    void updateEggProduction(EggProduction eggProduction);
    List<EggProduction> getAllEggProductions();

}
