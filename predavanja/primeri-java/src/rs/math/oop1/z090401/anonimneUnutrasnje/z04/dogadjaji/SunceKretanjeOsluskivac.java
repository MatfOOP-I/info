package rs.math.oop1.z090401.anonimneUnutrasnje.z04.dogadjaji;

import java.util.EventListener;

/**
 * ugovor izmedju izvora dogadjaja i objekata koji osluskuju
 */
public interface SunceKretanjeOsluskivac extends EventListener {
   /**
    * Poyiva se kada bude ispaljen dogadjaj da je sunce izaslo/zaslo
    */
   public void sunceSePomerilo(SunceKretanjeDogadjaj e);
}

