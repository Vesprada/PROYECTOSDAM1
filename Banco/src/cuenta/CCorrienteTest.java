package cuenta;

import static org.junit.Assert.*;

import org.junit.Test;

//carlos esto va bien??
public class CCorrienteTest {
	
	@Test
	public void testCapitalTotal() {
				
		double resultat=CCorriente.imprimirCapitalTotal();
		
		double esperat=5000.0;
		
		assertEquals(esperat, resultat, 0.1);
	}
	
	@Test
	public void testMitjana() {
				
		double resultat=mainCcorriente.mitjana();
		
		double esperat=1000;
		
		assertEquals(esperat, resultat, 0.1);
	}
	
}