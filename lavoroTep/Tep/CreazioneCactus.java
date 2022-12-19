import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Rectangle;
public class CreazioneCactus extends Thread
{
    private int x,y;
    private int larghezza;
    private int altezza;
    private int velocita;
    BufferedImage img_cactus;
    private boolean attivo;
    private Gioco main;
    
    public CreazioneCactus(BufferedImage image, int larghezza, int altezza, int x, int y, int velocita, Gioco main){
        this.x=x;
        this.y=y;
        this.altezza=altezza;
        this.larghezza=larghezza;
        this.img_cactus=image;
        attivo=true;
        this.main=main;
        this.velocita=velocita;
        this.start();
    }
    @Override
    public void run(){
        attivo=true;
        while(attivo){
            aggiorna();
            try
            {
                Thread.sleep(1);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
    private void aggiorna(){
        x-=velocita;
    }
    public void disegna(Graphics g){
        g.drawImage(img_cactus,x,y,larghezza,altezza,main);
    }
    public int  getX(){
        return x;
    }
     public int  getLarghezza(){
        return larghezza;
    }
     public int  getAltezza(){
        return altezza;
    }
     public int  getY(){
        return y;
    }
    public Rectangle getBordi(){
        return new Rectangle(x, y, larghezza, altezza);
    }
}