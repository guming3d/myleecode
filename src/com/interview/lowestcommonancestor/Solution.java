package com.interview.lowestcommonancestor;

import com.interview.lowestcommonancestor.*;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants 
(where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
since a node can be a descendant of itself according to the LCA definition.
 * @author mcgu
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(6);
		root.left=new TreeNode(2);
		root.left.right=new TreeNode(4);
		root.left.left=new TreeNode(0);
		root.right=new TreeNode(8);
		root.right.left=new TreeNode(7);
		root.right.right=new TreeNode(9);
		System.out.println("common root is "+lowestCommonAncestor(root,root.right.left,root.right.right).val);
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val<=root.val && q.val>=root.val)
		{
			return root;
		}
		else if(p.val>=root.val && q.val <= root.val)
		{
			return root;
		}
		else if(p.val < root.val && q.val < root.val)
		{
			return lowestCommonAncestor(root.left,p,q);
		}else if(p.val > root.val && q.val > root.val)
		{
			return lowestCommonAncestor(root.right,p,q);
		}
			
        return null;
    }
}
