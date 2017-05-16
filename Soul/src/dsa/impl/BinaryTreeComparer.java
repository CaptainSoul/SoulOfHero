package dsa.impl;

import dsa.iface.IBinaryTree;
import dsa.iface.INode;

public class BinaryTreeComparer<T extends Comparable<T>> {
   private IBinaryTree<T> t1;
   private IBinaryTree<T> t2;

   public BinaryTreeComparer( IBinaryTree<T> t1, IBinaryTree<T> t2 ) {
      this.t1 = t1;
      this.t2 = t2;
   }

   /**
    * Test to see if two Binary Trees are equal (have the same structure and the same contents)
    * @return
    */
   public boolean areEqual() {
	   return compareEqual(t1.root(), t2.root());
   }
   
   public boolean compareEqual(INode<T> one, INode<T> two) {
	   if(t1.isExternal(one) && t2.isExternal(two)) {
		   return true;
	   } else if(t1.isExternal(one) && !t2.isExternal(two)) {
		   return false;
	   } else if(!t1.isExternal(one) && t2.isExternal(two)) {
		   return false;
	   }
	   boolean toReturn1 = compareEqual(t1.left(one), t2.left(two));
	   boolean toReturn2 = compareEqual(t1.right(one), t2.right(two));
	   if(toReturn1 && toReturn2 && one.element() == two.element()) {
		   return true;
	   }
	   return false;
   }

}
