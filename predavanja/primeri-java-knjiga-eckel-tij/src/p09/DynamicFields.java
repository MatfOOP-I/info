package p09;
//: c09:DynamicFields.java
// A Class that dynamically adds fields to itself.
// Demonstrates exception chaining.
// {ThrowsException}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class DynamicFieldsException extends Exception {}

public class DynamicFields {
  private static Test monitor = new Test();
  private Object[][] fields;
  public DynamicFields(int initialSize) {
    fields = new Object[initialSize][2];
    for(int i = 0; i < initialSize; i++)
      fields[i] = new Object[] { null, null };
  }
  public String toString() {
    StringBuffer result = new StringBuffer();
    for(int i = 0; i < fields.length; i++) {
      result.append(fields[i][0]);
      result.append(": ");
      result.append(fields[i][1]);
      result.append("\n");
    }
    return result.toString();
  }
  private int hasField(String id) {
    for(int i = 0; i < fields.length; i++)
      if(id.equals(fields[i][0]))
        return i;
    return -1;
  }
  private int
  getFieldNumber(String id) throws NoSuchFieldException {
    int fieldNum = hasField(id);
    if(fieldNum == -1)
      throw new NoSuchFieldException();
    return fieldNum;
  }
  private int makeField(String id) {
    for(int i = 0; i < fields.length; i++)
      if(fields[i][0] == null) {
        fields[i][0] = id;
        return i;
      }
    // No empty fields. Add one:
    Object[][]tmp = new Object[fields.length + 1][2];
    for(int i = 0; i < fields.length; i++)
      tmp[i] = fields[i];
    for(int i = fields.length; i < tmp.length; i++)
      tmp[i] = new Object[] { null, null };
    fields = tmp;
    // Reursive call with expanded fields:
    return makeField(id);
  }
  public Object
  getField(String id) throws NoSuchFieldException {
    return fields[getFieldNumber(id)][1];
  }
  public Object setField(String id, Object value)
  throws DynamicFieldsException {
    if(value == null) {
      // Most exceptions don't have a "cause" constructor.
      // In these cases you must use initCause(),
      // available in all Throwable subclasses.
      DynamicFieldsException dfe =
        new DynamicFieldsException();
      dfe.initCause(new NullPointerException());
      throw dfe;
    }
    int fieldNumber = hasField(id);
    if(fieldNumber == -1)
      fieldNumber = makeField(id);
    Object result = null;
    try {
      result = getField(id); // Get old value
    } catch(NoSuchFieldException e) {
      // Use constructor that takes "cause":
      throw new RuntimeException(e);
    }
    fields[fieldNumber][1] = value;
    return result;
  }
  public static void main(String[] args) {
    DynamicFields df = new DynamicFields(3);
    System.out.println(df);
    try {
      df.setField("d", "A value for d");
      df.setField("number", new Integer(47));
      df.setField("number2", new Integer(48));
      System.out.println(df);
      df.setField("d", "A new value for d");
      df.setField("number3", new Integer(11));
      System.out.println(df);
      System.out.println(df.getField("d"));
      Object field = df.getField("a3"); // Exception
    } catch(NoSuchFieldException e) {
      throw new RuntimeException(e);
    } catch(DynamicFieldsException e) {
      throw new RuntimeException(e);
    }
    monitor.expect(new String[] {
      "null: null",
      "null: null",
      "null: null",
      "",
      "d: A value for d",
      "number: 47",
      "number2: 48",
      "",
      "d: A new value for d",
      "number: 47",
      "number2: 48",
      "number3: 11",
      "",
      "A value for d",
      "Exception in thread \"main\" " +
      "java.lang.RuntimeException: " +
      "java.lang.NoSuchFieldException",
      "\tat DynamicFields.main(DynamicFields.java:98)",
      "Caused by: java.lang.NoSuchFieldException",
      "\tat DynamicFields.getFieldNumber(" +
      "DynamicFields.java:37)",
      "\tat DynamicFields.getField(DynamicFields.java:58)",
      "\tat DynamicFields.main(DynamicFields.java:96)"
    });
  }
} ///:~