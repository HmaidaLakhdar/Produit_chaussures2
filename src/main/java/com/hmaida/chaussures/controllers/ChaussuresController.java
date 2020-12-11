package com.hmaida.chaussures.controllers;
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
import com.hmaida.chaussures.entities.Chaussures;
import com.hmaida.chaussures.service.ChaussuresService;
@Controller
public class ChaussuresController {
@Autowired
ChaussuresService chaussuresService;
@RequestMapping("/showCreate")
public String showCreate()
{
return "createChaussures";
}
@RequestMapping("/saveChaussures")
public String saveChaussures(@ModelAttribute("chaussures") Chaussures chaussures, @RequestParam("date") String date,
 ModelMap modelMap) throws ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 chaussures.setDateCreation(dateCreation);

 Chaussures saveChaussures = chaussuresService.saveChaussures(chaussures);
String msg ="produit enregistré avec Id "+saveChaussures.getIdChaussures();
modelMap.addAttribute("msg", msg);
return "createChaussures";
}


@RequestMapping("/ListeChaussures")
public String listeChaussures(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
Page<Chaussures> chauss = chaussuresService.getAllChaussuresParPage(page, size);
modelMap.addAttribute("chaussures", chauss);
modelMap.addAttribute("pages", new int[chauss.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeChaussures";
}



@RequestMapping("/supprimerChaussures")
public String supprimerChaussures(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
chaussuresService.deleteChaussuresById(id);
Page<Chaussures> chauss = chaussuresService.getAllChaussuresParPage(page,
size);
modelMap.addAttribute("chaussures", chauss);
modelMap.addAttribute("pages", new int[chauss.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeChaussures";
}



@RequestMapping("/modifierChaussures")
public String editerChaussures(@RequestParam("id") Long id,ModelMap modelMap)
{
Chaussures c= chaussuresService.getChaussures(id);
modelMap.addAttribute("chaussures", c);
return "editerChaussures";
}
@RequestMapping("/updateChaussures")
public String updateChaussures(@ModelAttribute("chaussures") Chaussures chaussures, @RequestParam("date") String date,
		ModelMap modelMap) throws ParseException
		{
		//conversion de la date
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateCreation = dateformat.parse(String.valueOf(date));
		 chaussures.setDateCreation(dateCreation);

		 chaussuresService.updateChaussures(chaussures);
		 List<Chaussures> chauss = chaussuresService.getAllChaussures();
		 modelMap.addAttribute("chaussures", chauss);
		return "listeChaussures";
		}


}