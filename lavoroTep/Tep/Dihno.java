import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Dihno extends Thread
{
    private int x,y;
    private boolean movimento;
    private int larghezza;
    private int altezza;
    private final int velocita = 10;
    BufferedImage img_dinho;
    private Gioco main;
    public int vita = 3;
    public Dihno(){}
    public Dihno(BufferedImage image,int x, int y, int larghezza, int altezza,Gioco main){
        this.y=y;
        this.x=x;
        this.larghezza=larghezza;
        this.altezza=altezza;
        this.img_dinho=image;
        this.main=main;
        vita = 3;
    }
     public void disegna(Graphics g){
        g.drawImage(img_dinho,x,y,larghezza,altezza,main);
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
    public void salto(){
        y-=100;
        try
        {
            sleep(500);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
        scendi();
        //System.out.println(y);
    }
    public Rectangle getBordi(){
        return new Rectangle(x, y, larghezza, altezza);
    }
    public void scendi(){
        y=195;
    }

}
