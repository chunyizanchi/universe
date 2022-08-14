package com.cyzc.designpattern.test;


import com.cyzc.designpattern.exercise.after.RandomIdGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * <p>RandomIdGeneratorTest 单元测试
 *
 * @author Cyzc
 * @since [2021/12/30 13:22]
 */
public class RandomIdGeneratorTest {

    @Test
    @DisplayName("测试 GetLastSubstrSplittedByDot")
    public void testGetLastSubstrSplittedByDot() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();

        String actualSubstr = idGenerator.getLastSubstrSplittedByDot(
                "field1.field2.field3");

        Assertions.assertEquals("field3", actualSubstr);

        actualSubstr = idGenerator.getLastSubstrSplittedByDot(
                "field1");

        Assertions.assertEquals("field1", actualSubstr);

        actualSubstr = idGenerator.getLastSubstrSplittedByDot(
                "field1#field2#field3");

        Assertions.assertEquals("field1#field2#field3", actualSubstr);
    }

    @Test
    @DisplayName("host 为空的情况")
    public void testGetLastSubstrSplittedByDot_nullOrEmpty() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualSubstr = idGenerator.getLastSubstrSplittedByDot(null);
        Assertions.assertNull(actualSubstr);
        actualSubstr = idGenerator.getLastSubstrSplittedByDot("");
        Assertions.assertEquals("", actualSubstr);
    }

    @Test
    public void testGenerateRandomAlphameric() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualRandomString = idGenerator.generateRandomAlphameric(6);
        Assertions.assertNotNull(actualRandomString);
        Assertions.assertEquals(6, actualRandomString.length());
        for (char c : actualRandomString.toCharArray()) {
            Assertions.assertTrue(
                    ('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z'));
        }
    }

    @Test
    public void testGenerateRandomAlphameric_lengthEqualsOrLessThanZero() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualRandomString = idGenerator.generateRandomAlphameric(0);
        Assertions.assertEquals("", actualRandomString);
        actualRandomString = idGenerator.generateRandomAlphameric(-1);
        Assertions.assertNull(actualRandomString);
    }


}
