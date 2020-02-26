package warmup10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    Filter obj=new Filter();

    @Test
    void Test1() {
        String expected="svl";
        String actual=obj.Filterit("Sevil");
        assertEquals(expected,actual);
    }

}