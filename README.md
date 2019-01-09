# Find the Distance between Two Nodes of a Binary Tree
This is a kotlin program to find the distance between 2 nodes of a binary tree.

                   [5]
               /          \
            [10]           [15]
            /    \         /    \
       [20]      [25]  [30]     [35]
       /   \     /  \      \    
     [40] [45] [50] [55]   [60]

## Formula
 Distance(x,y) = (Distance(root,x) + Distance(root,y)) - 2 * Distance(root, Lowest Common Ancestor(x,y) )

## How to use
### Compile
 - koltinc binarytree.kt -include-runtime -d binarytree.jar
### Run
 - java -jar binarytree.jar node1 node2
