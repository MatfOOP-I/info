/*
 * Created on 2004.4.21
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package v13.v07VisegranaDrveta;

/**
 * @author Ja
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TestRBTree
{
	public static void main(String args[])
	{
		RBTree t = new RBTree(new Comparable()
		{
			public int compare(Object a, Object b)
			{
				return ((String) a).compareTo((String) b);
			}
		});

		t.add("A");
		t.add("B");
		t.add("C");
		t.add("D");
		t.add("E");
		t.add("F");
		t.add("G");
		t.add("H");
		t.add("I");
		t.add("J");
		t.add("K");
		t.add("L");
		t.add("M");
		t.add("N");
		t.add("O");
		t.add("P");
		t.add("Q");
		t.add("R");
		t.add("S");
		t.add("T");
		t.add("U");
		t.add("V");
		t.add("W");
		t.add("X");
		t.add("Y");
		t.add("Z");

		t.traverse(RBTree.PREORDER, new Traversal()
		{
			public void process(Object o)
			{
				System.out.println(o);
			}
		});
	}
}