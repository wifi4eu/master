package wifi4eu.wifi4eu.service.financial;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Date;

final class TimestampTypeAdapter extends TypeAdapter<Date> {
    private static final TypeAdapter<Date> timestampTypeAdapter = new TimestampTypeAdapter();

    public static TypeAdapter<Date> getTimestampTypeAdapter() {
        return timestampTypeAdapter;
    }

    @Override
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        if (date != null) {
            jsonWriter.value(date.getTime());
        }
    }

    @Override
    public Date read(JsonReader jsonReader) throws IOException {
        return new Date(jsonReader.nextLong());
    }
}