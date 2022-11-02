package animalwiki.backend.util;

import animalwiki.backend.util.constants.MessageConstants;
import animalwiki.backend.util.constants.RedisConstants;

public class AnimalWikiStringTools {

    public static String getAnimalNamesSetKey() {
        return RedisConstants.ANIMAL_NAMES_KEY;
    }

    public static String getAnimalTypesSetKey() {
        return RedisConstants.ANIMAL_TYPES_KEY;
    }

    public static String getAnimalAlreadyExistsMsg() {
        return MessageConstants.ANIMAL_ALREADY_EXISTS_MSG;
    }

    public static String getAnimalNotFoundMsg() {
        return MessageConstants.ANIMAL_NOT_FOUND_MSG;
    }

    public static String getBadRequestMsg() {
        return MessageConstants.BAD_REQUEST_MSG;
    }

    public static String getInternalServerErrorMsg() {
        return MessageConstants.INTERNAL_SERVER_ERROR_MSG;
    }

    public static String getWrongNameInRequestMsg() {
        return MessageConstants.WRONG_NAME_IN_REQUEST_MSG;
    }
}
