/*
 * Copyright (c) 2014. Yuri Rychkov. Russia.
 * Some Rights Reserved.
 */

package ru.subscribe.pro.api.utils;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

/**
 * Gson based parser.
 *
 * @author Yuri Rychkov
 */
public final class JsonUtils {
    /**
     * Constructor.
     */
    private JsonUtils() {
    }


    /**
     * Parse JSON stream.
     *
     * @param json json
     * @return parsed object Map for JSONObject or List for JSONArray
     * @throws java.io.IOException if I/O errors occurred
     */
    public static Object parse(String json) throws IOException {
        try (JsonReader reader = new JsonReader(new StringReader(json))) {
            Object result = null;
            while (true) {
                JsonToken token = reader.peek();
                switch (token) {
                    case BEGIN_OBJECT:
                        reader.beginObject();
                        result = parseObject(reader, null);
                        break;
                    case END_OBJECT:
                        reader.endObject();
                        break;
                    case BEGIN_ARRAY:
                        reader.endArray();
                        result = parseArray(reader);
                        break;
                    case END_ARRAY:
                        reader.endArray();
                        break;
                    case END_DOCUMENT:
                        return result;
                    default:
                        throw new IOException("unexpected " + token);
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }


    private static Map<String, Object> parseObject(JsonReader reader, String theName) throws IOException {
        Map<String, Object> map = new HashMap<>();
        String name = theName;
        while (true) {
            JsonToken token = reader.peek();
            switch (token) {
                case NAME:
                    name = reader.nextName();
                    break;
                case STRING:
                    map.put(name, reader.nextString());
                    break;
                case BOOLEAN:
                    map.put(name, reader.nextBoolean());
                    break;
                case NUMBER:
                    map.put(name, reader.nextString());
                    break;
                case NULL:
                    reader.nextNull();
                    map.put(name, null);
                    break;
                case BEGIN_ARRAY:
                    reader.beginArray();
                    map.put(name, parseArray(reader));
                    break;
                case END_ARRAY:
                    reader.endArray();
                    break;
                case BEGIN_OBJECT:
                    reader.beginObject();
                    map.put(name, parseObject(reader, name));
                    break;
                case END_OBJECT:
                    reader.endObject();
                    return map;
                default:
                    throw new IOException("unexpected " + token);
            }
        }
    }

    private static List<Object> parseArray(JsonReader reader) throws IOException {
        List<Object> list = new ArrayList<>();
        while (true) {
            JsonToken token = reader.peek();
            switch (token) {
                case STRING:
                    list.add(reader.nextString());
                    break;
                case BOOLEAN:
                    list.add(reader.nextBoolean());
                    break;
                case NUMBER:
                    list.add(reader.nextString());
                    break;
                case NULL:
                    reader.nextNull();
                    list.add(null);
                    break;
                case BEGIN_ARRAY:
                    reader.beginArray();
                    list.add(parseArray(reader));
                    break;
                case END_ARRAY:
                    reader.endArray();
                    return list;
                case BEGIN_OBJECT:
                    reader.beginObject();
                    list.add(parseObject(reader, null));
                    break;
                case END_OBJECT:
                    reader.endObject();
                    break;
                default:
                    throw new IOException("unexpected " + token);
            }
        }
    }
}
