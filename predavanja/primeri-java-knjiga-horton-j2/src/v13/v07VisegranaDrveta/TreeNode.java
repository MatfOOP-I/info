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
public class TreeNode
{
	public static final boolean RED = true;
	public static final boolean BLACK = false;

	private TreeNode left;
	private TreeNode right;
	private Object data;
	private boolean color;

	public TreeNode(Object o)
	{
		data = o;
		color = RED;
		left = right = null;
	}

	public Object getData()
	{
		return data;
	}
	public void setData(Object o)
	{
		data = o;
	}

	public TreeNode getLeft()
	{
		return left;
	}

	public void setLeft(TreeNode l)
	{
		left = l;
	}

	public TreeNode getRight()
	{
		return right;
	}

	public void setRight(TreeNode r)
	{
		right = r;
	}

	public boolean getColor()
	{
		return color;
	}

	public void setColor(boolean c)
	{
		color = c;
	}

	public void flip()
	{
		color = !color;
	}

	public boolean hasRedChild()
	{
		if (left != null && left.color == RED)
			return true;

		if (right != null && right.color == RED)
			return true;

		return false;
	}

	public boolean is2Way()
	{
		if (color == RED)
			return false;

		return !hasRedChild();
	}

	public boolean is3Way()
	{
		if (color == RED)
			return false;

		if (is2Way() || is4Way())
			return false;

		return true;
	}

	public boolean is4Way()
	{
		if (color == RED)
			return false;

		if (left == null || right == null)
			return false;

		if (left.color == RED && right.color == RED)
			return true;

		return false;
	}

	public String toString()
	{
		return "Node " + data;
	}

}
