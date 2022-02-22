package Tic_Tac_Toc;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.util.Random;
 
@SuppressWarnings("serial")
public class Diseño extends JFrame {
    
	private  JPanel  panel,       panel2,  panel3;
	private  JLabel  titulo,      bCerrar,  anuncio;
	private static JLabel  dX,          dO;
    private static boolean jugador1;
    private static  JButton[] botones= null;
  
    public Diseño() {
    	dandoleForma();
    	etiquetas();
		crearBotones();
		diseño_X();
		  diseño_O();
	}
   
    public void dandoleForma() {
		
		Image imagen= new ImageIcon(getClass().getResource("/imagenes/triqui1.png")).getImage();
		this.setIconImage(imagen);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,500,500);
		panel.setBackground(Color.white);
		this.getContentPane().add(panel);
		
		panel2= new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0,0,500,42);
		panel2.setBackground(Color.white);
		panel.add(panel2);
		
		panel3= new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(80,80,290,290);
		panel3.setBackground(Color.gray);
		panel.add(panel3);
		
		bCerrar= new JLabel();
		bCerrar.setText("X");
		bCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		bCerrar.setFont(new Font("arial,",Font.ROMAN_BASELINE,24));
		bCerrar.setBounds(0,0,40,40);
		bCerrar.setBackground(Color.white);
		bCerrar.setOpaque(true);
		panel2.add(bCerrar);
	}
	
	public void etiquetas() {
		
		titulo= new JLabel();
		titulo.setText("Tic-Tac-Toe");
		titulo.setFont(new Font("arial",Font.ROMAN_BASELINE,30));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setVerticalAlignment(SwingConstants.CENTER);
		titulo.setBounds(160,40,170,35);
		titulo.setBackground(Color.orange);
		titulo.setOpaque(true);
		panel.add(titulo);
		
		anuncio= new JLabel();
		anuncio.setText("HORA DE JUGAR");
		anuncio.setBounds(80,400,300,40);
		anuncio.setFont(new Font("Forte", 15,20));
		anuncio.setBackground(new Color(45,164,215));
		anuncio.setForeground(Color.ORANGE);
		anuncio.setHorizontalAlignment(JLabel.CENTER);
		anuncio.setOpaque(true);
		panel.add(anuncio);
		primerTurno();
	}

    public  boolean primerTurno() {
    	Random random= new Random();
        	
    	if(random.nextInt(2)== 0) {
			  jugador1= true;
			    anuncio.setText("INICIA	<<X>>");
		} else {
                 jugador1=false;
                   anuncio.setText("INICIA <<O>>");     
		}
    	
    	return jugador1;
    }
	
	public void crearBotones() {
	    	
		panel3.setLayout(new GridLayout(3,3,10,10));
		botones= new JButton[9];
		for(int i=0; i<botones.length; i++) {
			 botones[i]= new JButton();
			   botones[i].setBackground(Color.white);
			     botones[i].setFont(new Font("arial",Font.BOLD,60));
			       botones[i].setOpaque(true);
			       panel3.add(botones[i]);    
		}
	}
	
	public JLabel diseño_X() {
		
		dX= new JLabel();
		dX.setText("X");
        dX.setBounds(20,20,60,60);
        dX.setHorizontalAlignment(SwingConstants.CENTER);
        dX.setVerticalAlignment(SwingConstants.CENTER);
		dX.setFont(new Font("ar cena",Font.CENTER_BASELINE,66));
		dX.setForeground(Color.yellow);
		return dX;
	}
	
	public  JLabel diseño_O() {
		dO= new JLabel();
		dO.setText("O");
		dO.setBounds(20,20,60,60);
		dO.setHorizontalAlignment(SwingConstants.CENTER);
		dO.setVerticalAlignment(SwingConstants.CENTER);
		dO.setFont(new Font("ar cena",Font.CENTER_BASELINE,66));
		dO.setForeground(Color.red);
		return dO;
	}
    
	public JPanel getPanel2() {
		return this.panel2;
	}
	public JLabel getLabel() {
		return this.bCerrar;
	}	
	public static JButton[] getBotones() {
		return botones;
	}
	public JLabel getAnuncio() {
		return this.anuncio;
	}
}
