package xyz.acrylicstyle.should;

import java.util.Collection;
import java.util.Map;

public class Have<T> {
    Should<T> should;
    private boolean invert = false;

    Have(Should<T> should) {
        this.should = should;
    }

    Have<T> setInvert(boolean invert) {
        this.invert = invert;
        return this;
    }

    public Have<T> not() {
        return this.setInvert(!invert);
    }

    public boolean field(String name) {
        try {
            should.o.getClass().getField(name);
            return !invert;
        } catch (NoSuchFieldException e) {
            return invert;
        }
    }

    public boolean privateField(String name) {
        try {
            should.o.getClass().getDeclaredField(name);
            return !invert;
        } catch (NoSuchFieldException e) {
            return invert;
        }
    }

    public boolean method(String name) {
        try {
            should.o.getClass().getMethod(name);
            return !invert;
        } catch (NoSuchMethodException e) {
            return invert;
        }
    }

    public boolean privateMethod(String name) {
        try {
            should.o.getClass().getDeclaredMethod(name);
            return !invert;
        } catch (NoSuchMethodException e) {
            return invert;
        }
    }

    public boolean size(int size) {
        boolean flag = false;
        if (should.o instanceof Collection) {
            flag = ((Collection<?>) should.o).size() == size;
        } else if (should.o instanceof Iterable) {
            int length = 0;
            for (Object ignored : (Iterable<?>) should.o) length++;
            flag = length == size;
        } else if (should.o instanceof Map) {
            flag = ((Map<?, ?>) should.o).size() == size;
        }
        if (should.o instanceof Collection
                || should.o instanceof Iterable
                || should.o instanceof Map) return invert != flag;
        throw new ClassCastException(should.o.getClass().getCanonicalName() + " cannot be cast to Iterable/Collection/Map");
    }

    public boolean value(Object key, Object value) {
        if (should.o instanceof Map) {
            Object o = ((Map<?, ?>) should.o).get(key);
            if (o == null) return invert;
            if (o == value) return !invert;
            return invert != o.equals(value);
        }
        throw new ClassCastException(should.o.getClass().getCanonicalName() + " cannot be cast to Map");
    }

    public boolean key(Object key) {
        if (should.o instanceof Map) {
            return invert != ((Map<?, ?>) should.o).containsKey(key);
        } else if (should.o instanceof Collection) {
            return invert != ((Collection<?>) should.o).contains(key);
        } else if (should.o instanceof Iterable) {
            for (Object o : (Iterable<?>) should.o) {
                if (o.equals(key)) return !invert;
            }
        }
        throw new ClassCastException(should.o.getClass().getCanonicalName() + " cannot be cast to Iterable/Collection/Map");
    }
}
