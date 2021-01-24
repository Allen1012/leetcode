import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }

/**
 * 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 *
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 */
class NestedIterator implements Iterator<Integer> {

      private LinkedList<NestedInteger> list;
      public NestedIterator(List<NestedInteger> nestedList) {
          list = new LinkedList<>(nestedList);
      }

      @Override
      public Integer next() {
          return list.remove(0).getInteger();
      }

      @Override
      public boolean hasNext() {
          while (!list.isEmpty() && !list.get(0).isInteger()){
              List<NestedInteger> first = list.remove(0).getList();
              for (int i = first.size() - 1; i >= 0 ; i--) {
                  list.addFirst(first.get(i));
              }
          }
          return !list.isEmpty();
      }
  }

public class FlattenNestedListIterator {
}
