package calculatrice;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class Calculatrice extends JFrame {
	
	//Création conteneur principal
	private JPanel container = new JPanel();
	
	//transforme le resultat "double" en String
	private static String resultString = "0"; 
	
	//booléens 
	private boolean eraseDisplay = false;
	private boolean pointDisplay = false;
	
	//Création d'une JLabel pour l'affichage des nombres et du résultat des opérations
	private JLabel displayResult = new JLabel(resultString);
	
	//Création d'un JPanel pour les boutons du clavier qui sera le conteneur d'une GridLayout
	private JPanel clavier = new JPanel();
	private GridLayout buttons = new GridLayout(5,4);
	
	//Déclaration des boutons
	private JButton button0 = new JButton("0");
	private JButton button1 = new JButton ("1");
	private JButton button2 = new JButton ("2");
	private JButton button3 = new JButton ("3");
	private JButton button4 = new JButton ("4");	
	private JButton button5 = new JButton ("5");
	private JButton button6 = new JButton ("6");	
	private JButton button7 = new JButton ("7");
	private JButton button8 = new JButton ("8");
	private JButton button9 = new JButton ("9");
	private JButton buttonC = new JButton ("C");	
	private JButton buttonPlus = new JButton ("+");	
	private JButton buttonMoins = new JButton ("-");
	private JButton buttonMultiplie = new JButton ("*");	
	private JButton buttonDivise = new JButton ("/");
	private JButton buttonPoint = new JButton(".");
	private JButton buttonEgal = new JButton("=");
	
	public Calculatrice() {
	
		this.setTitle("Calculatrice");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container.setBackground(Color.WHITE);	
		container.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
		container.setLayout(new BorderLayout());//Création et insertion d'un BorderLayout dans Container
		
		displayResult.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));// ajoute une bordure au JLabel
		
		//Définition d'une police d'écriture		
	    Font police = new Font("Tahoma", Font.PLAIN, 16);
	    displayResult.setFont(police); //On l'applique au JLabel
	    displayResult.setHorizontalAlignment(JLabel.RIGHT); //alignement du texte à droite
	    displayResult.setPreferredSize(new Dimension(200,40));//dimension du JLabel
	    
	    //Création d'espaces de 6px entre les boutons
		buttons.setHgap(6); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
		buttons.setVgap(6); //Cinq pixels d'espace entre les lignes (V comme Vertical)

		//Insertion du GridLayout buttons dans le JPanel clavier
		clavier.setLayout(buttons);
		//Ajout de marges vides dans le JPanel clavier pour faire plus joli !
		clavier.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
		
		buttonC.setForeground(Color.RED);//Coloration en rouge du bouton Correction
			
		//Ajout des boutons 
		clavier.add(button1);
		clavier.add(button2);
		clavier.add(button3);
		clavier.add(buttonPlus);
		clavier.add(button4);
		clavier.add(button5);
		clavier.add(button6);
		clavier.add(buttonMoins);
		clavier.add(button7);
		clavier.add(button8);
		clavier.add(button9);
		clavier.add(buttonMultiplie);
		clavier.add(button0);
		clavier.add(buttonPoint);
		clavier.add(buttonEgal);
		clavier.add(buttonDivise);
		clavier.add(buttonC);
		
		//Insertion des JPanel dans le JPanel principal container
	    container.add(displayResult, BorderLayout.NORTH);
	    container.add(clavier, BorderLayout.CENTER);
	    
	    //ecoute les boutons
	    button0.addActionListener(new BoutonListener(button0));
	    button1.addActionListener(new BoutonListener(button1));
	    button2.addActionListener(new BoutonListener(button2));
	    button3.addActionListener(new BoutonListener(button3));
	    button4.addActionListener(new BoutonListener(button4));
	    button5.addActionListener(new BoutonListener(button5));
	    button6.addActionListener(new BoutonListener(button6));
	    button7.addActionListener(new BoutonListener(button7));
	    button8.addActionListener(new BoutonListener(button8));
	    button9.addActionListener(new BoutonListener(button9));
	    buttonPoint.addActionListener(new PointListener());
	    buttonC.addActionListener(new CorrectionListener());
	    buttonPlus.addActionListener(new OperatorListener(buttonPlus));
	    buttonMoins.addActionListener(new OperatorListener(buttonMoins));
	    buttonMultiplie.addActionListener(new OperatorListener(buttonMultiplie));
	    buttonDivise.addActionListener(new OperatorListener(buttonDivise));
	    buttonEgal.addActionListener(new EgalListener());
	    
		this.setContentPane(container);
		this.setVisible(true);
	}
	
	//gère les actions selon le type de boutons, sauf les touches opérations, virgule et égale
	public class BoutonListener implements ActionListener {
		
		private JButton btn;
		
		//Constructeur
		public BoutonListener (JButton btn) {
		
			this.btn = btn;		
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(resultString != "0" && pointDisplay == false ) {
							
				if(resultString.indexOf("+") > 0 || resultString.indexOf("-") > 0 || resultString.indexOf("*") > 0 || resultString.indexOf("/") > 0) {
					int newResult = Integer.parseInt(btn.getText());
					String newResultString = Integer.toString((int)(newResult));
					displayResult.setText(resultString + newResultString);
					resultString = displayResult.getText();				
				} else {
					int newResult = Integer.parseInt(btn.getText());
					String newResultString = Integer.toString((int)(newResult));
					displayResult.setText(resultString + newResultString);
					resultString = displayResult.getText();					
					//result = Double.parseDouble(resultString);
				}
							
			} else if (pointDisplay == true) {
				int newResult = Integer.parseInt(btn.getText());
				String newResultString = Integer.toString((int)(newResult));
				displayResult.setText(resultString + newResultString);
				resultString = displayResult.getText();
				pointDisplay = false;				
			} else if (resultString == "0"){						
			//result =  Double.parseDouble (btn.getText()); 
				
			System.out.println("resultString au départ : " + resultString);
			displayResult.setText(btn.getText());
			resultString = displayResult.getText();
			
			}			
		}		
	}
	
	//gére l'affichage de la virgule pour les nombres décimaux
	public class PointListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//vérifie si le dernier caractère affiché n'est pas une virgule
			if (resultString.indexOf(".", resultString.length()-1) != resultString.length()-1) {
				pointDisplay = true;
				displayResult.setText(resultString + "." );
				resultString = displayResult.getText();		
			}	
		}	
	}
	
	//gére la touche correction
	public class CorrectionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(resultString != "0" && resultString.length() > 1 && eraseDisplay == false) {
				
				Calcul calcul = new Calcul(displayResult.getText());			
				displayResult.setText(calcul.erase(displayResult.getText()));
				resultString = displayResult.getText();				
				
			} else if (resultString.length() == 1 || resultString == "0" || eraseDisplay == true) {			
			resultString = "0";	
			displayResult.setText(resultString);
			resultString = displayResult.getText();
			eraseDisplay = false;
			}
		}
	}
	
	// gère les opérateurs
	public class OperatorListener implements ActionListener {
		
		private JButton btn;
		
		public OperatorListener(JButton btn) {
			this.btn = btn;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(btn.getText() == "+") {
				displayResult.setText(resultString + " + " );
				resultString = displayResult.getText();	
				
			} else if (btn.getText() == "-") {
				displayResult.setText(resultString + " - " );
				resultString = displayResult.getText();	
				
			} else if (btn.getText() == "*") {
				displayResult.setText(resultString + " * " );
				resultString = displayResult.getText();	
				
			} else if (btn.getText() == "/") {
				displayResult.setText(resultString + " / " );
				resultString = displayResult.getText();					
			}		
		}		
	}
	
	//gère l'affichage du résultat des opérations
	public class EgalListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Calcul calcul = new Calcul(displayResult.getText());			
			displayResult.setText(Double.toString(calcul.calculer(displayResult.getText())));
			resultString = displayResult.getText();
			eraseDisplay = true;
		}		
	}	
}
	

