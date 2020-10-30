package tn.enig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.enig.dao.IMagasinDao;
import tn.enig.dao.IProduitDao;
import tn.enig.model.Magasin;
import tn.enig.model.Produit;

@Controller
public class AppTest {
	

	@Autowired
	IProduitDao daop ;
	
	@Autowired
	IMagasinDao daom;
	
	public void setDaop(IProduitDao daop) {
		this.daop = daop;
	}
	
	public void setDaom(IMagasinDao daom) {
		this.daom = daom;
	}
	
	//listemag hiya l bch tetktab fl url
	@GetMapping("/listemag")
	public String get1(Model m) {
		List<Magasin> liste1=daom.findAll();
						//liste hiya l bch n7ottouha fl jsp
		m.addAttribute("liste",liste1);
		return "listemag"; //listemag esm l page 
	}
	
	
	@GetMapping("/magasin/{id}")
		//Pathvariable hiya tari9a l 3mlna biha l 'acce ml jsp 
		// "id": hathi fl jsp 
	public String get2(Model m , @PathVariable("id") int id) {
		List<Produit> liste = daop.getAllProduitByCat(id);
	//	List<Produit> liste = daop.findAll();
		System.out.println(liste);
		m.addAttribute("liste",liste);
		return "produits";
	}
	
	@GetMapping("/ajoutProduit")
	public String get3(Model m) {
		Produit p = new Produit();
		List<Magasin> listemg= daom.findAll();
		m.addAttribute("p",p);
		m.addAttribute("listemg",listemg);
		return "ajoutp";
	}
	@PostMapping("/saveProduit")
	public String get4(Model m, @ModelAttribute("p") Produit p) {
		daop.save(p);
		return "redirect:/listemag";
	}
	
	@GetMapping("/deletp/{id}")
	public String get5(Model m, @PathVariable("id") int id) {
		daop.delete(id);
		return "redirect:/listemag";
	}
	
	

}
