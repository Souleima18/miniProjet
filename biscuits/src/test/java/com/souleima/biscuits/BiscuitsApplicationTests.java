package com.souleima.biscuits;

import java.util.Date;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.souleima.biscuits.entities.Biscuit;
import com.souleima.biscuits.repos.BiscuitRepository;
import com.souleima.biscuits.service.BiscuitService;
@SpringBootTest
class BiscuitsApplicationTests {
@Autowired
private BiscuitRepository biscuitRepository;
@Autowired
private BiscuitService biscuitService;

@Test
public void testCreateBiscuit() {
Biscuit prod = new Biscuit("chocotom",1100.00,new Date(),"chocolat");
biscuitRepository.save(prod);
}
@Test
public void testFindBiscuit()
{
Biscuit p = biscuitRepository.findById(1L).get(); 
System.out.println(p);
}
@Test
public void testUpdateBiscuit()
{
Biscuit p = biscuitRepository.findById(1L).get();
p.setPrixBiscuit(1000.0);
biscuitRepository.save(p);
}
@Test
public void testDeleteBiscuit()
{
	biscuitRepository.deleteById(1L);;
}
 
@Test
public void testListerTousBiscuits()
{
List<Biscuit> prods = biscuitRepository.findAll();
for (Biscuit p : prods)
{
System.out.println(p);
}
}
@Test
public void testFindByNomBiscuitContains()
{
Page<Biscuit> prods = biscuitService.getAllBiscuitsParPage(0,2);
System.out.println(prods.getSize());
System.out.println(prods.getTotalElements());
System.out.println(prods.getTotalPages());
prods.getContent().forEach(p -> {System.out.println(p.toString());
 });
/*ou bien
for (Produit p : prods)
{
System.out.println(p);
} */
}
}