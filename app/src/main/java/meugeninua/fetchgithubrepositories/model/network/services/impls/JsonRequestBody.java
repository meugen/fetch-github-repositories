package meugeninua.fetchgithubrepositories.model.network.services.impls;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

import meugeninua.fetchgithubrepositories.model.json.writers.EntityWriter;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

class JsonRequestBody<T> extends RequestBody {

    private static final MediaType CONTENT_TYPE = MediaType
            .parse("application/json; charset=utf-8");
    private static final Charset UTF_8 = Charset.forName("utf-8");

    private final EntityWriter<T> entityWriter;
    private final T body;

    JsonRequestBody(
            final EntityWriter<T> entityWriter,
            final T body) {
        this.entityWriter = entityWriter;
        this.body = body;
    }

    @Override
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    @Override
    public void writeTo(@NonNull final BufferedSink sink) throws IOException {
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(sink.outputStream(), UTF_8);
            entityWriter.write(writer, body);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
