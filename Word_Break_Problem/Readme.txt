Programming Problem - Find Longest Word Made of Other Words

Write a program that reads a file containing a sorted list of words (one word per line, no spaces, all lower case), then identifies the 
1.	1st longest word in the file that can be constructed by concatenating copies of shorter words also found in the file. 
2.	The program should then go on to report the 2nd longest word found 
3.	Total count of how many of the words in the list can be constructed of other words in the list.

Please reply to this email with your solution as source code along with 
the 1st and the 2nd  longest words that the program finds and the count of words that can be constructed as an output in the body of the email and any comments you have on the approach you took.
If you have any questions about the problem, please feel free to email us back.

For example, if the file contained:
       cat
       cats
       catsdogcats
       catxdogcatsrat
       dog
       dogcatsdog
       hippopotamuses
       rat
       ratcatdogcat

The answer would be 'ratcatdogcat' - at 12 letters, it is the longest word made up of other words in the list.  The program should then go on to report how many of the words in the list can be constructed of other words in the list.

Please find attached a file, “words for problem.txt”, containing a word list, with 173k rows, for testing purposes.



----------------------------------------------------------------------------------------------------------------------




Solution 1 :　DFS

1　Read the local input file "wordsforproblem.txt" using HTML5 File API. Then, parse the file to a list of words and sort the list by the length of words in descending order.

2 For each word in the words list, recursively check whether or not the current substring of the word can be found in words list. If yes, we use a map to record that the current substring can be made of other words. If not, we record that it can't be made of other words. 


Solution 2 : Trie and Queue

1　Read the local input file "wordsforproblem.txt" using HTML5 File API. Then, parse the file to an array of words.

2 Traverse the input array and add each word into the trie. 
2.1 For each word, we generate all of its prefixes, and append a pair of <current word, suffix> into a queue. 
2.2 Then add the current word to the trie. 
We repeat steps 2.1 and 2.2 for each word in the array to generate the trie and queue.

3 Pop every element in the queue and process it. 
Each element in the queue is a pair of <current word, suffix>. 
If the suffix is a valid word in the array, we may get an candidate for the 1st longset or the 2nd longset word that can be made of other words in the input file. 
If the suffix isn't a valid word, we need to generate the prefixes of the current suffix and add a new pair of <current word, new suffix> to the queue. We keep doing this until all the elements in the queue have been processed.