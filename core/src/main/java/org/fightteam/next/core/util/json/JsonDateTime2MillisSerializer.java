package org.fightteam.next.core.util.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;

import java.io.IOException;

/**
 * jodaTime json输出格式
 * <p/>
 * 以毫秒输出
 *
 * @author faith
 * @since 0.0.1
 */
public class JsonDateTime2MillisSerializer extends JsonSerializer<DateTime> {

    @Override
    public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException {
        jgen.writeNumber(value.getMillis());
    }
}
