package meugeninua.fetchgithubrepositories.model.json.writers.impls;

import android.util.JsonWriter;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import meugeninua.fetchgithubrepositories.model.json.writers.EntityWriter;

abstract class AbstractWriter<T> implements EntityWriter<T> {

    @Override
    public void write(final Writer writer, final T entity) throws IOException {
        JsonWriter jsonWriter = null;
        try {
            jsonWriter = new JsonWriter(writer);
            write(jsonWriter, entity);
        } finally {
            if (jsonWriter != null) {
                jsonWriter.close();
            }
        }
    }

    protected abstract void write(final JsonWriter writer, final T entity) throws IOException;

    void value(final JsonWriter writer, final List<String> strings) throws IOException {
        writer.beginArray();
        for (String string : strings) {
            writer.value(string);
        }
        writer.endArray();
    }
}
