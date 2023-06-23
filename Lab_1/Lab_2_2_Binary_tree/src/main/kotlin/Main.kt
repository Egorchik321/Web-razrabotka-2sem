//Создайте программу, которая будет реализовывать бинарное дерево. Программа должна содержать в себе такие метода как поиск, вставка, удаление, обход. Значение левого узла должно быть меньше основного, а значения правого больше.
//Дополнительно: сделать неизменяемое дерево.
class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
}

class BinaryTree {
    private var root: Node? = null

    fun insert(value: Int) {
        root = insertRecursive(root, value)
        println("Вставлен элемент: $value")
    }

    private fun insertRecursive(current: Node?, value: Int): Node {
        current ?: return Node(value)

        when {
            value < current.value -> current.left = insertRecursive(current.left, value)
            value > current.value -> current.right = insertRecursive(current.right, value)
            else -> return current
        }

        return current
    }

    fun contains(value: Int): Boolean {
        print("Есть элемент $value? - ")
        return containsRecursive(root, value)
    }

    private fun containsRecursive(current: Node?, value: Int): Boolean {
        current ?: return false

        return when {
            value < current.value -> containsRecursive(current.left, value)
            value > current.value -> containsRecursive(current.right, value)
            else -> true
        }
    }

    fun remove(value: Int) {
        root = removeRecursive(root, value)
        println("Удален элемент: $value")
    }

    private fun removeRecursive(current: Node?, value: Int): Node? {
        current ?: return null

        when {
            value < current.value -> current.left = removeRecursive(current.left, value)
            value > current.value -> current.right = removeRecursive(current.right, value)
            else -> {
                when {
                    current.left == null -> return current.right
                    current.right == null -> return current.left
                    else -> {
                        current.value = findMinValue(current.right)
                        current.right = removeRecursive(current.right, current.value)
                    }
                }
            }
        }

        return current
    }

    private fun findMinValue(node: Node?): Int {
        return node?.left?.let { findMinValue(it) } ?: node?.value ?: throw IllegalArgumentException("Node must not be null")
    }

    fun traverseInOrder(): List<Int> {
        print("Элементы дерева: ")
        val result = mutableListOf<Int>()
        traverseInOrderRecursive(root, result)
        return result
    }

    private fun traverseInOrderRecursive(node: Node?, result: MutableList<Int>) {
        node?.let {
            traverseInOrderRecursive(it.left, result)
            result.add(it.value)
            traverseInOrderRecursive(it.right, result)
        }
    }
}

fun main() {
    val tree = BinaryTree()
    tree.insert(8)
    tree.insert(6)
    tree.insert(5)
    tree.insert(2)
    tree.insert(3)
    println()
    println(tree.traverseInOrder())
    println()
    println(tree.contains(1))
    println(tree.contains(6))
    println()
    tree.remove(8)
    println()
    println(tree.traverseInOrder())
}