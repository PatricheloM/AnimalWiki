package animalwiki.backend.util;

import animalwiki.backend.util.constants.RedisConstants;

public class AnimalWikiTools {

    public static String getAnimalNamesSetKey() {
        return RedisConstants.ANIMAL_NAMES_KEY;
    }

    public static String getAnimalTypesSetKey() {
        return RedisConstants.ANIMAL_TYPES_KEY;
    }
}
