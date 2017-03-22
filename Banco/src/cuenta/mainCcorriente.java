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

public class mainCcorriente {
	public static Scanner lector=new Scanner (System.in);
	public static CCorriente[] comptes=new CCorriente[10];
	
	/**
	 *Imprimim els comptes amb la seua informació 
	 */
	public static void imprimirComptes(){
		/**
		 * Recorreguem l'array per a imprimir cada uno del comptes
		 */
		for(int i=0; i< comptes.length; i++){
			if (comptes[i]!=null)
			System.out.println(comptes[i].toString());			
			
		}//Tanquem el for
	}//Tanca imprimirComptes
	
	/**
	 * Eliminem un compte del array 
	 * Recorrem l'array en busca del numero de compte que li em dit i quan el troba l'iguala a null
	 */
	public static void eliminarComptes(int numCompte){
		
		for (int i = 0; i < comptes.length; i++) {
			if ((comptes[i]!=null) && (comptes[i].getNumCompte()==numCompte)){
				comptes[i]=null;
			}//Tanquem if
		}//Tanquem for
	}//Tanca eliminarComptes
	
	
	/**
	 *@param mitjana -> Calcula la mitjana de tots els comptes bancaris 
	 */
	public static double mitjana(){
		
		//Calcular la mitjana del saldo dels comptes bancaris del array 
		double sumaTotal=0, contador=0;
			for(int i=0; i< comptes.length; i++){
				if (comptes[i]!=null){
					sumaTotal+=comptes[i].getSaldo();	
					contador++;
				
				}//Tanquem el if 				
		}//Tanquem el for
			double total=(sumaTotal/contador);
			return total;
	}//Tanca mitjana
	
	
	/**
	 * Canviem tots els noms dels titulars a majuscules 
	 * Recorrem l'array i amb @toUpperCase canviem totes les minuscules per majuscules dels noms dels clients
	 */
	public static void canviarMayus(){
		
		for (int i = 0; i < comptes.length; i++) {
			if (comptes[i]!=null){
				comptes[i].setNomClient(comptes[i].getNomClient().toUpperCase());
				System.out.println(comptes[i].getNomClient());
			}//Tanquem if
		}//Tanquem for
	}//Tanca canviarMayus
	
	
	/**
	 * Sumem els diners que vulgam a tots client del banc
	 */
	public static void sumaDinersTotsComptes(int num){
		
		for(int i=0; i< comptes.length; i++){
			if (comptes[i]!=null){
				comptes[i].setSaldo(comptes[i].getSaldo()+num);	
			
			}//Tanquem el if 				
		}//Tanquem el for
	}//Tanca sumaDinersTotsComptes
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * Creem 5 usuaris del banc per defecte
		 */
		CCorriente c1=new CCorriente(1001,"Pepe Garcia");
		CCorriente c2=new CCorriente(1002,"Ruben Mulet", 500, 3);
		CCorriente c3=new CCorriente(1003,"Pepe Garcia", 2000, 4);
		CCorriente c4=new CCorriente(1004,"Andres Perez", 1000, 3.5);
		CCorriente c5=new CCorriente(1005,"Sara Peris", 1500, 3.5);
				
		//c1.ingresar();		
		//c1.retirar();
		
		
		//Creeem un arrai de comptes bancaris
		
		
		/*
		 * Asignem de forma explicita els comptes a les diferents posicions del array
		 */
		comptes[0]=c1;
		comptes[1]=c2;
		comptes[2]=c3;
		comptes[3]=c4;
		comptes[4]=c5;
		
	//=====================================     MENU     =========================================
		
		int option=0;
		/**
		 * Entrem en el menu
		 */
		do{
			System.out.println();
			System.out.println("MENÚ PRINCIPAL");
			System.out.println("====================");
			System.out.println("1.-Imprimir els comptes. ");
			System.out.println("2.-Calcular la mitjana del saldo dels comptes bancaris.");
			System.out.println("3.-Eliminar un compte. ");
			System.out.println("4.-Canviar els noms dels titulars dels comptes a majuscules..");
			System.out.println("5.-Regalar 10€ a cada compte.");
			System.out.println("6.-Imprimir capital total.");
			System.out.println("7.-Imprimir interes anual del compte 1.");
			System.out.println("8.-Imprimir saldo del compte 2.");			
			
			System.out.println("0.-Eixir de l'aplicació.");
			System.out.println("====================");
			
			System.out.print("Inserta una opció vàlida: ");
				option=lector.nextInt();
			System.out.println("====================");
				lector.nextLine();
				System.out.println("");
				
			switch(option){
			case 1:
				
				imprimirComptes();
				
				break;
			case 2:		
				/**
				 * Cridem al metodo mitjana e imprimim la mitjana 
				 */
				System.out.println("La mitja dels comptes bancaris és: "+mitjana());
					
				break;
			case 3:			
				
				System.out.print("Dis-me el num de compte que vols eliminar: ");
					int numCompte=lector.nextInt();
					
					eliminarComptes(numCompte);
					
				break;
			case 4:		
				
					canviarMayus();
				
				break;
			case 5:
				
				
				int num;
				System.out.println("Molts diners vols posar a cada compte??");
				num=lector.nextInt();
				
				sumaDinersTotsComptes(num);
								
				break;
			case 6:
				/**
				 * Cridem al metode imprimir capital e imprimim el capital del banc 
				 */
				System.out.println("El capital total és: "+CCorriente.imprimirCapitalTotal());
				break;
			case 7:
				
				c1.imprimirInteresAnual();
				
				break;
			case 8: 
				
				c2.imprimirSaldo();
				
				break;
			case 0:
				System.out.println("Aplicació finalitzada.");
				break;
			default:
				break;
			}
			
		}while (option!=0);
		
	}//Tanquem el main 

}//Tanca TOT