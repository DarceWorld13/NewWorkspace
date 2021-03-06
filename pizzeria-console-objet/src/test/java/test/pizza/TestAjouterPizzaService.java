package test.pizza;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import Dao.PizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza.Categorie;
import fr.pizzeria.model.Pizza.Pizza;
import menuService.AjouterPizzaService;

public class TestAjouterPizzaService {

	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	
	@Test
	public void executeUC() throws StockageException {
		
		// création du mock

		PizzaDao dao = Mockito.mock(PizzaDao.class); 
		
		// définition du comportement du mock
		
		Pizza nllePizza = new Pizza("VEG", "vegetarienne", 13.5, Categorie.SANS_VIANDE);
		
		// on simule une saisie de l'utilisateur
		
		systemInMock.provideLines("VEG", "vegetarienne", "13.5", "2");
		
		//à revoir --->
		AjouterPizzaService ajout = new AjouterPizzaService();

		ajout.executeUC(new java.util.Scanner(System.in), dao);
		
		
		// vérifier que la méthode saveNewPizza du mock a été invoquée

		Mockito.verify(dao).saveNewPizza(nllePizza);
			
	
				
		
		
	}


	
}
