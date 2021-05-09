# Comp20290 Algorithms 
Java programs and algorithmic analysis created during the spring semester 2020/2021 for the module COMP20290. Developed using Eclipse IDE and Google Drive. 

## Getting started
### Prerequisites 
* While this repository was made using Eclipse IDE (which can be found for free [here](https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers)), you are free to use whichever IDE you are most comfortable with. 
* The classes were compiled using Java 14 - howerever, the project can be rebuilt using a different compiler by clicking Project -> Properties -> Java Compiler -> Tick "enable project specific settings" -> Change to whichever Compiler Compliance Level you desire <br/>

### Build and Run 
* In Eclipse, find the package explorer and right click. Here, click "Import".
* Click "Projects from Git (with smart import)".
* Click "Clone URL".
* Enter the repository URL found on Github, then click finish. 

## Contents overview
|   | Analysis | Java Classes | Description |
|---| ---- | ---- | ----------- | 
| 1 | [Empirical Analysis of Algorithms](https://github.com/CompAlgorithms/algorithms20290-2021-repository-noemiBa/blob/main/comp20290_Practicals/wk3_complexity_analysis/Practical%202%20-%20Analysis%20of%20Russian%20Peasant%20Algorithm.pdf) | [ThreeSumA](./comp20290_Practicals/wk2/ThreeSumA.java) | Solution to the problem of finding triples in a file that sum up to 0 - uses a Brute Force algorithm. |  
|   |   | [ThreeSumB](./comp20290_Practicals/wk2/ThreeSumB.java) | Solution to the problem of finding triples in a file that sum up to 0 - uses a Binary Search algorithm (more efficient than ThreeSumA) | 
| 2 | [Complexity Analysis](https://github.com/CompAlgorithms/algorithms20290-2021-repository-noemiBa/blob/main/comp20290_Practicals/wk2/Practical%201_%20Empirical%20Analysis%20of%20Algorithms.pdf) | [RussianPeasant](./comp20290_Practicals/wk3_complexity_analysis/RussianPeasant.java) | Russian Peasant's Algorithm is an algorithm for multiplication that uses doubling, halving, and addition | 
| 3 | [Recursion](https://github.com/CompAlgorithms/algorithms20290-2021-repository-noemiBa/blob/main/comp20290_Practicals/wk4_recursion/Practical3_analysis_and_writtenQuestions.docx.pdf) | [Fibonacci](./comp20290_Practicals/wk4_recursion/Fibonacci.java) | Recursive and iterative implementation of the Fibonacci algorithm. |  
|   |   | [Hanoi](./comp20290_Practicals/wk4_recursion/Hanoi.java) | Recursive implemetation of the Tower of Hanoi algorithm. | 
| 4 | [Sorting 1](https://github.com/CompAlgorithms/algorithms20290-2021-repository-noemiBa/blob/main/comp20290_Practicals/wk5towk7_sorting/Practical4_Analysis_and_WrittenQuestions.docx.pdf) <br/> [Sorting 2](https://github.com/CompAlgorithms/algorithms20290-2021-repository-noemiBa/blob/main/comp20290_Practicals/wk5towk7_sorting/Practical5_Analysis.pdf) | [Sorting](./comp20290_Practicals/wk5towk7_sorting/Sorting.java) | Sorting class contains implementations of the following sorting algorithms: <br/> 1) Selection Sort. <br/> 2) Insertion Sort <br/> 3) Staling sort (*not* a real sort) <br/> 4) Merge Sort <br/> 5) Merge Sort Enhanced <br/> 6) Quick Sort <br/> 7) Quick Sort Enhanced |  
| 5 | [String Searching](https://github.com/CompAlgorithms/algorithms20290-2021-repository-noemiBa/blob/main/comp20290_Practicals/wk8_stringsearching/Practical%208_Searching%20Algorithms.pdf) | [BruteForceSearch](./comp20290_Practicals/wk8_stringsearching/BruteForceSearch.java) | Java program for naive pattern search using a Brute Force algorithm. |  
|   |   | [KMPSearch](./comp20290_Practicals/wk8_stringsearching/KMPsearch.java) | Java program for String pattern search using a KMP algorithm (more efficient than the Brute Force algorithm). | 
| 6 | [Tries](https://github.com/CompAlgorithms/algorithms20290-2021-repository-noemiBa/blob/main/comp20290_Practicals/wk9_tries/Practical8_Tries.pdf) | [Trie](./comp20290_Practicals/wk9_tries/Trie.java) | Standard Java Trie implementation. |  
| 7 | [Data Compression](https://github.com/CompAlgorithms/algorithms20290-2021-repository-noemiBa/blob/main/comp20290_Practicals/wk10_runlength/Practical9_Run%20Length.pdf) | [RunLengthEncoding](./comp20290_Practicals/wk10_runlength/RunLengthEncoding.java) | Java implementation of the Run Length Encoding algorithm. | 
| 8 | [Huffman Assignment](https://github.com/CompAlgorithms/algorithms20290-2021-repository-noemiBa/blob/main/comp20290_Practicals/Assignment/Huffman%20Compression.pdf) | [Huffman](./comp20290_Practicals/Assignment/src/Huffman.java) | Java implementation of huffman algorithm. | 

## Utility Classes
Please note that the following utility classes utilised throughout the repository were authored by *Robert Sedgewick* and *Kevin Wayne*:
* [In](./comp20290_Practicals/wk2/In.java)
* [StdIn](./comp20290_Practicals/wk2/StdIn.java)
* [StdOut](./comp20290_Practicals/wk2/StdOut.java)
* [StopWatch](./comp20290_Practicals/wk2/Stopwatch.java)
* [KnuthShuffle](./comp20290_Practicals/wk5towk7_sorting/KnuthShuffle.java)
* [BinaryDump](/comp20290_Practicals/wk10_runlength/BinaryDump.java)
* [BinaryIn](./comp20290_Practicals/wk10_runlength/BinaryIn.java)
* [BinaryStdIn](./comp20290_Practicals/wk10_runlength/BinaryStdIn.java)
* [BinaryStdOut](./comp20290_Practicals/wk10_runlength/BinaryStdOut.java)
* [HexDump](./comp20290_Practicals/wk10_runlength/HexDump.java)
* [RunLength](./comp20290_Practicals/wk10_runlength/RunLength.java) 

## References
* *Algorithms*, by Robert Sedgewick and Kevin Wayne.
* *Data Structures and Algorithms*, by Micheal T. Goodrich and Roberto Tamassia.
