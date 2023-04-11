package com.souleima.biscuits.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.souleima.biscuits.entities.Biscuit;
import com.souleima.biscuits.repos.BiscuitRepository;
@Service
public class BiscuitServiceImpl implements BiscuitService {
@Autowired
BiscuitRepository biscuitRepository;
@Override
public Biscuit saveBiscuit(Biscuit p) {
return biscuitRepository.save(p);
}
@Override
public Biscuit updateBiscuit(Biscuit p) {
return biscuitRepository.save(p);
}
@Override
public void deleteBiscuit(Biscuit p) {
	biscuitRepository.delete(p);
}
 @Override
public void deleteBiscuitById(Long id) {
	 biscuitRepository.deleteById(id);
}
@Override
public Biscuit getBiscuit(Long id) {
return biscuitRepository.findById(id).get();
}
@Override
public List<Biscuit> getAllBiscuits() {
return biscuitRepository.findAll();
}
@Override
public Page<Biscuit> getAllBiscuitsParPage(int page, int size) {
return biscuitRepository.findAll(PageRequest.of(page, size));
}

}