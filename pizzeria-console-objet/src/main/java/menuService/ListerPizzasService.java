package menuService;

import java.util.Scanner;

import Dao.PizzaDao;
import fr.pizzeria.model.Pizza.Pizza;

public class ListerPizzasService extends MenuService {
	

      
	@Override
	public
	void executeUC (Scanner question, PizzaDao dao) {
		
		System.out.println("liste des pizzas");

		Pizza[] listePizzas = dao.findAllPizzas();
		
		for (int i = 0; i < listePizzas.length; i++) {

			if (listePizzas[i] != null) {
				System.out.println(listePizzas[i].getCode() + "->" + listePizzas[i].getLibelle()
						+ " " + listePizzas[i].getPrix() + listePizzas[i].getCategorie());
			}

		}

		
		
	}
		


}