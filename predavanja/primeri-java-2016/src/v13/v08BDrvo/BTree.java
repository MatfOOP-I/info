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

public class BTree
{
	protected TreeNode root;
	protected Comparable c;
	protected int order;

	public final static int INORDER = 1;
	public final static int PREORDER = 2;

	protected final static int RIGHT = 1;
	protected final static int LEFT = 2;

	public BTree(int order, Comparable c)
	{
		this.order = order;
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

		if (root.isOverFull(order))
		{
			split(root);
		}

		return root;
	}

	protected int branchCount(TreeNode child)
	{
		if (child != null)
		{
			if (child.getColor() == TreeNode.RED)
			{
				return child.countRedChildren() + 1;
			}
		}
		return 0;
	}

	protected TreeNode balance(TreeNode node)
	{
		if (node == null)
			return node;

		if (node.getColor() != TreeNode.BLACK)
			return node;

		if (node.countRedChildren() < 2)
			return node;

		while (branchCount(node.getLeft()) < branchCount(node.getRight()) - 1)
		{
			node = rotate(node, LEFT);
		}
		while (branchCount(node.getRight()) < branchCount(node.getLeft()) - 1)
		{
			node = rotate(node, RIGHT);
		}
		return node;
	}

	public void split(TreeNode node)
	{
		if (node.isOverFull(order) == false)
			return;

		node.flip();
		if (node.getRight() != null)
			node.getRight().flip();
		if (node.getLeft() != null)
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
				if (newRoot == null)
					return root;
				orphan = newRoot.getRight();
				root.setLeft(orphan);
				newRoot.setRight(root);
				break;
			case LEFT :
				newRoot = root.getRight();
				if (newRoot == null)
					return root;
				orphan = newRoot.getLeft();
				root.setRight(orphan);
				newRoot.setLeft(root);
				break;
		}

		root.setColor(newRoot.getColor());
		newRoot.setColor(tmp);

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