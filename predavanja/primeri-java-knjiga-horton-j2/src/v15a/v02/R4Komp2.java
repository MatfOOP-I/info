package v15a.v02;
import java.awt.*;
 
  public class R4Komp2 extends java.applet.Applet
      implements Runnable {
 
      CardLayout karta = new CardLayout();
      Button[] dugme = new Button[4];
      int tekuca = 0;
      Thread dosadni;

     public void start() {
         if (dosadni == null) {
  
          dosadni = new Thread(this);
          dosadni.start();
         }
     }

     public void stop() {
         dosadni = null;
     }

     public void init() {
         dugme[0] = new Button("Pera");
         dugme[1] = new Button("Zika");
         dugme[2] = new Button("Mika");
         dugme[3] = new Button("Tika");
         
         setLayout(karta);
         for (int i = 0; i < 4; i++)
             add("Karta " + i, dugme[i]);
         add("Karta 1", new Label("Proba"));
     }
 
     public void run() {
         Thread thisThread = Thread.currentThread();
         while (dosadni == thisThread) {
             karta.show(this, "Karta " + tekuca);
             tekuca++;
             if (tekuca > 3)
                 tekuca = 0;
             repaint();
             try {
                Thread.sleep(5000);
             } catch (InterruptedException e) { }
         }
     }
 }
  
 

  
