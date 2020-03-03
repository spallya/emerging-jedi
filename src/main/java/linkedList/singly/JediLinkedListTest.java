package linkedList.singly;

public class JediLinkedListTest {

	public static JediLinkedList<Integer> jediLinkedList;

	/*
	*
	* List: 					[110][221][13][44][575]
	* .size(): 					5
	* .get(3): 					44 (get element at index:3 - list starts from 0)
	* .remove(2): 				true (element removed)
	* List: 					[110][221][44][575]
	* .get(3): 					575 (get element at index:3 - list starts from 0)
	* .size(): 					4
	* List: 					[110][221][44][575]
	* */
	public static void main(String[] args) {
		jediLinkedList = new JediLinkedList<>();
		jediLinkedList.add(110);
		jediLinkedList.add(221);
		jediLinkedList.add(13);
		jediLinkedList.add(44);
		jediLinkedList.add(575);
		System.out.println("List: \t\t\t\t\t" + jediLinkedList);
		System.out.println(".size(): \t\t\t\t" + jediLinkedList.size());
		System.out.println(".get(3): \t\t\t\t" + jediLinkedList.get(3) + " (get element at index:3 - list starts from 0)");
		System.out.println(".remove(2): \t\t\t" + jediLinkedList.remove(2) + " (element removed)");
		System.out.println("List: \t\t\t\t\t" + jediLinkedList);
		System.out.println(".get(3): \t\t\t\t" + jediLinkedList.get(3) + " (get element at index:3 - list starts from 0)");
		System.out.println(".size(): \t\t\t\t" + jediLinkedList.size());
		System.out.println("List: \t\t\t\t\t" + jediLinkedList);
	}
 
}