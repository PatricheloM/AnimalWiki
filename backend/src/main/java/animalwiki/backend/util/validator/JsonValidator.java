package animalwiki.backend.util.validator;

import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;

public class JsonValidator {

    public static final JsonSchema jsonSchema = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4)
            .getSchema(JsonValidator.class.getResourceAsStream("schema.json"));

    public static boolean validate(JsonNode json)
    {
        return jsonSchema.validate(json).isEmpty();
    }
}
