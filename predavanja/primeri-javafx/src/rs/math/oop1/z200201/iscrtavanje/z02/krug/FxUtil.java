package rs.math.oop1.z200201.iscrtavanje.z02.krug;

import java.util.function.Consumer;

public class FxUtil {
      public static <T> T build(T node, Consumer<T> initializer) {
         initializer.accept(node);
         return node;
   }
}
