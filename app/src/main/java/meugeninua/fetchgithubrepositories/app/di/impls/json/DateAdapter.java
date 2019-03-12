package meugeninua.fetchgithubrepositories.app.di.impls.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);

    @Override
    public Date deserialize(
            final JsonElement json,
            final Type typeOfT,
            final JsonDeserializationContext context) throws JsonParseException {
        try {
            return formatter.parse(json.getAsString());
        } catch (ParseException e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public JsonElement serialize(
            final Date src,
            final Type typeOfSrc,
            final JsonSerializationContext context) {
        return new JsonPrimitive(formatter.format(src));
    }
}
