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
import menuService.ModifierPizzaService;

public class TestUpdatePizza {

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

		Pizza nllePizza = new Pizza("VEG", "vegetarienne", 13.5, Categorie.SANS_VIANDE);

		// on simule une saisie de l'utilisateur

		systemInMock.provideLines("PEP", "VEG", "vegetarienne", "13.5", "2");

		ModifierPizzaService ajout = new ModifierPizzaService();

		ajout.executeUC(new java.util.Scanner(System.in), dao);

		// vérifier que la méthode updatePizza du mock a été invoquée

		Mockito.verify(dao).updatePizza("PEP", nllePizza);

	}

}
