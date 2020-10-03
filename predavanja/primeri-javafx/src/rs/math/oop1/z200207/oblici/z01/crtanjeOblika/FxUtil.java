package rs.math.oop1.z200207.oblici.z01.crtanjeOblika;

import java.util.function.Consumer;

public class FxUtil {
      public static <T> T build(T node, Consumer<T> initializer) {
         initializer.accept(node);
         return node;
   }
}
