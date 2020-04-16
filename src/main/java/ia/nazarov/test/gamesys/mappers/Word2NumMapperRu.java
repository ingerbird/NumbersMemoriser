package ia.nazarov.test.gamesys.mappers;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple implementation of Russian language mapper
 * It is String to String because of arbitrary length and possible zeroes in front
 */
public class Word2NumMapperRu implements BasicMapper<String, String> {
    private static Map<Character, Integer> dictionary = null;

    public Word2NumMapperRu() {
        if (dictionary == null) {
            dictionary = new HashMap<>();
            dictionary.put('г', 1);
            dictionary.put('ж', 1);
            dictionary.put('д', 2);
            dictionary.put('т', 2);
            dictionary.put('к', 3);
            dictionary.put('х', 3);
            dictionary.put('ч', 4);
            dictionary.put('щ', 4);
            dictionary.put('б', 5);
            dictionary.put('п', 5);
            dictionary.put('ш', 6);
            dictionary.put('л', 6);
            dictionary.put('з', 7);
            dictionary.put('с', 7);
            dictionary.put('в', 8);
            dictionary.put('ф', 8);
            dictionary.put('р', 9);
            dictionary.put('ц', 9);
            dictionary.put('н', 0);
            dictionary.put('м', 0);
        }
    }

    @Override
    public String map(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch: input.toLowerCase().toCharArray()) {
            if (dictionary.containsKey(ch)) {
                stringBuilder.append(dictionary.get(ch));
            }
        }
        return stringBuilder.toString();
    }
}
