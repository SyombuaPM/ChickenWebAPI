package com.chickensystem.mis.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chickensystem.mis.datamodel.EggProduction;
import com.chickensystem.mis.datamodel.repository.EggProductionRepository;

@Service

public class EggProductionService {

    private final EggProductionRepository eggProductionRepository;

    //@Autowired
    public EggProductionService(EggProductionRepository eggProductionRepository) {
        this.eggProductionRepository = eggProductionRepository;
    }

    public void addEggProduction(EggProduction eggProduction) {
        eggProductionRepository.addEggProduction(eggProduction);
    }

    public List<EggProduction> getEggProductions() {
        return eggProductionRepository.getAllEggProductions();
    }

    public void removeEggProduction(EggProduction eggProduction) {
        eggProductionRepository.removeEggProduction(eggProduction);
    }

    public EggProduction getEggProductionByDate(LocalDate date) {
        return eggProductionRepository.getEggProduction(date);
    }

    public void updateEggProduction(EggProduction eggProduction) {
        eggProductionRepository.updateEggProduction(eggProduction);
    }

}
