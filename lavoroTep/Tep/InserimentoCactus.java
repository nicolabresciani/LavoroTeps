import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics;
public class InserimentoCactus extends Thread
{
    private int numero;
    private int x;
    private int attesa;
    BufferedImage img_cactus;
    Gioco main;
    private boolean movimento;
    private ArrayList<CreazioneCactus> cactus;
    Random rand;
    private final int maxVel = 5;
    public InserimentoCactus(BufferedImage image, int numero, int attesa, Gioco main){
        this.img_cactus=image;
        this.attesa=attesa;
        this.numero=numero;
        this.main=main;
        cactus = new ArrayList();
        rand = new  Random();
    }
    @Override
    public void run(){
        movimento = true;
        while(movimento){
            aggiorna();
                cactus.add(new CreazioneCactus(img_cactus, 50,115,1600,195,1,main));
                
                try
            {
                Thread.sleep(attesa);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
            
        }
    }
    public void disegna(Graphics g){
         for(int i=0;i<cactus.size();i++){
             CreazioneCactus temp = cactus.get(i);
             temp.disegna(g);
         }
    }
    private void aggiorna(){
        //si muove
        x--;
    }
    public ArrayList getCactus(){
        return cactus;
    }
}
