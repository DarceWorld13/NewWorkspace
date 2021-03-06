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
import menuService.SupprimerPizzaService;

public class TestDeletePizza {
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void executeUC() throws StockageException {

		// création du mock

		PizzaDao dao = Mockito.mock(PizzaDao.class);

		// définition du comportement du mock

		Mockito.when(dao.findAllPizzas()).thenReturn(new Pizza[] {
				new Pizza (0, "PEP", "peperonni", 12.5, Categorie.AVEC_VIANDE), 
				new Pizza (1, "SAV", "savoyarde", 13.6, Categorie.AVEC_VIANDE), 
				new Pizza (2, "IND", "indienne", 13.4, Categorie.AVEC_VIANDE), 
		});

		// on simule une saisie de l'utilisateur

		systemInMock.provideLines("SAV");
		
		//

		SupprimerPizzaService ajout = new SupprimerPizzaService();

		ajout.executeUC(new java.util.Scanner(System.in), dao);

		// vérifier que la méthode deletepizza du mock a été invoquée

		Mockito.verify(dao).deletePizza("SAV");

	}
	

}
