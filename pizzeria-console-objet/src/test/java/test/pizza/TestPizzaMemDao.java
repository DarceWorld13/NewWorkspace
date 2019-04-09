package test.pizza;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Dao.PizzaDao;
import Dao.PizzamemDao;
import fr.pizzeria.model.Pizza.Categorie;
import fr.pizzeria.model.Pizza.Pizza;

public class TestPizzaMemDao {

	private static final  Logger LOG = LoggerFactory.getLogger(TestPizzaMemDao.class); 
	private PizzaDao dao; 
	
	@Before
	public void init() {
			this.dao = new PizzamemDao(); 
	}
	
	//test la methode findAllpizzas
	@Test
	public void  testFindAllPizza() {
		
		Pizza[] actual = dao.findAllPizzas();
		//Pizza[] expected = new Pizza[20];
		
		Assert.assertEquals(9, actual.length);;
		
	}
	
	//test de methode savenewPizza
	@Test
	public void  testSaveNewPizza() {
		
		
		/*
		 * étant donné ....
		 *  
		 * lorsque....
		 * alors....
		 *  
		 *  
		 *  */
		LOG.info("étant donné, une instance de pizzamemeDAO");
		
		Pizza nvpizza = new Pizza("TES", "testeAjout", 12.65, Categorie.AVEC_VIANDE);
		
		LOG.info("lorsqu'on ajoute une pizza dans le tableau des pizzas");
		
		dao.saveNewPizza(nvpizza);
		
		LOG.info("on compare le contenu des deux tableaux");
		
		Pizza[] actuel = dao.findAllPizzas(); 
		
		Pizza[] expected = {
		
		 new Pizza(0, "PEP", "pépéronni", 12.5, Categorie.AVEC_VIANDE),
		 new Pizza(1, "MAR", "magherita", 14.00, Categorie.SANS_VIANDE),
		 new Pizza(2, "REI", "reine", 11.5, Categorie.AVEC_VIANDE),
		 new Pizza(3, "FRO", "4 fromages", 12.00, Categorie.SANS_VIANDE),
		 new Pizza(4, "CAN", "cannibale", 10.5, Categorie.AVEC_VIANDE), 
		 new Pizza(5, "SAV", "savoyarde", 15.5, Categorie.AVEC_VIANDE),
		 new Pizza(6, "ORI", "orientale", 14.00, Categorie.AVEC_VIANDE),
		 new Pizza(7, "IND", "indienne", 12.3, Categorie.AVEC_VIANDE), 
		 new Pizza(8, "TES", "testeAjout", 12.65, Categorie.AVEC_VIANDE)
		
		}; 
		
		Assert.assertArrayEquals(expected, actuel);
		
	}
	
	//la méthode UpdatePizza
	@Test
	public void TestupdatePizza() {
		
		Pizza updated = new Pizza(1, "TES", "testUpdate", 14.5, Categorie.SANS_VIANDE);
		
		dao.updatePizza("MAR", updated );
		
		Pizza[] actuel = dao.findAllPizzas(); 
		
		
		boolean tesTrouve = false;
		
		for(int i= 0; i<actuel.length; i++) {
			
			if(actuel[i] != null) {
				if (actuel[i].getCode().equals("MAR")) {
					Assert.fail("MAR pr");
				} 
				if (actuel[i].getCode().equals("TES")) {
					tesTrouve = true; 
				}
				
			}
			
			
		}

		Assert.assertTrue(tesTrouve);
		
	}
	
	//la méthode supprimer
	@Test
	public void TestSupprimer() {
		
		dao.deletePizza("SAV");
		
		Pizza[] actuelle = dao.findAllPizzas(); 
		
		boolean pizzaSuprime = false; 
		
for(int i= 0; i<actuelle.length; i++) {
			
			if(actuelle[i] != null) {
				if (actuelle[i].getCode().equals("SAV")) {
					Assert.fail("MAR pr");
				} 
				
			}	
			
		}
		Assert.assertFalse(pizzaSuprime);
		
	}
	
	
	
	

}
