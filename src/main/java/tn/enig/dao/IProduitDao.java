package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.enig.model.Produit;

@Repository
public interface IProduitDao extends JpaRepository<Produit, Integer> {
	public List<Produit> findByDescription(String s);
	// req non nomme
	@Query("select p from Produit p where p.mg.id=?1") //=:x and aaa=:y twalli hathi req nomme
	public List<Produit> getAllProduitByCat(int id); //(@Param(int x))
	

}
