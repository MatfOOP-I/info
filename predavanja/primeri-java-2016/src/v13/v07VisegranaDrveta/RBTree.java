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
public class RBTree
{
	public final static int INORDER = 1;
	public final static int PREORDER = 2;

	protected final static int RIGHT = 1;
	protected final static int LEFT = 2;

	protected TreeNode root;
	protected TreeNode lastBlack;
	protected Comparable c;

	public RBTree(Comparable c)
	{
		this.c = c;
		root = null;
	}

	public void add(Object o)
	{
		root = add(root, new TreeNode(o));
		root.setColor(TreeNode.BLACK);
	}

	protected TreeNode add(TreeNode root, TreeNode newNode)
	{
		if (root == null)
			return newNode;

		if (root.is4Way())
			split(root);

		int val = c.compare(newNode.getData(), root.getData());

		if (val < 0)
		{
			if (root.getLeft() == null)
			{
				root.setLeft(newNode);
			}
			else
			{
				root.setLeft(add(root.getLeft(), newNode));
			}
		}
		else
		{
			if (root.getRight() == null)
			{
				root.setRight(newNode);
			}
			else
			{
				root.setRight(add(root.getRight(), newNode));
			}
		}

		root = balance(root);
		return root;
	}

	protected TreeNode balance(TreeNode node)
	{
		if (node.hasRedChild() == false)
			return node;

		TreeNode child = node.getLeft();

		if (child != null)
		{
			if (child.hasRedChild() == true)
				node = rotate(node, RIGHT);
		}

		child = node.getRight();

		if (child != null)
		{
			if (child.hasRedChild() == true)
				node = rotate(node, LEFT);
		}

		return node;
	}
	
	public void split(TreeNode node)
	{
		node.flip();
		node.getRight().flip();
		node.getLeft().flip();
	}

	protected TreeNode rotate(TreeNode root, int direction)
	{
		TreeNode newRoot = null;
		TreeNode orphan = null;
		boolean tmp;

		tmp = root.getColor();
		switch (direction)
		{
			case RIGHT :
				newRoot = root.getLeft();
				root.setLeft(null);
				orphan = newRoot.getRight();
				newRoot.setRight(root);
				break;
			case LEFT :
				newRoot = root.getRight();
				root.setRight(null);
				orphan = newRoot.getLeft();
				newRoot.setLeft(root);
				break;
		}

		if (newRoot == null)
			return root;

		root.setColor(newRoot.getColor());
		newRoot.setColor(tmp);
		if (orphan != null)
			add(root, orphan);

		return newRoot;
	}

	protected Object search(TreeNode root, Object o)
	{
		if (root == null)
		{
			return null;
		}

		int val = c.compare(o, root.getData());

		if (val == 0)
		{
			return root.getData();
		}
		else if (val < 0)
		{
			return search(root.getLeft(), o);
		}
		else if (val > 0)
		{
			return search(root.getRight(), o);
		}
		return null;
	}

	public void traverse(Traversal t)
	{
		traverse(INORDER, t);
	}

	public void traverse(int type, Traversal t)
	{
		traverse(root, type, t);
	}

	protected void traverse(TreeNode root, int type, Traversal t)
	{
		TreeNode tmp;

		if (type == PREORDER)
			t.process(root.getData());

		if ((tmp = root.getLeft()) != null)
			traverse(tmp, type, t);

		if (type == INORDER)
			t.process(root.getData());

		if ((tmp = root.getRight()) != null)
			traverse(tmp, type, t);
	}

}
