package dataStructure.SinglyLinkedList;

public class SinglyLinkedList<E extends Comparable<E>> {
	
	private int size;
	private Node head;
	private Node tail;
	
	public SinglyLinkedList()
	{
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	public void addAtHead(E value)
	{
		if(this.head == null && this.tail == null && this.size == 0)
		{
			this.head = new Node(value, null);
			this.tail = this.head;
			this.size++;
		}
		else
		{
			Node temp = new Node(value, this.head);
			this.head = temp;
			this.size++;
		}
	}
	
	public void addAtTail(E value)
	{
		if(this.head == null && this.tail == null && this.size == 0)
		{
			this.head = new Node(value, null);
			this.tail = this.head;
			this.size++;
		}
		else
		{
			Node temp = new Node(value, null);
			this.tail.setNext(temp);
			this.tail = temp;
			this.size++;
		}
	}
	
	public void addAtPosition(int pos, E value)
	{
		try
		{
			if(pos < 0 || pos >= this.size)
			{
				throw new Exception("Index Out Of Bound");
			}
			else if(pos == 0)
			{
				this.addAtHead(value);
			}
			else if(pos == this.size-1)
			{
				this.addAtTail(value);
			}
			else
			{
				Node pre = null;
				Node cur = this.head;
				int i = 0;
				while(cur != null)
				{
					if(i == pos)
					{
						Node temp = new Node(value, cur);
						pre.setNext(temp);
						this.size++;
						break;
					}
					i++;
					pre = cur;
					cur = cur.getNext();
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	
	public boolean deleteAtHead()
	{
		try
		{
			if(isEmpty())
			{
				throw new Exception("Singly Linked List is empty");
			}
			else
			{
				this.head = this.head.getNext();
				this.size--;
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean deleteAtTail()
	{
		try
		{
			if(isEmpty())
			{
				throw new Exception("Singly Linked List is empty");
			}
			else
			{
				Node cur = this.head;
				int i = 0;
				while(cur != null)
				{
					if(i == this.size-2)
					{
						cur.setNext(null);
						this.tail = cur;
						this.size--;
					}
					i++;
					cur = cur.getNext();
				}
				
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean deleteAtPosition(int pos)
	{
		try
		{
			if(pos < 0 || pos >= this.size)
			{
				throw new Exception("Index Out Of Bound");
			}
			else if(pos == 0)
			{
				return this.deleteAtHead();
			}
			else if(pos == this.size-1)
			{
				return this.deleteAtTail();
			}
			else
			{
				try
				{
					if(isEmpty())
					{
						throw new Exception("Singly Linked List is empty");
					}
					else
					{
						Node cur = this.head;
						Node pre = null;
						int i = 0;
						while(cur != null)
						{
							if(i == pos)
							{
								pre.setNext(cur.getNext());
								this.size--;
								break;
							}
							i++;
							pre = cur;
							cur = cur.getNext();
						}
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
					return false;
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}
	// find Node has minimum value of Link List, return null if list empty
	public E findMinNode()
	{
		Node cur = this.head;
		Node minNode = this.head;
		if(this.isEmpty())
			return null;
		
		
		while(cur != null)
		{
			if(minNode.value.compareTo(cur.value) > 0)
			{
				minNode = cur;
			}
			cur = cur.getNext();
		}
		return minNode.value;
	}
	public boolean isEmpty()
	{
		if(this.head == null && this.tail == null && this.size == 0)
			return true;
		return false;
	}
	public String toString()
	{
		String str = "[";
		Node cur = this.head;
		int i = 0;
		while(cur != null)
		{
			str = str +cur.getValue() + ((i == this.size-1) ? "]" : ",");
			i++;
			cur = cur.getNext();
		}
		return str;
	}
	public String toStringBackWard()
	{
		SinglyLinkedList<E> sllist = new SinglyLinkedList<E>();
		Node cur = this.head;
		while(cur != null)
		{
			sllist.addAtHead(cur.getValue());
			cur = cur.getNext();
		}
		
		return sllist.toString();
	}
	class Node
	{
		private E value;
		private Node next;
		
		public Node(E value, Node next)
		{
			this.value = value;
			this.next = next;
		}
		public Node getNext()
		{
			return this.next;
		}
		public void setNext(Node next)
		{
			this.next = next;
		}
		public E getValue()
		{
			return this.value;
		}
	}
}
