package com.souleima.biscuits.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.souleima.biscuits.entities.Biscuit;
public interface BiscuitService {
Biscuit saveBiscuit(Biscuit p);
Biscuit updateBiscuit(Biscuit p);
void deleteBiscuit(Biscuit p);
 void deleteBiscuitById(Long id);
Biscuit getBiscuit(Long id);
List<Biscuit> getAllBiscuits();
Page<Biscuit> getAllBiscuitsParPage(int page, int size);
}
