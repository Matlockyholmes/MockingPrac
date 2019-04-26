package be.vdab.service;

import be.vdab.repositories.KostRepository;
import be.vdab.repositories.OpbrengstRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WinstServiceTest {
    @Mock
    private OpbrengstRepository opbrengstRepository;
    @Mock
    private KostRepository kostRepository;
    private WinstService winstService;

    @Before
    public void before(){
        when(opbrengstRepository.findTotaleOpbrengst()).thenReturn(BigDecimal.valueOf(200));
        when(kostRepository.findTotaleKost()).thenReturn(BigDecimal.valueOf(50));
        winstService = new WinstService(opbrengstRepository, kostRepository);
    }

    @Test
    public void winstTest(){
        assertEquals(0, BigDecimal.valueOf(150).compareTo(winstService.getWinst()));
        verify(opbrengstRepository).findTotaleOpbrengst();
        verify(kostRepository).findTotaleKost();
    }

}