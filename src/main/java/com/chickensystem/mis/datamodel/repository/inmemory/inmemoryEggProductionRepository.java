package com.chickensystem.mis.datamodel.repository.inmemory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chickensystem.mis.datamodel.EggProduction;
import com.chickensystem.mis.datamodel.repository.EggProductionRepository;
@Repository
public class inmemoryEggProductionRepository implements EggProductionRepository {
    private final List<EggProduction> eggProductions = new ArrayList<>();
    
   @Override
    public void addEggProduction(EggProduction eggProduction) {
        eggProductions.add(eggProduction);
    }

    @Override
    public List<EggProduction> getAllEggProductions() {
        return new ArrayList<>(eggProductions);
    }

    @Override
    public void removeEggProduction(EggProduction eggProduction) {
        eggProductions.remove(eggProduction);
    }

    @Override
    public EggProduction getEggProduction(LocalDate date) {
        for (EggProduction eggProduction : eggProductions) {
            if (eggProduction.getDate().equals(date)) {
                return eggProduction;
            }
        }
        return null;
    }

    @Override
    public void updateEggProduction(EggProduction eggProduction) {
        for (int i = 0; i < eggProductions.size(); i++) {
            if (eggProductions.get(i).getDate().equals(eggProduction.getDate())) {
                eggProductions.set(i, eggProduction);
                return;
            }
        }
    }
}
