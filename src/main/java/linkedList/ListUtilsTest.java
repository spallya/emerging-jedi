package linkedList;

public class ListUtilsTest {

    public static void main(String[] args) {
        JediLinkedList<Integer> list1 = new JediLinkedList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        JediLinkedList<Integer> list2 = new JediLinkedList<>();
        list2.add(2);
        list2.add(4);
        list2.add(6);
        list2.add(8);
        list2.add(10);
        mergeTwoLists(list1, list2);

    }

    /*
    * Program Output:
    * List1: 					[1][3][5][7][9]
    * List2: 					[2][4][6][8][10]
    * Merged List: 			[1] [2] [3] [4] [5] [6] [7] [8] [9] [10]
    *
    * */
    private static void mergeTwoLists(JediLinkedList<Integer> list1, JediLinkedList<Integer> list2) {
        System.out.println("List1: \t\t\t\t\t" + list1);
        System.out.println("List2: \t\t\t\t\t" + list2);
        Node node = ListUtils.mergeTwoLists(list1.getHead(), list2.getHead());
        System.out.print("Merged List: \t\t\t");
        while (node != null) {
            System.out.print("[" + node.getData() + "] ");
            node = node.getNext();
        }
    }
}
