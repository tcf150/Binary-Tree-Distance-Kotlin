/*
 *                  [5]
 *              /          \
 *           [10]           [15]
            /    \         /    \
 *      [20]      [25]  [30]     [35]
 *      /   \     /  \      \    
 *    [40] [45] [50] [55]   [60]
 *
 */

fun main(args: Array<String>) {
    val root = Node(5, 
        Node(10,
            Node(20,
                Node(40),
                Node(45)
            ),
            Node(25,
                Node(50),
                Node(55)
            )
        ),
        Node(15,
            Node(30,
                null,
                Node(60)
            ),
            Node(35)
        )
    )
    println("Node 1: ${args[0]}")
    println("Node 2: ${args[1]}")
    val distance = findDistanceBetweenNode(root, args[0].toInt(), args[1].toInt())
    println("Distance: $distance")
}

fun findDistanceBetweenNode(root:Node, valueX: Int, valueY: Int): Int {
    val x = getPathLength(root, valueX) - 1
    val y = getPathLength(root, valueY) - 1
    val lca = findLowestCommonAncestor(root, valueX, valueY)
    val distanceLca = if (lca != null) getPathLength(root, lca.value) - 1 else 0
    return (x + y) - 2 * distanceLca
}

fun findLowestCommonAncestor(root: Node?, valueX: Int, valueY: Int): Node? {
    if (root == null) return null
    if (root.value == valueX || root.value == valueY) return root
    val left = findLowestCommonAncestor(root.left, valueX, valueY)
    val right = findLowestCommonAncestor(root.right, valueX, valueY) 
    if (left != null && right != null) {
         return root
    } else if (left != null) {
        return left
    } else if (right != null) {
        return right
    } else {
        return null
    }
}

fun getPathLength(root: Node, value: Int): Int {
    var x = 0
    if (root.value == value) {
        return x + 1
    } else {
        x = if (root.left != null) getPathLength(root.left,value) else 0
        if (x > 0) return x + 1
        x = if (root.right != null) getPathLength(root.right,value) else 0
        if(x > 0) return x + 1
    }
    return 0
}

data class Node(val value:Int, val left: Node? = null, val right:Node? = null)