package com.souleima.biscuits.controllers;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.souleima.biscuits.entities.Biscuit;
import com.souleima.biscuits.service.BiscuitService;
@Controller
public class BiscuitController {
@Autowired
BiscuitService biscuitService;
@RequestMapping("/showCreate")
public String showCreate1()
{
	return "createBiscuit";
}

@RequestMapping("/saveBiscuit")
public String saveBiscuit(@ModelAttribute("biscuit") Biscuit biscuit,ModelMap modelMap) 
{
	 Biscuit saveBiscuit = biscuitService.saveBiscuit(biscuit);
	 String msg ="biscuit enregistré avec Id "+saveBiscuit.getIdBiscuit();
	 modelMap.addAttribute("msg", msg);
	return "createBiscuit";
}
@RequestMapping("/ListeBiscuits")
public String listeBiscuits(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
Page<Biscuit> prods = biscuitService.getAllBiscuitsParPage(page, size);
modelMap.addAttribute("biscuits", prods);
 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeBiscuits";
}
@RequestMapping("/supprimerBiscuit")
public String supprimerBiscuit(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
biscuitService.deleteBiscuitById(id);
Page<Biscuit> prods = biscuitService.getAllBiscuitsParPage(page, size);
modelMap.addAttribute("biscuits", prods);
modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeBiscuits";
}

@RequestMapping("/modifierBiscuit")
public String editerBiscuit(@RequestParam("id") Long id,ModelMap modelMap)
{
Biscuit p= biscuitService.getBiscuit(id);
modelMap.addAttribute("biscuit", p);
return "editerBiscuit";
}
@RequestMapping("/updateBiscuit")
public String updateBiscuit(@ModelAttribute("biscuit") Biscuit biscuit,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
{
//conversion de la date 
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 biscuit.setDateSortir(dateCreation);
 
 biscuitService.updateBiscuit(biscuit);
 List<Biscuit> prods = biscuitService.getAllBiscuits();
 modelMap.addAttribute("biscuits", prods);
return "listeBiscuits";
}

}