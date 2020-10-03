package p15;
//: c15:PrintMembersDoclet.java
// Doclet that prints out all members of the class.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.sun.javadoc.*;

public class PrintMembersDoclet {
  public static boolean start(RootDoc root) {
    ClassDoc[] classes = root.classes();
    processClasses(classes);
    return true;
  }
  private static void processClasses(ClassDoc[] classes) {
    for(int i = 0; i < classes.length; i++) {
      processOneClass(classes[i]);
    }
  }
  private static void processOneClass(ClassDoc cls) {
    FieldDoc[] fd = cls.fields();
    for(int i = 0; i < fd.length; i++)
      processDocElement(fd[i]);
    ConstructorDoc[] cons = cls.constructors();
    for(int i = 0; i < cons.length; i++)
      processDocElement(cons[i]);
    MethodDoc[] md = cls.methods();
    for(int i = 0; i < md.length; i++)
      processDocElement(md[i]);
  }
  private static void processDocElement(Doc dc) {
    MemberDoc md = (MemberDoc)dc;
    System.out.print(md.modifiers());
    System.out.print(" " + md.name());
    if(md.isMethod())
      System.out.println("()");
    else if(md.isConstructor())
      System.out.println();
  }
} ///:~
