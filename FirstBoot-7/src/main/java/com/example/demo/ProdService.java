package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Service
public class ProdService {
	
	private EntityManagerFactory entityManagerFactory;

	
	public ProdService() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
		
		
	}
	
	// Iniezione dell'EntityManager
    @PersistenceContext
    private EntityManager entityManager;
    
 // Metodo per creare un nuovo utente e salvarlo nel database
    @Transactional
    public void createMobile(String nome, String marca, int prezzo, String url) {
        // Crea un nuovo oggetto Dip con i parametri forniti
        mobili m1 = new mobili();
        m1.setNome(nome);
       m1.setMarca(marca);
       m1.setPrezzo(prezzo);
       m1.setUrl(url);
        
        // Salva l'oggetto Dip nel contesto di persistenza (lo rende gestito)
        entityManager.persist(m1);
    }
    
    @Transactional
    public ArrayList<mobili> getAllProd() {
        
    	List <mobili> lista = entityManager.createQuery("SELECT m FROM mobili m", mobili.class).getResultList();
    	
    	// cast da lista a arraylist
    	ArrayList <mobili> listaP =  (ArrayList<mobili>) lista;
    	
    	return listaP;
    }
    
    @Transactional
    public void updatePrezzo(String nome, int prezzo) {
    	
  ArrayList <mobili> listaP = getAllProd();
    	
    	for (mobili p1: listaP) {
    		
    		if (p1.getNome().equalsIgnoreCase(nome)) {
    			
    			p1.setPrezzo(prezzo);
    			entityManager.persist(p1);
    		}
    	}
    }
    	  @Transactional
  	    public void deleteProd(String nome) {
  	    	
  	    	
  	    	
  	    	// Uso del parametro posizionale ?1 per impostare il valore del nome
  	        entityManager.createQuery("DELETE FROM mobili m WHERE m.nome = ?1")
  	                     .setParameter(1, nome)  // Setta il parametro posizionale ?1
  	                     .executeUpdate();

  	        
  	    
    	
    	
    }
    	  
    	  @Transactional
    	  public void updateUrl(String nome, String Nuovourl) {
    		  
    		  ArrayList <mobili> listaP = getAllProd();
    		  
    		  for (mobili m1: listaP) {
    			  
    			  if (m1.nome.equals(nome)) {
    				  
    				  m1.setUrl(Nuovourl);
    				  entityManager.persist(m1);
    			  }
    		  }
    		  
    		  
    		  
    	  }



}
