/**
* To compile: javac Huffman.java
* To compress: java Huffman compress inputName.type outputName.type
* To decompress: java Huffman decompress inputName.type outputName.type
*
 *The Huffman Coding is a lossless data compression algorithm, developed by David Huffman in the early
 * of 50s while he was a PhD student at MIT. The algorithm is based on a binary-tree frequency-sorting
 * method that allow encode any message sequence into shorter encoded messages and a method to reassemble
 * into the original message without losing any data. On this assignment we are implementing the Huffman
 * Coding in three different tasks. This code includes task 2 and task 3.
 *  @author Rebeca Gerbase, Ruth Dooley, Noemi Banal
 */

import helper_code.BinaryIn;
import helper_code.BinaryOut;
import helper_code.MinPQ;
import helper_code.Stopwatch;


public class Huffman {

    // alphabet size of extended ASCII
    private static final int R = 256;
    static BinaryOut out;
    static BinaryIn in;

    // Do not instantiate.
    private Huffman() {
    }

    // Huffman trie node
    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        /**
         * Private boolean helper method that check if the node is a leaf
         */
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        /**
         * Public helper method that compares two nodes frequency
         * @param: that, the node to compare to this node
         * @return: the difference between the two frequencies
         */
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    /**
     * Reads a sequence of 8-bit bytes from standard input; compresses them using
     * Huffman codes with an 8-bit alphabet; and writes the results to standard
     * output.
     */
    public static void compress() {
        // read the input
        String inputString = in.readString();
        char[] input = inputString.toCharArray();

        // tabulate frequency counts
        int[] frequency = new int[R];
        for (int i = 0; i < input.length; i++) {
            frequency[input[i]]++;
        }

        // build Huffman trie
        Node root = buildTrie(frequency);

        // build code table
        String[] tableStrings = new String[R];
        buildCode(tableStrings, root, "");

        // print trie for decoder
        writeTrie(root);

        // print number of bytes in original uncompressed message
        out.write(input.length);

        // use Huffman code to encode input
        for (int i = 0; i < input.length; i++) {
            String tableString = tableStrings[input[i]];
            for (int j = 0; j < tableString.length(); j++)
                if (tableString.charAt(j) == '1') {
                    out.write(true);
                } else {
                    out.write(false);
                }
        }
        out.close();
    }

    /**
     * Reads a sequence of bits that represents a Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void decompress() {

        // read in Huffman trie from input stream
        Node root = readTrie();

        // number of bytes to write
        int numberOfBytes = in.readInt();

        // decode using the Huffman trie
        for (int i = 0; i < numberOfBytes; i++) {
            Node temp = root;
            while (!temp.isLeaf()) {
                if (in.readBoolean()) {
                    temp = temp.right;
                } else {
                    temp = temp.left;
                }
                out.write(temp.ch);
            }
        }
        out.close();
    }
    
    /* Private helper method which counts the number of bits in a given string input file. 
     * 
     * @param input: the given String input.
     * @return: the number of bits in the input string. 
     */
    private static int getNumberOfBits(String input) {
    	int numberOfBits = 0;
    	BinaryIn binaryIn = new BinaryIn(input);
        
        while (!binaryIn.isEmpty()) {
            binaryIn.readBoolean();
            numberOfBits++;
        }
        
        return numberOfBits;
    }

    // build the Huffman trie given frequencies
    private static Node buildTrie(int[] freq) {

        // initialize priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<Node>();
        for (char i = 0; i < R; i++)
            if (freq[i] > 0)
                pq.insert(new Node(i, freq[i], null, null));

        // special case in case there is only one character with a nonzero frequency
        if (pq.size() == 1) {
            if (freq['\0'] == 0)
                pq.insert(new Node('\0', 0, null, null));
            else
                pq.insert(new Node('\1', 0, null, null));
        }

        // merge two smallest trees
        while (pq.size() > 1) {
            Node left = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }

    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            out.write(true);
            out.write(x.ch, 8);
            return;
        }
        out.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    // make a lookup table from symbols and their encodings
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left, s + '0');
            buildCode(st, x.right, s + '1');
        } else {
            st[x.ch] = s;
        }
    }

    //read the trie for decompressing
    private static Node readTrie() {
        boolean isLeaf = in.readBoolean();
        if (isLeaf) {
            return new Node(in.readChar(), -1, null, null);
        } else {
            return new Node('\0', -1, readTrie(), readTrie());
        }
    }

    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "compress" an {@code decompress()} if it is "decompress".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
    	String command = args[0];
    	String compression = "compress";
    	String decompression = "decompress";
    	String inputFile = args[1];
    	String outputFile = args[2]; 
    	
        // Check if the command is valid
        if (args.length != 3) {
        	throw new IllegalArgumentException("Sorry, the command is not valid");
        }
        
        if (!command.equals(compression) && !command.equals(decompression)) {
        	throw new IllegalArgumentException("Please specify whether you want to compress or decompress a file.");
        }
        	
        out = new BinaryOut(outputFile);
        in = new BinaryIn(args[1]);
        
        switch (command.trim().toLowerCase()) {
        	case "compress": 
        		System.out.println("Will now compress the file " + inputFile + ", and output the file: " + outputFile);
        		Stopwatch sw = new Stopwatch(); 
        		System.out.println("Number of bits in the file before compression " + getNumberOfBits(inputFile));
        		compress();
        		System.out.println("Number of bits in the file after compression " + getNumberOfBits(outputFile));
        		System.out.println("The time elapsed is: " + sw.elapsedTime());
        		break; 
        	case "decompress": 
        		System.out.println("Will now decompress the file " + inputFile + ", and output the file: " + outputFile);
        		System.out.println("Number of bits in the file before decompression " + getNumberOfBits(inputFile));
        		Stopwatch sw1 = new Stopwatch(); 
        		decompress();
        		System.out.println("Number of bits in the file after decompression " + getNumberOfBits(outputFile));
        		System.out.println("The time elapsed is: " + sw1.elapsedTime());
        		break; 
        	default: 
        		System.out.println("Sorry, your command was not recognised.");	
        }
    }
}
