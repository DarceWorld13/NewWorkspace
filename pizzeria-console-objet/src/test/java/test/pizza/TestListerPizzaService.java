package test.pizza;

import org.junit.Test;
import org.mockito.Mockito;

import Dao.PizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza.Pizza;
import menuService.ListerPizzasService;

public class TestListerPizzaService {

	/*@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	*/
	
	@Test
	public void executeUC() throws StockageException {
		
		// création du mock

		PizzaDao dao1 = Mockito.mock(PizzaDao.class); 
		
		
		//determination du comportement
		
		Mockito.when(dao1.findAllPizzas()).thenReturn(new Pizza[20]); 

		//invocation de la méthode 
		
		ListerPizzasService list = new ListerPizzasService(); 
		list.executeUC(new java.util.Scanner(System.in), dao1);
		
		//verification que mockito a été invoqué
		Mockito.verify(dao1).findAllPizzas();
				
				
		
		
	}
	
	
}
