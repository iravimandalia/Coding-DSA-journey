/*
* Prefix and Suffix Search
* Design a special dictionary which has some words and allows you to search the words in it by a prefix and a suffix.

* Implement the WordFilter class:

* WordFilter(string[] words) Initializes the object with the words in the dictionary.
* f(string prefix, string suffix) Returns the index of the word in the dictionary which has the prefix prefix and the suffix suffix.
* If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
*
* Example 1:
* Input
["WordFilter", "f"]
[[["apple"]], ["a", "e"]]
Output
[null, 0]

Explanation
WordFilter wordFilter = new WordFilter(["apple"]);
wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = 'e".

*/


/*
Approach 1:
WordFilter: Time = O(1)
f: Time = O(NL)
Space = O(1)

* Java provides 2 methods:
* startsWith() - checks whether a string starts with the specified character(s). 
* endsWith() - check whether a string ends with the specified character(s).
*/

class WordFilter {
    String result[];
    public WordFilter(String[] words) {
        result = words;
    }
    
    public int f(String prefix, String suffix) {
        for(int i = result.length-1; i >= 0; i--){
            if(result[i].startsWith(prefix) && result[i].endsWith(suffix)) 
				return i;
        }
        return -1;
    }
}

/*
Approach 2:
WordFilter: Time = O(NL^2)
f: Time = O(1)
Space = O(NL^2)

Store all the possibilities inside HashMap
*/

class WordFilter {
    HashMap<String, Integer> map = new HashMap<>();
    public WordFilter(String[] words) {
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j<=10 && j <=words[i].length(); j++){
                for(int k = 0; k<=10 && k <=words[i].length(); k++){
                    map.put(words[i].substring(0,j) + '#' + words[i].substring(words[i].length()-k),i);
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return (map.containsKey(prefix + '#' + suffix))?map.get(prefix + '#' + suffix):-1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */