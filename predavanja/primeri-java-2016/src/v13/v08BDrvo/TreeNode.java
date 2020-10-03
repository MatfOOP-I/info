/*
 * Created on 2004.4.21
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package v13.v08BDrvo;

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

	public int countRedChildren()
	{
		int count = 0;

		if (left != null && left.color == RED)
		{
			count += left.countRedChildren();
			count++;
		}

		if (right != null && right.color == RED)
		{
			count += right.countRedChildren();
			count++;
		}

		return count;
	}

	public boolean isOverFull(int order)
	{
		if (color == RED)
			return false;

		if (countRedChildren() >= order - 1)
			return true;

		return false;
	}

	public String toString()
	{
		return "Node " + data;
	}

}
