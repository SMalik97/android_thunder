package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
    public final JsonElement parse(String str) throws JsonSyntaxException {
        return parse(new StringReader(str));
    }

    public final JsonElement parse(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement parse = parse(jsonReader);
            if (parse.isJsonNull() || jsonReader.peek() == JsonToken.END_DOCUMENT) {
                return parse;
            }
            throw new JsonSyntaxException("Did not consume the entire document.");
        } catch (Throwable e) {
            throw new JsonSyntaxException(e);
        } catch (Throwable e2) {
            throw new JsonIOException(e2);
        } catch (Throwable e22) {
            throw new JsonSyntaxException(e22);
        }
    }

    public final JsonElement parse(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            JsonElement parse = Streams.parse(jsonReader);
            jsonReader.setLenient(isLenient);
            return parse;
        } catch (Throwable e) {
            throw new JsonParseException(new StringBuilder("Failed parsing JSON source: ").append(jsonReader).append(" to Json").toString(), e);
        } catch (Throwable e2) {
            throw new JsonParseException(new StringBuilder("Failed parsing JSON source: ").append(jsonReader).append(" to Json").toString(), e2);
        } catch (Throwable th) {
        }
    }
}
