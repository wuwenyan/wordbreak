import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: word
 * @description: WordBreak
 * @create: 2020-03-17 20:18
 */
public class WordBreak {
    public String[] dictionary;

    public void setDictionary(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public void print(String word){
        wordBreak(word, this.dictionary);
    }

    public void print(String word,String[] userDictionary){
        wordBreak(word, userDictionary);
    }

    public void printAllValidWord(String word,String[] userDictionary){
        List<String> list = new ArrayList<>(Arrays.asList(dictionary));
        list.addAll(Arrays.asList(userDictionary));
        String[] newDictionary= list.toArray(new String[list.size()]);
        wordBreak(word, newDictionary);
    }

    public void wordBreak(String word, String[] theDictionary){
        List<String> allList = new ArrayList<>();
        List<String> dict= new ArrayList<>();
        for (String str : theDictionary) {
            String[] dicWords = str.split(" ");
            dict.addAll(Arrays.asList(dicWords));
        }
        wordBreakRec(word, allList, dict.toArray(new String[dict.size()]));
    }

    public void wordBreakRec(String word, List<String> allList, String[] userDictionary){
        int len = word.length();
        if(len == 0){
            System.out.println(String.join(" ", allList));
            return;
        }
        // DFS
        for(int i=1; i<=len; i++){
            String substr = word.substring(0, i);
            if(dictionaryContains(substr, userDictionary)){
                allList.add(substr);
                wordBreakRec(word.substring(i), allList, userDictionary);
                allList.remove(allList.size()-1);
            }
        }
    }

    public boolean dictionaryContains(String word, String[] dictionary){
        for (String str : dictionary) {
            String dic = str.replace(" ", "");
            if (dic.equals(word)) {
                return true;
            }
        }
        return false;
    }
}

