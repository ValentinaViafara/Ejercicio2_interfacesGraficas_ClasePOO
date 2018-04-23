/*
PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package Ejercicio1;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;



//la clase board extiende panel que es la función encargada de dibujar la interfaz y implementa la función MouseListener que tiene como función conectar con el movimiento del mouse 

public class Board extends JPanel implements MouseListener{

    
    //Crea un objeto color que fue importado previamente que en este caso se usara para los colores d elas figuras
    private Color color;
    
    //Crea un objeto url de una clase importada previamente que la utilizaremos para especificar la dirección del audio que usamos de sonido
    private URL url = null;
     
    
    //crar imagen para dibujar
    
    private Image imagen;
    private Image piso;
    private Image muñeco;
    private int movMuñeco=0;
    
    
    
    public Board() {
        this.color=Color.RED;
        
        //Dice que adiciona un  mouse el cual ontendra su acción
        this.addMouseListener(this);
    }

    
    @Override
    
    
    //crear figuras 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        dibujarEscenario(g);
    }

    
    
    private void dibujarEscenario(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; //graficar la interfaz 
        g2d.setColor(this.color);
        //the first two paramehis.ters are the position (x,y) and after comes the width and the height
        g2d.fillOval(0, 0, 30, 30);
        g2d.drawOval(0, 50, 30, 30);
               
        g2d.fillRect(50, 0, 30, 30); 
        g2d.drawRect(50, 50, 30, 30);
        
        g2d.drawString("Puntaje del Juego", 100, 100);
        
        this.imagen=this.loadImage("blue_background.png");
        this.piso=this.loadImage("ground_loop.png");
          int x=0;
       
        
        for(int i=0; i<500; i++){
       
             g2d.drawImage(imagen, i*22,0, this);
             g2d.drawImage(piso, i*68,800 , this);
             g2d.drawImage(piso, i*68,800+ 68, this);
             g2d.drawImage(piso, i*68, 800+68*2, this);
             g2d.drawImage(piso, i*68, 800+68*3, this);
        }
       
        
        
    }
    
      public Rectangle getBounds() {
        return new Rectangle(0, 0, 500, 500);
      }
    
    //Se llama cuando se oprime y se suelta un botón en el mouse
    @Override
    public void mouseClicked(MouseEvent e) {
         Point mp = e.getPoint();
         if(getBounds().contains(mp)){
             try {
                 url = new URL("file:balli.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             
             if(this.color==Color.RED)
                 
              this.color=Color.CYAN;
             else
                 this.color=Color.RED;
             repaint();
         }  
    }

    //Es llamado cuando se oprime un botón en el Mouse.
    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    // Ocurre cuando se suelta un botón en el Mouse.
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    //Ocurre cuando el cursor entra dentro de los límites del componente.
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    //Ocurre cuando el cursor sale dentro de los límites del componente.
    @Override
    public void mouseExited(MouseEvent e) {

    }

    
    
    //para cargar imagen    
    protected Image loadImage(String name){
        ImageIcon ii= new ImageIcon(name);
        Image image=ii.getImage();
        return image;
        
    }
    
    
    //Inner class que captira los eventos del teclado
    
    
    private class EventosTeclado extends KeyAdapter{
        
        
        public void KeyReleased(KeyEvent e){
            int 
        }
        
    }
    
}