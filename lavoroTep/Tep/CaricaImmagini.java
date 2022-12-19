import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class CaricaImmagini
{
     BufferedImage image;
    public  BufferedImage caricaImmagine(String posizione){try
        {
            // posizione dell'immagine
        image = ImageIO.read(getClass().getResource(posizione));
        }
        catch (IOException ioe){
            System.out.println("immagine alla posizione :"+posizione+" caricata correttamente");
            ioe.printStackTrace();
        }
        return image;
    }
}
