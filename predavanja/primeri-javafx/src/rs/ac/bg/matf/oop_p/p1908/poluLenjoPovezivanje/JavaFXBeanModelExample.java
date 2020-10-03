package rs.ac.bg.matf.oop_p.p1908.poluLenjoPovezivanje;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;

public class JavaFXBeanModelExample
{
  private static final int DEFAULT_I = -1;
  private IntegerProperty i;

  private static final String DEFAULT_STR = "Hello";
  private StringProperty str;

  private static Color DEFAULT_COLOR = Color.BLACK;
  private ObjectProperty<Color> color;

  public final int getI()
  {
    if (i != null)
      return i.get();
    else
      return DEFAULT_I;
  }

  public final void setI(int i)
  {
    if ((this.i != null) || (i != DEFAULT_I))
      iProperty().set(i);
  }

  public IntegerProperty iProperty()
  {
    if (i == null)
      i = new SimpleIntegerProperty(this, "i", DEFAULT_I);
    return i;
  }

  public final String getStr()
  {
    if (str != null)
      return str.get();
    else
      return DEFAULT_STR;
  }

  public final void setStr(String str)
  {
    if ((this.str != null) || !(str.equals(DEFAULT_STR)))
      strProperty().set(str);
  }

  public StringProperty strProperty()
  {
    if (str == null)
      str = new SimpleStringProperty(this, "str", DEFAULT_STR);
    return str;
  }

  public final Color getColor()
  {
    if (color != null)
      return color.get();
    else
      return DEFAULT_COLOR;
  }

  public final void setColor(Color c)
  {
    if ((this.color != null) || !(color.equals(DEFAULT_COLOR)))
      colorProperty().set(c);
  }

  public ObjectProperty<Color> colorProperty()
  {
    if (color == null)
      color = new SimpleObjectProperty<Color>(this, "color", DEFAULT_COLOR);
    return color;
  }
}