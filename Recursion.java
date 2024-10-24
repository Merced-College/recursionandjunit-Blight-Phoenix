import static org.junit.Assert.*;
import org.junit.Test;

public class Count8 {

    public static int count8(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 10 == 8) {
            if ((n / 10) % 10 == 8) {
                return 2 + count8(n / 10);
            }
            return 1 + count8(n / 10);
        }
        return count8(n / 10);
    }

    @Test
    public void test8() {
        assertEquals(1, Count8.count8(8));
    }

    @Test
    public void test818() {
        assertEquals(2, Count8.count8(818));
    }

    @Test
    public void test8818() {
        assertEquals(4, Count8.count8(8818));
    }

    @Test
    public void testNo8() {
        assertEquals(0, Count8.count8(1234));
    }

    @Test
    public void testDouble8InMiddle() {
        assertEquals(4, Count8.count8(1881));
    }
}

public class HiCounter {

    public static int countHi2(String str) {
        // Base case: if the string has less than 2 characters, no "hi" can be present.
        if (str.length() < 2) {
            return 0;
        }

        // Check for "hi" not preceded by "x"
        if (str.length() >= 3 && str.substring(0, 3).equals("xhi")) {
            // Skip "xhi" pattern and continue checking the rest of the string.
            return countHi2(str.substring(3));
        } else if (str.substring(0, 2).equals("hi")) {
            // Found a "hi", count it and continue checking the rest of the string.
            return 1 + countHi2(str.substring(2));
        } else {
            // If no "hi" or "xhi" at the start, just move on.
            return countHi2(str.substring(1));
        }
    }

  public class HiCounterTest {

    @Test
    public void testCountHi2_withXhi() {
        // "hi" is present but preceded by "x", so it should not be counted.
        assertEquals(1, HiCounter.countHi2("ahixhi"));
    }

    @Test
    public void testCountHi2_multipleHi() {
        // There are two "hi"s not preceded by "x"
        assertEquals(2, HiCounter.countHi2("ahibhi"));
    }

    @Test
    public void testCountHi2_xHiPattern() {
        // Both "hi"s are preceded by "x", so none should be counted.
        assertEquals(0, HiCounter.countHi2("xhixhi"));
    }

    @Test
    public void testCountHi2_noHi() {
        // No "hi" in the string at all
        assertEquals(0, HiCounter.countHi2("abcdefg"));
    }

    @Test
    public void testCountHi2_edgeCaseEmptyString() {
        // Edge case: empty string
        assertEquals(0, HiCounter.countHi2(""));
    }
  }
}


public class HiCounter {

    public static int countHi2(String str) {
        // Base case: if the string has fewer than 2 characters, no "hi" can exist
        if (str.length() < 2) {
            return 0;
        }
        
        // If we find "xhi", skip the 'x' and "hi" by moving 3 characters forward
        if (str.startsWith("xhi")) {
            return countHi2(str.substring(3));
        }
        
        // If we find "hi", count it and move 2 characters forward
        if (str.startsWith("hi")) {
            return 1 + countHi2(str.substring(2));
        }
        
        // Otherwise, move 1 character forward
        return countHi2(str.substring(1));
    }

  public class HiCounterTest {

    @Test
    public void testCountHi2_normalCase() {
        assertEquals(1, HiCounter.countHi2("ahixhi"));
        assertEquals(2, HiCounter.countHi2("ahibhi"));
        assertEquals(0, HiCounter.countHi2("xhixhi"));
    }

    @Test
    public void testCountHi2_emptyString() {
        assertEquals(0, HiCounter.countHi2(""));
    }

    @Test
    public void testCountHi2_noHi() {
        assertEquals(0, HiCounter.countHi2("abc"));
        assertEquals(0, HiCounter.countHi2("xhix"));
    }

    @Test
    public void testCountHi2_multipleOccurrences() {
        assertEquals(3, HiCounter.countHi2("hihihi"));
        assertEquals(2, HiCounter.countHi2("hixhihi"));
        assertEquals(1, HiCounter.countHi2("xhixhi"));
    }
    
    @Test
    public void testCountHi2_complexCases() {
        assertEquals(3, HiCounter.countHi2("hiabchixhihixhi"));
        assertEquals(2, HiCounter.countHi2("hihixhi"));
    }
  }  
}

public class StringCount {
    // Recursive method to count occurrences of 'sub' in 'str'
    public static int strCount(String str, String sub) {
        // Base case: if the string is shorter than the substring, return 0
        if (str.length() < sub.length()) {
            return 0;
        }

        // If the string starts with the substring, increase count and skip the length of the substring
        if (str.startsWith(sub)) {
            return 1 + strCount(str.substring(sub.length()), sub);
        }

        // Otherwise, move forward one character and continue searching
        return strCount(str.substring(1), sub);
    }

  public class StringCountTest {
    
    @Test
    public void testSubPresentMultipleTimes() {
        // Test case where 'cat' appears twice in 'catcowcat'
        assertEquals(2, StringCount.strCount("catcowcat", "cat"));
    }

    @Test
    public void testSubPresentOnce() {
        // Test case where 'cow' appears once in 'catcowcat'
        assertEquals(1, StringCount.strCount("catcowcat", "cow"));
    }

    @Test
    public void testSubNotPresent() {
        // Test case where 'dog' does not appear in 'catcowcat'
        assertEquals(0, StringCount.strCount("catcowcat", "dog"));
    }

    @Test
    public void testSubEqualToStr() {
        // Test case where the entire string is equal to the substring
        assertEquals(1, StringCount.strCount("abc", "abc"));
    }

    @Test
    public void testEmptyString() {
        // Test case where the input string is empty
        assertEquals(0, StringCount.strCount("", "cat"));
      }
    }
  }

public class StringCleaner {

    public static String stringClean(String str) {
        // Base case: if the string is empty or has only one character, return it
        if (str.length() <= 1) {
            return str;
        }
        // If the first two characters are the same, remove the first and call recursively
        if (str.charAt(0) == str.charAt(1)) {
            return stringClean(str.substring(1));
        }
        // Otherwise, keep the first character and process the rest of the string
        return str.charAt(0) + stringClean(str.substring(1));
    }

  public class StringCleanerTest {

    @Test
    public void testStringClean1() {
        assertEquals("yza", StringCleaner.stringClean("yyzzza"));
    }

    @Test
    public void testStringClean2() {
        assertEquals("abcd", StringCleaner.stringClean("abbbcdd"));
    }

    @Test
    public void testStringClean3() {
        assertEquals("Helo", StringCleaner.stringClean("Hello"));
    }

    @Test
    public void testStringClean4() {
        assertEquals("abc", StringCleaner.stringClean("abc"));
    }

    @Test
    public void testStringClean5() {
        assertEquals("", StringCleaner.stringClean(""));
    }
  }
}







