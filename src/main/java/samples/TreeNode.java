package samples;

import java.util.Iterator;

public final class TreeNode<E> implements Iterable<TreeNode<E>>
{
  public static enum TreeNodeTraversalMode
  {
    DEPTH_FIRST, BREADTH_FIRST;
  }

  private final E value;
  private final TreeNode<E> left;
  private final TreeNode<E> right;

  private TreeNodeTraversalMode traversalMode = TreeNodeTraversalMode.DEPTH_FIRST;

  public static <E> TreeNode<E> of(final E value)
  {
    return new TreeNode<E>(value, null, null);
  }

  public static <E> TreeNode<E> of(final E value, final TreeNode<E> left, final TreeNode<E> right)
  {
    return new TreeNode<E>(value, left, right);
  }

  private TreeNode(E value, TreeNode<E> left, TreeNode<E> right)
  {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public final E getValue()
  {
    return value;
  }

  public final TreeNode<E> getLeft()
  {
    return left;
  }

  public final TreeNode<E> getRight()
  {
    return right;
  }

  public final void setTraversalMode(TreeNodeTraversalMode traversalMode)
  {
    this.traversalMode = traversalMode;
  }

  @Override
  public Iterator<TreeNode<E>> iterator()
  {
    switch (traversalMode)
    {
      case DEPTH_FIRST:
        return new TreeNodeDepthFirstTraversal<>(this);
      case BREADTH_FIRST:
        return new TreeNodeDepthFirstTraversal<>(this);
    }
    
    throw new IllegalStateException("Unimplemented traversal mode");
  }
}
