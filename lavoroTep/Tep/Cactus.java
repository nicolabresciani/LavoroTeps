import java.awt.image.BufferedImage;
import java.awt.Graphics;
public class Cactus extends Thread
{
    private int x,y;
    private int larghezza;
    private int altezza;
    private int velocita;
    private boolean attivo;
    BufferedImage img_catcus;
    private Gioco main;
    
    public Cactus(BufferedImage image, int larghezza, int altezza, int x, int y, Gioco main){
        this.x=x;
        this.y=y;
        this.altezza=altezza;
        this.larghezza=larghezza;
        this.img_catcus=image;
        attivo=true;
        this.main=main;
    }
    /*@Override
    public void run(){
        attivo = true;
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
        //si muove
        x--;
    }*/
    public boolean getAttivo(){
        return attivo;
    }
    public void setAttivo(Boolean valore){
        this.attivo=valore;
    }
    public void disegna(Graphics g){
        g.drawImage(img_catcus,x,y,larghezza,altezza,null);
    }
    public void setX(int valore){
        this.x = valore;
    }
    public void setY(int valore){
        this.y = valore;
    }
    public void setAltezza(int valore){
        this.altezza = valore;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getLarghezza(){
        return larghezza;
    }
    public int getAltezza(){
        return altezza;
    }
    public void setLarghezza(int valore){
        this.larghezza = valore;
    }
}
