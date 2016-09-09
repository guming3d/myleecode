package com.interview.uniquebinarysearchtreesII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an integer n, generate all structurally unique BST's 
 * (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 * @author mcgu
 *
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

/**
 * 利用一个堆栈存放上次遍历的结果，新增加的节点顺序添加到上次节点的右边子树，同时作为根节点，效率不高，但是比较便于理解
 * @author mcgu
 *
 */
public class Solution {
	static Stack<TreeNode> uniqBST = new Stack<>();

	public static void main(String args[]) {
		Solution mySolution = new Solution();
		mySolution.generateTrees(3);
	}

	public List<TreeNode> generateTrees(int n) {
		uniqBST.clear();
		if (n == 0) {
			return new ArrayList<TreeNode>();
		}
		TreeNode firstNode = new TreeNode(1);
		List<TreeNode> resultList = new ArrayList<>();
		uniqBST.push(firstNode);
		// resultList.add(firstNode);
		if (n == 1) {
			resultList.add(firstNode);
			return resultList;
		}

		for (int i = 2; i <= n; i++) {
			List<TreeNode> roundList = new ArrayList<>();
			while (!uniqBST.isEmpty()) {
				TreeNode tmpCur = uniqBST.pop();
				roundList.add(tmpCur);

			}

			for (int j = 0; j < roundList.size(); j++) {
				TreeNode tmpCur = roundList.get(j);

				// adding the current new Node
				// addingNumber(tmpCur,new TreeNode(i));
				List<TreeNode> addingRightList = addingRightNumber(tmpCur, new TreeNode(i));
				addingRightList.forEach(item -> {
					uniqBST.push(item);
				});

				// Make new Node as Root
				TreeNode newRoot = new TreeNode(tmpCur.val);
				cloneTree(tmpCur, newRoot);
				TreeNode newHead = new TreeNode(i);
				newHead.left = newRoot;
				uniqBST.push(newHead);
			}

		}

		uniqBST.forEach(item -> {
			resultList.add(item);
		});

		return resultList;
	}

	/**
	 * Adding a larger Node to the current BST tree
	 * 
	 * @param root
	 * @return
	 */
	public void addingNumber(TreeNode root, TreeNode newNode) {
		if (root.right == null) {
			root.right = newNode;
			return;
		}

		if (root.right != null) {
			addingNumber(root.right, newNode);
		}

	}

	/**
	 * Adding a larger Node to the current BST tree return all possible new list
	 * 
	 * @param root
	 * @return
	 */
	public List<TreeNode> addingRightNumber(TreeNode root, TreeNode newNode) {
		List<TreeNode> allPossibleTrees = new ArrayList<>();

		int currentValue = root.val;
		while (currentValue != -1) {

			TreeNode tmpNode = new TreeNode(root.val);
			TreeNode tmpHead = tmpNode;
			cloneTree(root, tmpNode);

			while (tmpNode.val != currentValue) {
				tmpNode = tmpNode.right;
			}

			if (tmpNode.right != null) {
				currentValue = tmpNode.right.val;
				TreeNode rightLeft = tmpNode.right;
				// insert the NewNode to this location
				TreeNode newAddingNode = new TreeNode(newNode.val);
				tmpNode.right = newAddingNode;
				newAddingNode.left = rightLeft;
				allPossibleTrees.add(tmpHead);

			} else {
				TreeNode newAddingNode = new TreeNode(newNode.val);
				tmpNode.right = newAddingNode;
				allPossibleTrees.add(tmpHead);
				currentValue = -1;
			}

		}
		return allPossibleTrees;

	}

	// Clone a bst tree and return the new root
	public void cloneTree(TreeNode root, TreeNode newRoot) {
		if (root.left == null && root.right == null) {
			newRoot.val = root.val;
			return;
		}
		newRoot.val = root.val;
		if (root.left != null) {

			newRoot.left = new TreeNode(root.left.val);
			cloneTree(root.left, newRoot.left);

		}
		if (root.right != null) {
			newRoot.right = new TreeNode(root.right.val);
			cloneTree(root.right, newRoot.right);
		}
	}
}
