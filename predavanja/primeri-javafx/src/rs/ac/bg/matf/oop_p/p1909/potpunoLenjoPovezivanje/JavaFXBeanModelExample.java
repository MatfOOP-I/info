package rs.ac.bg.matf.oop_p.p1909.potpunoLenjoPovezivanje;

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
  private int _i = DEFAULT_I;

  private static final String DEFAULT_STR = "Hello";
  private StringProperty str;
  private String _str = DEFAULT_STR;

  private static Color DEFAULT_COLOR = Color.BLACK;
  private ObjectProperty<Color> color;
  private Color _color = DEFAULT_COLOR;

  public final int getI()
  {
    if (i != null)
      return i.get();
    else
      return _i;
  }

  public final void setI(int i)
  {
    if (this.i != null)
      iProperty().set(i);
    else
      _i = i;
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
      return _str;
  }

  public final void setStr(String str)
  {
    if (this.str != null)
      this.str.set(str);
    else
      _str = str;
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
      return _color;
  }

  public final void setColor(Color c)
  {
    if (this.color != null)
      colorProperty().set(c);
    else
      _color = c;
  }

  public ObjectProperty<Color> colorProperty()
  {
    if (color == null)
      color = new SimpleObjectProperty<Color>(this, "color", DEFAULT_COLOR);
    return color;
  }
}