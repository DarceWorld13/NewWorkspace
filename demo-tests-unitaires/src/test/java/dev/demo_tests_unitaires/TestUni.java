package dev.demo_tests_unitaires;

import org.junit.Assert;
import org.junit.Test;






public class TestUni {
		//lorsque ça échoue 
		
		@Test
		public void testAdditionner() {
			
			int toto = 12; 
			
			StringUtils calcul = new StringUtils(); 
			int d = calcul.additionner(13, 4); 
			
			Assert.assertEquals(d, toto);
			
		}
		//lorsque le test passe
		@Test
		public void testSoustraire() {
			
			
			StringUtils soutaire = new StringUtils(); 
			int c = soutaire.soustraire(8, 10); 
			
			Assert.assertEquals(c, 2);
		}
		

}