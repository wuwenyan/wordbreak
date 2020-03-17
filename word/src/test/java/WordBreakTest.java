import org.junit.Test;

/**
 * @program: word
 * @description: test
 * @create: 2020-03-17 20:19
 */
public class WordBreakTest {

    @Test
    public void test() {

        //the system dictionary
        String[] dictionary = {"i", "like", "sam", "sung", "samsung", "mobile", "and", "ice", "cream","man go"};
        //the user customized dictionary
        String[] customizedDictionary= {"i", "like", "sam", "sung", "mobile", "icecream", "man go", "mango"};

        String testInputStr= "ilikesamsungmobile";
        String testInputStr2 = "ilikeicecreamandmango";

        WordBreak wb= new WordBreak();
        wb.setDictionary(dictionary);

        //Stage 1
        System.out.println("======Stage 1 start======");
        wb.print(testInputStr);
        System.out.println("--------------------");
        wb.print(testInputStr2);
        System.out.println("======Stage 1 end======");

        //Stage 2
        System.out.println("======Stage 2 start======");
        wb.print(testInputStr, customizedDictionary);
        System.out.println("======Stage 2 end======");

        //Stage 3
        System.out.println("======Stage 3 start======");
        wb.printAllValidWord(testInputStr2, customizedDictionary);
        System.out.println("======Stage 3 end======");
    }
}

