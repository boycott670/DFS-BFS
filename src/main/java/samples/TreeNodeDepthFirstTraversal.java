package samples;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public final class TreeNodeDepthFirstTraversal<E> implements Iterator<TreeNode<E>>
{
  private TreeNode<E> root;
  private final Deque<TreeNode<E>> rightTreeNodes;

  public TreeNodeDepthFirstTraversal(TreeNode<E> root)
  {
    this.root = root;
    this.rightTreeNodes = new LinkedList<>();
  }

  @Override
  public boolean hasNext()
  {
    return root.getLeft() != null || !rightTreeNodes.isEmpty();
  }

  @Override
  public TreeNode<E> next()
  {
    if (root.getLeft() != null)
    {
      rightTreeNodes.addFirst(root.getRight());
      return root = root.getLeft();
    }
    else
    {
      return root = rightTreeNodes.removeFirst();
    }
  }

}
