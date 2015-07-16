package dataStructure.HashTable;

/*Concept:
 * Look like array, accessing perform is fast
 * Require a table size
 * Each cell on the table is called HashEntry equal a pair(key,value)
 * Initialize each cell (HashEntry) with null value
 * Not allow insert/put a pair(key,value) with null value into a cell because this key is used
 * for creating hash code. Override value if key is same
 * A counter is presented number of cells into table
 * - functionalities: 
 * 	get a cell at particular key
 *  put (key,value) to a cell
 *  size: return number of cells into table is presented 
 * */
public class HashTable {
	
	private static final int TABLE_SIZE		=	127;
	private HashEntry[] table;
	private int count;
	
	public HashTable()
	{
		this.table = new HashEntry[TABLE_SIZE];
		for(int i = 0 ; i < TABLE_SIZE; ++i)
		{
			this.table[i] = null;
		}
		this.count = 0;
	}
	
	// get value at a cell (HashEntry), if the key is not seen on the table then return -1
	public int get(int key)
	{
		// hash code: index of the table
		int hash = key % TABLE_SIZE;
		if(this.table[hash] != null)
		{
			if(this.table[hash].key == key)
				return this.table[hash].value;
		}
		return -1;
	}
	// put a pair(key, value) into cell of the table, override value if there are same key
	public void put(int key, int value)
	{
		// hash code: index of the table
		int hash = key % TABLE_SIZE;
		if(this.table[hash] == null)
		{
			this.count++;
		}
		this.table[hash] = new HashEntry(key, value);
		
	}
	public int size()
	{
		return this.count;
	}
	
	// remove a cell on the table with key and value are provided
	public boolean remove(int key, int value)
	{
		// hash code: index of the table
		int hash = key % TABLE_SIZE;
		if(this.table[hash] != null && this.table[hash].key == key && this.table[hash].value == value)
		{
			this.table[hash] = null;
			this.count--;
			return true;
		}
		return false;
	}
	// remove a cell on the table with key is provided
	public boolean remove(int key)
	{
		int hash = key % TABLE_SIZE;
		if(this.table[hash] != null && this.table[hash].key == key)
		{
			this.table[hash] = null;
			this.count--;
			return true;
		}
		return false;
	}
	public void removeAll()
	{
		for(int i = 0; i < TABLE_SIZE; ++i)
		{
			if(this.table[i] != null)
			{
				this.table[i] = null;
				this.count--;
			}
		}
	}
	
	class HashEntry
	{
		private int key;
		private int value;
		public HashEntry(int key, int value)
		{
			this.key = key;
			this.value = value;
		}
	}
	
}
