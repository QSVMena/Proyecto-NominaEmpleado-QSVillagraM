package ui;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.Parser;

public class Validacion {

	public static double ValidateDouble(String mensaje, String error, Scanner scan) {
		
		double num=0;
		boolean Valor= true;
		
		do {
			try {
				System.out.print(mensaje);
				num = scan.nextDouble();
				Valor = false;
			}
			catch(Exception e) {
				Valor= true;
				System.out.print(error);
			}
			
		}while(Valor);
		
		return num;
	}
	
	public static String ValidateString(String mensaje, String error, Scanner scan) {
		String letra =" ";
		boolean Valor= true;
		
		do {
			
			try {
				System.out.print(mensaje);
				letra = scan.nextLine();
				Valor = false;
			}
			catch(Exception e) {
				Valor= true;
				System.out.print(error);
			}
			
		}while(Valor);
		
		return letra;
	}
	
	public static int ValidateInt(String mensaje, String error, Scanner scan, int inicial, int Final) {
		int num =0;
		boolean Valor= true;
		
		do {
			try {
				System.out.print(mensaje);
				String Value=scan.nextLine();
				num= Integer.parseInt(Value);
				if(num >= inicial && num <= Final ) {
					Valor = false;
				}else {
					System.out.print(error);
					Valor = true;
				}
			}
			catch(Exception e) {
				Valor= true;
				System.out.print(error);
			}
		}while(Valor);
		
		return num;
	}
}
