package cloud.timo.TimoCloud.api.messages.objects;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A plugin message is an object just containing data.
 * It basically consists of a map where data can be stored.
 * The class provides methods to retrieve certain data types easily.
 *
 * Please be aware that you'll just be able to send serializable data (Strings, Integers, ...)
 */
public class PluginMessage {

    private String type;
    private Map<String, Object> data;

    public PluginMessage(String type) {
        this(type, new HashMap<>());
    }

    public PluginMessage(String type, Map<String, Object> data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Object getObject(String key) {
        return getData().get(key);
    }

    public Set<String> getKeys() {
        return getData().keySet();
    }

    public Integer getInteger(String key) {
        Object object = getObject(key);
        if (object == null) return null;
        return ((Number) object).intValue();
    }

    public Long getLong(String key) {
        Object object = getObject(key);
        if (object == null) return null;
        return ((Number) object).longValue();
    }

    public Short getShort(String key) {
        Object object = getObject(key);
        if (object == null) return null;
        return ((Number) object).shortValue();
    }

    public Double getDouble(String key) {
        Object object = getObject(key);
        if (object == null) return null;
        return ((Number) object).doubleValue();
    }

    public Float getFloat(String key) {
        Object object = getObject(key);
        if (object == null) return null;
        return ((Number) object).floatValue();
    }

    public String getString(String key) {
        return (String) getObject(key);
    }

    public PluginMessage setType(String type) {
        this.type = type;
        return this;
    }

    public PluginMessage set(String key, Object value) {
        getData().put(key, value);
        return this;
    }
}
