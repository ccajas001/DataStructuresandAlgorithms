
public class ListNode<E> {
	E data;
	ListNode<E> next;
	
	//creates a Node by taking in data and setting up a reference to the next node!:D
	public ListNode(E data, ListNode<E> next) {
		this.data=data;
		this.next=next;
	}
}
