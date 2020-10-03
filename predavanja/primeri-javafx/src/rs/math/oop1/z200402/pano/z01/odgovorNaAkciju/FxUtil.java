package rs.math.oop1.z200402.pano.z01.odgovorNaAkciju;

import java.util.function.Consumer;

public class FxUtil {
   public static <T> T build(T node, Consumer<T> initializer) {
      initializer.accept(node);
      return node;
   }
}
