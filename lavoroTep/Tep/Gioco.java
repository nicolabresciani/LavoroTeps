import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.awt.*;

public class Gioco extends Canvas implements Runnable,KeyListener{
    private static final int larghezza = 1600;
    private static final int altezza = 400;
    private static final String nome_gioco = "DINHO";
    BufferedImage pavimento = null;
    BufferedImage dinho = null;
    BufferedImage cactus = null;
    BufferedImage fine = null;
    private boolean gioco_attivo = false;
    private Cactus oggetto_cactus;
    private Dihno oggetto_dino;
    private InserimentoCactus crea_cactus;
    private Color color;
    Font f;
    int punteggio=0;
    
    public Gioco(){
        caricaRisorse();
        iniziaGioco();
    } 
    
    public static void main(String[] args){
        Gioco gioco = new Gioco(); 
        JFrame finestra_gioco = new JFrame(nome_gioco);
        Dimension dimensione_finestra = new Dimension(larghezza, altezza);
        finestra_gioco.setPreferredSize(dimensione_finestra);
        finestra_gioco.setMaximumSize(dimensione_finestra);
        finestra_gioco.setResizable(false);
        finestra_gioco.setLocationRelativeTo(null);
        finestra_gioco.setLocation(150,300); 
        finestra_gioco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        finestra_gioco.add(gioco);
        finestra_gioco.addKeyListener(gioco);
        
        finestra_gioco.pack();
        finestra_gioco.setVisible(true);
        
        Thread thread_gioco = new Thread(gioco);
        thread_gioco.start();
    }
    private void iniziaGioco(){
        oggetto_dino = new Dihno(dinho,50,195,70,100,this);
        oggetto_cactus = new Cactus(cactus,50,115,1600,195, this);
        oggetto_cactus.start();
        crea_cactus=new InserimentoCactus(cactus,2,1500,this);
        crea_cactus.start();
    }
    public void caricaRisorse(){
        CaricaImmagini loader = new CaricaImmagini();
        pavimento = loader.caricaImmagine("/immagine/pavimento.png");
        dinho = loader.caricaImmagine("/immagine/dino.png");
        cactus = loader.caricaImmagine("/immagine/cactus.png");
        //System.out.println("immagini caricate!");
    }
    public void fine(){
        CaricaImmagini loader = new CaricaImmagini();
        fine= loader.caricaImmagine("/immagine/fine.png");
    }
    private void disegna(){
        BufferStrategy buffer = this.getBufferStrategy();
        if(buffer==null){
            createBufferStrategy(2);
            return;
        }
        Graphics g = buffer.getDrawGraphics(); // disegna nell'oggetto canvas
        g.drawImage(pavimento,0,0,larghezza,altezza,this);
        f = new Font("TimesRoman", Font.BOLD, 22);
        g.setFont(f);
        g.setColor(color.green);
        oggetto_cactus.disegna(g);
        oggetto_dino.disegna(g);
        crea_cactus.disegna(g);
        g.drawString("vita: "+oggetto_dino.vita,45,45);
        if(!gioco_attivo){
            f = new Font("TimesRoman", Font.BOLD, 22);
            g.setFont(f);
            g.setColor(color.black);
            g.clearRect(0,0,larghezza,altezza);
            g.setColor(color.red);
            g.drawString("HAI PERSO!!!!!",750,190);
        }
        g.dispose();
        buffer.show();
    }
    private void aggiorna(){
        ArrayList<CreazioneCactus> cactus=crea_cactus.getCactus();
        for(CreazioneCactus i : cactus){//cicla un array di cactus e 'i' è il nostro cactus
            if(Collisione.controlloCollisione(oggetto_dino, i)){
                cactus.remove(i);
                this.oggetto_dino.vita -= 1;
                punteggio-=5;
                //fine();
                break;
            }
            //System.out.println(punteggio);
        }
        if(controllaSconfitta()){
            this.gioco_attivo = false;
            disegna();
        }
        controllaSconfitta();
    }
    private boolean controllaSconfitta(){
        if(oggetto_dino.vita <= 0){
            return true;
        }
        return false;
    }
    @Override
    public void run(){
        gioco_attivo= true;
        while(gioco_attivo){
            aggiorna();
            disegna();
        }
    }
    public int getLarghezza(){
        return larghezza;
    }
    public int getAltezza(){
        return altezza;
    }
    public void keyPressed(KeyEvent e){
        int keycode = e.getKeyCode();
        switch(keycode){
            case KeyEvent.VK_UP:
                oggetto_dino.salto();
                break;
            case KeyEvent.VK_SPACE:
                oggetto_dino.salto();
                break;
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e) {}
   
}
