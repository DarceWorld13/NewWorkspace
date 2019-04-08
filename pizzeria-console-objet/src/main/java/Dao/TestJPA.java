package Dao;

import fr.pizzeria.model.Pizza.Pizza;

public class TestJPA implements PizzaDao {
	
	
	
	//à modifier avec jpa

	@Override
	public Pizza[] findAllPizzas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
