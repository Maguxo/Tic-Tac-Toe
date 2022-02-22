package Tic_Tac_Toc;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Accionar extends Diseño  {
	
	private int xMouse, yMouse;
	private boolean jugador1;
	Random random= new Random();
	private JButton[] botones;
	
	public Accionar() {
			this.botones= getBotones();
			jugador1= primerTurno();
		    cerrarVentana();
		    direccionarVentana();
		    arrastrar();
		    jugar();
	}
	
	public void cerrarVentana() {
		
		MouseListener raton= new MouseListener() {	
			@Override
			  public void mouseClicked(MouseEvent e) {
			    System.exit(0);
			}
			      @Override
			        public void mousePressed(MouseEvent e) {}
			          @Override
			            public void mouseReleased(MouseEvent e) {}
			              @Override
			                public void mouseEntered(MouseEvent e) {
				          getLabel().setBackground(new Color(0,162,232));
				        getLabel().setForeground(Color.black);
			            }
			          @Override
			        public void mouseExited(MouseEvent e) {
				  getLabel().setBackground(Color.white);
				getLabel().setForeground(Color.blue);
			  }
		    };
		  getLabel().addMouseListener(raton);
	    }
	
	public void direccionarVentana() {
		
		MouseListener movimiento= new MouseListener() {	
			@Override
			  public void mouseClicked(MouseEvent e) {}
			    @Override
			      public void mousePressed(MouseEvent e) {
				    yMouse= getX();
				      xMouse= getY();
			          }
			        @Override
			      public void mouseReleased(MouseEvent e) {}
			    @Override
			  public void mouseEntered(MouseEvent e) {}
			@Override
	      public void mouseExited(MouseEvent e) {}
		};
	  }
	
	public void arrastrar() {
		
		MouseMotionListener arrastrar= new MouseMotionListener() {
			@Override
			  public void mouseDragged(MouseEvent e) {
			    setLocation(e.getXOnScreen()- xMouse, e.getYOnScreen()- yMouse);
			      }
			    @Override
			  public void mouseMoved(MouseEvent e) {} 
		    };	
		  getPanel2().addMouseMotionListener(arrastrar);
	    }
	
	private void jugar() {
	
        MouseListener escucha= new MouseListener() {
        	@Override
        	  public void mouseClicked(MouseEvent e) {}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		  for(int i=0; i< 9; i++) {
        	          if(e.getSource()== botones[i]) {
        	        	  if(jugador1) {
        	        		  if(botones[i].getText() == "") {
        	    			       botones[i].setText(diseño_X().getText());
        	    			         botones[i].setForeground(Color.yellow);
        	    			           jugador1= false;
        	    			             getAnuncio().setText("turno <<O>>");
        	    			               tricky();
        	                               } 
        	        	                 }else {
            	        	           if(botones[i].getText() == "") {
            	        		     botones[i].setText(diseño_O().getText());
            	        		   botones[i].setForeground(Color.red);
            	                 jugador1= true;
            	               getAnuncio().setText("turno <<X>>");
            	             tricky();
               	    }
        	      }  
        	    }
              }
        	}
        	@Override
        	public void mouseReleased(MouseEvent e) {}
        	@Override
        	public void mouseEntered(MouseEvent e) {}
        	@Override
        	public void mouseExited(MouseEvent e) {}
        };
              for(int i=0; i<9; i++) {
                botones[i].addMouseListener(escucha); 
      }
	}
	
	public void tricky() {
			
			if(botones[0].getText() == "O" && botones[1].getText() == "O" && botones[2].getText() == "O"){
			     ganaO(0,1,2);
			     }
			       if(botones[3].getText() == "O" && botones[4].getText() == "O" && botones[5].getText() == "O"){
				       ganaO(3,4,5);   
			           }
			             if(botones[6].getText() == "O" && botones[7].getText() == "O" && botones[8].getText() == "O"){
					          ganaO(6,7,8);
			                  }	
			                    if(botones[0].getText() == "O" && botones[3].getText() == "O" && botones[6].getText() == "O"){
					                 ganaO(0,3,6);
			                         }
			                           if(botones[1].getText() == "O" && botones[4].getText() == "O" && botones[7].getText() == "O"){
							                ganaO(1,4,7);
					                        }
			                                  if(botones[2].getText() == "O" && botones[5].getText() == "O" && botones[8].getText() == "O"){
			 					                   ganaO(2,5,8);
			 			                           }
			                          		       if(botones[0].getText() == "X" && botones[1].getText() == "X" && botones[2].getText() == "X"){
			                   			          ganaX(0,1,2);
			                   			        }
			                   			      if(botones[3].getText() == "X" && botones[4].getText() == "X" && botones[5].getText() == "X"){
			                   				ganaX(3,4,5);   
			                   			    }
			                   			  if(botones[6].getText() == "X" && botones[7].getText() == "X" && botones[8].getText() == "X"){
			                   			ganaX(6,7,8);
			                   			}	
			                          if(botones[0].getText() == "X" && botones[3].getText() == "X" && botones[6].getText() == "X"){
			                        ganaX(0,3,6);
			                        }
			                      if(botones[1].getText() == "X" && botones[4].getText() == "X" && botones[7].getText() == "X"){
			                    ganaX(1,4,7);
			                    }
	                          if(botones[2].getText() == "X" && botones[5].getText() == "X" && botones[8].getText() == "X"){
			                ganaX(2,5,8);
			                }   	
	                      if(botones[0].getText() == "O" && botones[4].getText() == "O" && botones[8].getText() == "O"){
	  			        ganaX(0,4,8);
	  			        }
	                  if(botones[2].getText() == "O" && botones[4].getText() == "O" && botones[6].getText() == "O"){
				    ganaX(2,4,6);
				    }
	              if(botones[0].getText() == "X" && botones[4].getText() == "X" && botones[8].getText() == "X"){
			    ganaX(0,4,8);
			    }
	          if(botones[2].getText() == "X" && botones[4].getText() == "X" && botones[6].getText() == "X"){
		    ganaX(2,4,6);
		    }
	}
	
    public void   ganaO(int M,int A,int O) {
    	
    	botones[M].setBackground(new Color(0,255,64));
    	botones[A].setBackground(new Color(0,255,64));
    	botones[O].setBackground(new Color(0,255,64));
    	for(int i=0; i<9; i++) {
    		  botones[i].setEnabled(false);
    	      }
    	        getAnuncio().setText("GANA <<O>>");
    }
    public void ganaX(int M, int A ,int O) {
    	
    	botones[M].setBackground(new Color(0,255,64));
    	botones[A].setBackground(new Color(0,255,64));
    	botones[O].setBackground(new Color(0,255,64));
    	for(int i=0; i<9; i++) {
  		      botones[i].setEnabled(false);
  	          }
    	        getAnuncio().setText("GANA <<X>>");
    }
}
