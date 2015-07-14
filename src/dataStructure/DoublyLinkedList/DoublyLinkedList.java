package dataStructure.DoublyLinkedList;



public class DoublyLinkedList<E extends Comparable<E>> 
{
	private Node head;
	private Node tail;
	private int size;
	public DoublyLinkedList()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	// add Node at front of list
	public void addFront(E value)
	{
		if(this.head == null && this.tail == null && this.size == 0)
		{
			this.head  = new Node(null, value, this.tail);
			this.tail = this.head;
			this.size++;
		}
		else
		{
			Node temp = new Node(null, value, this.head);
			this.head.pre = temp;
			this.head = temp;
			this.size++;
		}
		
	}
	
	// add Node at last of list
	public void addLast(E value)
	{
		if(this.head == null && this.tail == null && this.size == 0)
		{
			this.head  = new Node(null, value, this.tail);
			this.tail = this.head;
			this.size++;
		}
		else
		{
			Node temp = new Node(this.tail, value, null);
			this.tail.next = temp;
			this.tail = temp;
			this.size++;
		}
		
	}
	// add Node at any index of list
	public void addPre(int pos, E value)
	{
		try
		{
			if(pos < 0 || pos >= this.size)
			{
				throw new Exception("Index Out Of Bound");
			}
			else if(pos == 0)
			{
				this.addFront(value);
			}
			else if(pos == this.size-1)
			{
				this.addLast(value);
			}
			else
			{
				Node cur = this.head;
				int i = 0;
				while(cur != null)
				{
					if(i == pos)
					{
						Node temp = new Node(cur.pre, value, cur);
						cur.pre.next = temp;
						cur.pre = temp;
						this.size++;
						break;
					}
					i++;
					cur = cur.next;
				}
				
			}
				
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}
	
	// add Node at after of position of list
	public void addAfter(int pos, E value)
	{
		try
		{
			if(pos < 0 || pos >= this.size)
			{
				throw new Exception("Index Out Of Bound");
			}
			else if(pos == 0)
			{
				this.addFront(value);
			}
			else if(pos == this.size-1)
			{
				this.addLast(value);
			}
			else
			{
				Node cur = this.head;
				int i = 0;
				while(cur != null)
				{
					if(pos == i)
					{
						Node temp = new Node(cur, value, cur.next);
						cur.next.pre = temp;
						cur.next = temp;
						this.size++;
						break;
					}
					i++;
					cur =cur.next;
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	// return  Node deleted, otherwise, return null; 
	public Node deleteAtFront()
	{
		if(this.head == null && this.tail == null && this.size == 0)
			return null;
		
		Node cur = this.head;
		this.head = this.head.next;
		this.head.pre = null;
		this.size--;
		
		return cur;
	}
	
	// return  Node deleted, otherwise, return null; 
	public Node deleteAtLast()
	{
		if(this.head == null && this.tail == null && this.size == 0)
			return null;
		
		Node cur = this.tail;
		this.tail = this.tail.pre;
		this.tail.next = null;
		this.size--;
		
		return cur;
	}
	
	// return Node deleted, otherwise, return null;
	public Node deleteAtPosition(int pos)
	{
		try
		{
			if(pos < 0 || pos >= this.size)
			{
				throw new Exception("Index Out Of Bound");
			}
			else if(pos == 0)
			{
				return this.deleteAtFront();
			}
			else if(pos == this.size-1)
			{
				return this.deleteAtLast();
			}
			else
			{
				Node cur = this.head;
				int i = 0;
				while(cur != null)
				{
					if(i == pos)
					{
						cur.pre.next = cur.next;
						cur.next.pre = cur.pre;
						this.size--;
						return cur;
					}
					i++;
					cur = cur.next;
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	// find Node with its value
	public boolean findNode(E value)
	{
		Node cur = this.head;
		while(cur != null)
		{
			if(value.compareTo(cur.value) == 0)
			{
				return true;
			}
			cur = cur.next;
		}
		return false;
	}
	public boolean isEmpty()
	{
		return ((this.head == null && this.tail == null && this.size == 0) ? true : false );
	}
	public String toString()
	{
		String str = "[";
		Node cur = this.head;
		int i = 0;
		while(cur != null)
		{
			str = str + cur.value + ((i < this.size-1) ? "," : "]");
			cur = cur.next;
			i++;
		}
		return str;
	}
	public String toStringBackWard()
	{
		String str = "[";
		Node cur = this.tail;
		int i = 0;
		while(cur != null)
		{
			str = str + cur.value + ((i < this.size-1) ? "," : "]");
			i++;
			cur = cur.pre;
		}
		return str;
	}
	
	private class Node
	{
		E value;
		Node pre;
		Node next;
		
		public Node(Node pre, E value, Node next)
		{
			this.value = value;
			this.pre = pre;
			this.next = next;
		}
	}
}
