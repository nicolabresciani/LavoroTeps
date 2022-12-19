public class Collisione
{
   public static boolean controlloCollisione(Dihno dihno, CreazioneCactus cactus){
       if(dihno.getBordi().intersects(cactus.getBordi())){
           return true;    
       }
       return false;
   }
}
