package be.vdab.service;

import be.vdab.repositories.KostRepository;
import be.vdab.repositories.OpbrengstRepository;

import java.math.BigDecimal;

public class WinstService {
    private final OpbrengstRepository opbrengstRepository;
    private final KostRepository kostRepository;

    //Dependency injection
    public WinstService(OpbrengstRepository opbrengstRepository, KostRepository kostRepository){
        this.opbrengstRepository = opbrengstRepository;
        this.kostRepository = kostRepository;
    }

    public BigDecimal getWinst(){
        return opbrengstRepository.findTotaleOpbrengst().subtract(kostRepository.findTotaleKost());
    }
}
