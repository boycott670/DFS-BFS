package samples;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.Before;
import org.junit.Test;

import samples.TreeNode.TreeNodeTraversalMode;

public class TreeNodeTest
{
  private TreeNode<Integer> root;

  @Before
  public void init()
  {
    root = TreeNode.of(1, TreeNode.of(2, TreeNode.of(4), TreeNode.of(5)), TreeNode.of(3));
  }

  @Test
  public void test()
  {
    root.setTraversalMode(TreeNodeTraversalMode.DEPTH_FIRST);

    final List<Integer> actual = new ArrayList<>(Arrays.asList(root.getValue()));

    actual.addAll(StreamSupport.stream(root.spliterator(), false)
        .map(TreeNode::getValue)
        .collect(Collectors.toList()));

    final List<Integer> expected = Arrays.asList(1, 2, 4, 5, 3);

    assertEquals(expected, actual);
  }
}
