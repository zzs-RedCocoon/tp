import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParserTest {
    @Test
    void testParser() {
        String s = "hello world";
        String[] result = new String[2];
        result[0] = "hello";
        result[1] = "world";
        assertEquals(result[0],Parser.parseCommand(s)[0]);
        assertEquals(result[1],Parser.parseCommand(s)[1]);
    }
    @Test
    void testParseIndex() {
        String s = "0";
        assertEquals(0,Parser.parseIndex(s, 0,5));
    }
}
