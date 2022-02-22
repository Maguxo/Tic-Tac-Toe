package Tic_Tac_Toc;

import javax.swing.JFrame;

public class Principal extends  Accionar{

	
	public static void main(String args[]) {
		
	 Principal v1= new Principal();
	 
	    v1.setLayout(null);
	    v1.setUndecorated(true);
		v1.setSize(500,500);
		v1.setVisible(true);
		v1.setResizable(true);
		v1.setTitle("Tic Tac Toc");
		v1.setLocation(800,10);
		v1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
