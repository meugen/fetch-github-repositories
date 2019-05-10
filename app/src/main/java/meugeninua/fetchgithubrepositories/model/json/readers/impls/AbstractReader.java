package meugeninua.fetchgithubrepositories.model.json.readers.impls;

import android.util.JsonReader;
import android.util.JsonToken;

import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import meugeninua.fetchgithubrepositories.model.json.readers.EntityReader;

abstract class AbstractReader<T> implements EntityReader<T> {

    private static SimpleDateFormat FORMATTER
            = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);

    @Override
    public final T read(final Reader reader) throws IOException {
        JsonReader jsonReader = null;
        try {
            jsonReader = new JsonReader(reader);
            return read(jsonReader);
        } finally {
            if (jsonReader != null) {
                jsonReader.close();
            }
        }
    }

    protected abstract T read(final JsonReader reader) throws IOException;

    final List<String> nextStrings(final JsonReader reader) throws IOException {
        List<String> result = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            result.add(reader.nextString());
        }
        reader.endArray();
        return result;
    }

    final Date nextDate(final JsonReader reader) throws IOException {
        try {
            return FORMATTER.parse(reader.nextString());
        } catch (ParseException e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    final String nextStringOrNull(final JsonReader reader) throws IOException {
        JsonToken token = reader.peek();
        if (token == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        return reader.nextString();
    }
}
