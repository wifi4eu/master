package wifi4eu.wifi4eu.common.helper;


final public class Validator {

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean isNotNull(Long l) {
        return !isNull(l);
    }

    public static boolean isNotNull(String s) {
        return !isNull(s);
    }

    public static boolean isNotNull(Object[] array) {
        return !isNull(array);
    }

    public static boolean isNull(Object obj) {
        if (obj instanceof Long) {
            return isNull((Long)obj);
        }
        else if (obj instanceof String) {
            return isNull((String)obj);
        }
        else if (obj == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isNull(Long l) {
        if ((l == null) || l.longValue() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isNull(String s) {
        if (s == null) {
            return true;
        }

        s = s.trim();

        if ((s.equals(StringPool.NULL)) || (s.equals(StringPool.BLANK))) {
            return true;
        }

        return false;
    }

    public static boolean isNull(Object[] array) {
        if ((array == null) || (array.length == 0)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isEmpty(String s) {
        if (s == null) {
            return true;
        }

        return s.isEmpty();
    }
    
    public static boolean isNotEmpty(String s) {
    	return !isNull(s);
    }
}
