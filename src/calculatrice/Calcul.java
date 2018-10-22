package calculatrice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Calcul {
	
	protected String expression;
	protected double result;
	protected ArrayList<String> listNb = new ArrayList<>();
	protected ArrayList<String> listOperator = new ArrayList<>();

	public Calcul (String str) {
		this.expression = str;
	}
	
	public double calculer(String str) {
		
		String chaineDecoupe [] = str.split(" ",-2);
		
		for(int i=0; i < chaineDecoupe.length; i++) {
				
			System.out.println("decoupe " + i + " egale " + chaineDecoupe[i]);
			
			if (chaineDecoupe[i].equals("+") || chaineDecoupe[i].equals("-") || chaineDecoupe[i].equals("*") ||chaineDecoupe[i].equals("/") ) {	
				listOperator.add(chaineDecoupe[i]);
			} else {				
				listNb.add(chaineDecoupe[i]);
			}
		}
		
		for(int n = 0; n < listNb.size(); n++){
				
				//addition
				if (n < listOperator.size() && listOperator.get(n).equals("+")) {
												
						if(n == 0) {	
							System.out.println(Double.parseDouble(listNb.get(n)) + Double.parseDouble(listNb.get(n+1)));
							this.result = Double.parseDouble(listNb.get(n)) + Double.parseDouble(listNb.get(n+1));
						} else {
							this.result = result + Double.parseDouble(listNb.get(n+1));
						}
						
				} else if (n < listOperator.size() && listOperator.get(n).equals("-")) {
						
					if(n == 0) {	
						System.out.println(Double.parseDouble(listNb.get(n)) - Double.parseDouble(listNb.get(n+1)));
						this.result = Double.parseDouble(listNb.get(n)) - Double.parseDouble(listNb.get(n+1));
					} else {
						this.result = result - Double.parseDouble(listNb.get(n+1));
					}
					
				} else if (n < listOperator.size() && listOperator.get(n).equals("*")) {
					
					if(n == 0) {	
						System.out.println(Double.parseDouble(listNb.get(n)) * Double.parseDouble(listNb.get(n+1)));
						this.result = Double.parseDouble(listNb.get(n)) * Double.parseDouble(listNb.get(n+1));
					} else {
						this.result = result * Double.parseDouble(listNb.get(n+1));
					}
					
				} else if (n < listOperator.size() && listOperator.get(n).equals("/")) {
					if(n == 0) {	
						System.out.println(Double.parseDouble(listNb.get(n)) / Double.parseDouble(listNb.get(n+1)));
						if(listNb.get(n+1).equals("0")) {
							this.result = Double.parseDouble(null);
						}
						
						this.result = Double.parseDouble(listNb.get(n)) / Double.parseDouble(listNb.get(n+1));
						
					} else {
						this.result = result / Double.parseDouble(listNb.get(n+1));
					}
				}
					
											
				System.out.println(result);
				}
			
		return result;
	}
	
	public String erase (String str) {
		
		String chaineDecoupe [] = str.split(" ",-2);
		
		if(chaineDecoupe.length == 1) {
			
			char [] lettre = str.toCharArray();			
			lettre = Arrays.copyOf(lettre, lettre.length-1);			
			String s = new String(lettre);			
			return s;
			
		} else {
			chaineDecoupe = Arrays.copyOf(chaineDecoupe, chaineDecoupe.length-1);			
			String s = String.join(" ", chaineDecoupe);				
			return s;
		}	 
	}
}

