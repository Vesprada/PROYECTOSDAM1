package cuenta;
/**
* Programa sobre la getión de un banco.
* 
*
* @author  Carlos Buigues Gómez
* @version 1.0
* @since   15/02/2017 
*/
import java.util.*;

public class CCorriente {
	public static Scanner lector=new Scanner (System.in); //Importem el scanner 
	
	/**
	 * @param capitalTotal -> L'utilitzarem per anar sumat el capital del banc 
	 */
	public static double capitalTotal=5000; //Suma del capital de tots els compters
	
	/**
	 * VARIABLES QUE ANEM A UTILITZAR 
	 * @param numCompte numero de comtpe del client 
	 * @param nomClient nom del client del banc 
	 * @param saldo saldo del compte 
	 * @param interesAnual interes que tindrà cada compte 
	 * @param saldoNegatiu utilitzarem aquest per a quan un saldo es quede amb nuemeros rojos
	 * @param numTransacions contara el que fem sobre cada compte 
	 */
	private int numCompte;
	private String nomClient;
	private double saldo=0;
	private double interesAnual=2.5;
	private boolean saldoNegatiu=false;
	private int numTransaccions=0;
	
	/**
	 * Constructor amb els dos primers parametres
	*/
	public CCorriente(int numCompte, String nomClient){
		
		this.numCompte=numCompte;
		this.nomClient=nomClient;
		
		capitalTotal+=saldo;
	}
	
	/**
	 * Constructor amb els primers 4 parametres
	 */
	public CCorriente(int numCompte, String nomClient,  double saldo, double interesAnual){
		
		this.numCompte=numCompte;
		this.nomClient=nomClient;
		this.saldo=saldo;
		this.interesAnual=interesAnual;
		
		capitalTotal+=saldo;		
	}
	

	//=================================  GETTERS I SETTERS  ================================// 
		
		/** 
		 * @param getNumCompte Es el getter de numCompte 
		 */
		public int getNumCompte(){
			return this.numCompte;
		}
		
		/**
		 * @param setNumCompte Es el setter de numCompte
		 */
		
		public void setNumCompte(int nouNum){
			this.numCompte=nouNum;
		}
		
		//===================================================================================
		
		/** 
		 * @param getNomClient Es el getter de nomClient 
		 */
		
		public String getNomClient(){
			return this.nomClient;
		}
		
		/**
		 * @param setNomClient Es el setter de nomClient
		 */
		
		public void setNomClient(String nouNomClient){
			this.nomClient=nouNomClient;
		}
		
		//===================================================================================
		
		/** 
		 * @param getSaldo Es el getter de saldo 
		 */
		
		public double getSaldo(){
			return this.saldo;
		}
		
		/**
		 * @param setSaldo Es el setter de saldo
		 */
		
		public void setSaldo(double nouSaldo){
			this.saldo=nouSaldo;
		}
		
		//===================================================================================
		
		/** 
		 * @param getInteresAnual Es el getter de interesAnual 
		 */
		
		public double getInteresAnual(){
			return this.interesAnual;
		}
		
		/**
		 * @param setInteresAnual Es el setter de interesAnual
		 */
		
		public void setInteresAnual(double nouInteresAnual){
			this.interesAnual=nouInteresAnual;
		}
		
		//===================================================================================
		
		/** 
		 * @param getSaldoNegatiu Es el getter de saldoNegatiu 
		 */
		
		public boolean getSaldoNegatiu(){
			return this.saldoNegatiu;
		}
		
		/**
		 * @param setSaldoNegatiu Es el setter de saldoNegatiu
		 */
		
		public void setSaldoNegatiu(boolean nouSaldoNegatiu){
			this.saldoNegatiu=nouSaldoNegatiu;
		}
		
		//===================================================================================
		
		/** 
		 * @param getNumTransaccions Es el getter de numTransaccions 
		 */
		
		public int getNumTransaccions(){
			return this.numTransaccions;
		}
		
		/**
		 * @param setNumTransaccions Es el setter de numTransaccions
		 */
		
		public void setNumTransaccions(int nouNumTransaccions){
			this.numTransaccions=nouNumTransaccions;
		}
		//===================================================================================
	
	//=====================================  TO STRING  ===================================// 
		
		/** 
		 * @param toString ho utilitzarem per a imprimir cada compte
		 */
		public String toString(){
			return "================" +
				   "\nNumCompte: \t" + this.numCompte+
				   "\nNomClient: \t" + this.nomClient+
				   "\nSaldo:     \t" + this.saldo+
				   "\nInteresAnual: \t" + this.interesAnual+
				   "\nSaldoNegatiu: \t" + this.saldoNegatiu+
				   "\nNumTransaccions: " + this.numTransaccions ;
		
		}//Tanquem to String
		
	//=====================================  INGRESAR DINERS  ===================================// 
		
		/**
		 * @param ingresar El utilitzarem per a ingresar diners en els comptes
		 */
		
		public void ingresar (){
			this.numTransaccions++;
			
			System.out.print("Molt diners vols ingresar?: ");
			double ingres=lector.nextDouble();
				this.saldo=this.saldo+ingres;
					if (saldo>5000){
						this.interesAnual=3.5;
					}//Tanquem el if
					
				capitalTotal=capitalTotal+ingres;
				
				System.out.println("Num transacció " + this.numTransaccions + " Numero de compter " + this.numCompte + " Ingres de:" +ingres+" €");
			
			
		}//Tanquem ingresar
		
	//=====================================  RETIRAR DINERS  ===================================// 
		
		/**
		 * @param retirar El utilitzarem per a retirar diners en els comptes
		 */
		
		public void retirar (){
			this.numTransaccions++;
			
			System.out.print("Molt diners vols retirar?: ");
			double reintegro=lector.nextDouble();
				
					if ((this.saldo-reintegro)>(-50)){		//Pregunem si els diners que volem traure son majors al saldo +50
						this.saldo=this.saldo-reintegro; //Restem el saldo 
						capitalTotal=capitalTotal-reintegro; //Restem els diners al capital total
					}
					else System.out.println("Operació no permitida!! Saldo INSUFICIENT!");	//Si el saldo es queda < que -50
					
					if (this.saldo < 0) this.saldoNegatiu=true;		//Si el saldo es negatiu posem @saldoNegatiu = true 
					
					if (this.saldo < 5000) this.interesAnual=2.5;		//Si baixem de 5000€ baixem el interes 
					
					System.out.println("Num transacció " + this.numTransaccions + " Numero de compter " + this.numCompte + " Diners retirats:" +reintegro+" €");
		}//Tanquem retirar
		
	//=====================================  Imprimir  ===================================//
		
		/**
		 * @param imprimirSaldo El utilitzarem per a imprimir el saldo dels clients 
		 */
		
		public void imprimirSaldo(){
			this.numTransaccions++;
				System.out.println("Num transacció: "+this.numTransaccions+
								   " sobre el compte: "+this.getNumCompte()+
								   " i el saldo es: "+this.saldo);
				
			
		}//Tanquem  imprimir saldo 
		
		/**
		 * @param imprimirInteresAnual El utilitzarem per a imprimir el interes anual dels clients
		 */
		
		public void imprimirInteresAnual(){
			this.numTransaccions++;
			System.out.println("Num transacció: "+this.numTransaccions+
					   " sobre el compte: "+this.getNumCompte()+
					   " i el saldo es: "+this.saldo+
					   " i el interes anual es: "+this.interesAnual);
			
		}//Tanquem imprimirInteresAnual
		
		/**
		 * @param imprimirCapitalTotal El utilitzarem per a imprimir el capital total del banc
		 */
		
		public static double imprimirCapitalTotal(){
			//System.out.println("El capital total és: "+capitalTotal);
			return capitalTotal;
		}//Tanquem imprimir CapitalTotal
		
	
}//Tanquem la class