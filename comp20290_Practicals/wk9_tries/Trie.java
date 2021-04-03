package comp20290_Practicals.wk9_tries;


public class Trie{

	// Alphabet size (# of symbols) we pick 26 for English alphabet
	static final int ALPHABET_SIZE = 26; 


	// class for Trie node 
	static class TrieNode { 
		TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
		// isEndOfWord is true if the node represents end of a word i.e. leaf node
		boolean isEndOfWord; 

		TrieNode(){ 
			isEndOfWord = false; 

			for (int i = 0; i < ALPHABET_SIZE; i++) 
				children[i] = null; 
		} 
	}

	static TrieNode root;
	
	/* Method inserts a new word in the Trie. The method traverses the Trie in level order, 
	 * and each character in the word is stored in a new node. If a node containing the required char
	 * is not present, a new node is created.
	 * 
	 * @param key: the string to be inserted
	 */
	static void insert(String key) {
		TrieNode node = root;
        int length = key.length();
       
        for (int l = 0; l < length; l++)
        {
            int i  = key.charAt(l) - 'a';
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            
            node = node.children[i];
        }
       
        node.isEndOfWord = true;
	}
	
	/* Method searches for a given key in the Trie. The Trie is traversed in level order, trying
	 * to match each of the char to the Trie nodes. If at any one point a node is found to be null before
	 * the end of the word is reached, the method will return false.
	 * 
	 * @param: key, the string we are trying to find
	 * @return true if the key was found, false otherwise.
	 */
	static boolean search(String key) {
		TrieNode node = root;
        int length = key.length();
       
        for (int l = 0; l < length; l++) {
            int i = key.charAt(l) - 'a';
       
            if (node.children[i] == null) {
                return false;
            }
            node = node.children[i];
        }
       
        return (node != null && node.isEndOfWord);
	} 


	// Driver 
	public static void main(String args[]) { 

		// Input keys (use only 'a' through 'z' and lower case) 
		String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};


		String output[] = {"Not present in trie", "Present in trie"}; 

		root = new TrieNode(); 

		// Construct trie 
		int i; 
		for (i = 0; i < keys.length ; i++) {
			insert(keys[i]); 
		}

		// Search for different keys 
		System.out.println(search("bank")); 
		System.out.println(search("bark")); 
		System.out.println(search("filming")); 
		System.out.println(search("simple")); 
		System.out.println(search("silver")); 
	} 

	//end of class
} 