package ia.nazarov.test.gamesys.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RussianMapperTests {
    Word2NumMapperRu mapper = new Word2NumMapperRu();

    @Test
    public void BasicTest() {
        Assertions.assertEquals("398", mapper.map("корова"));
        Assertions.assertEquals("", mapper.map("ааааааа"));
        Assertions.assertEquals("555888", mapper.map("бббввв"));
        Assertions.assertEquals("888", mapper.map("ВвВ"));
        Assertions.assertEquals("", mapper.map(""));
        Assertions.assertEquals("", mapper.map("789098797"));
        Assertions.assertEquals("0000005", mapper.map("НаНанАААНаНаМБЫ"));
        Assertions.assertEquals("", mapper.map("!@#$%^&*()_-+="));
    }
}
