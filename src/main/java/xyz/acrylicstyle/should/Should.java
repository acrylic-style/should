package xyz.acrylicstyle.should;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.javascript.JavaScript;

import java.util.List;
import java.util.Map;

public class Should<T> {
    Object o;
    boolean invert = false;

    private Should<T> setInvert(boolean invert) {
        this.invert = invert;
        return this;
    }

    public Should(Object o) {
        this.o = o;
    }

    /**
     * "Object" must be object.
     */
    @NotNull
    @Contract("_ -> new")
    public static <T> Should<T> object(T o) {
        return new Should<T>(o);
    }

    @NotNull
    @Contract("_ -> new")
    public static <A, B> Should<Map<A, B>> map(Map<A, B> map) { return new Should<Map<A, B>>(map); }

    @NotNull
    @Contract("_ -> new")
    public static <T> Should<List<T>> list(List<T> map) { return new Should<List<T>>(map); }

    /**
     * "Object" must be object.
     */
    @NotNull
    @Contract("_ -> new")
    public static Should<Object> objectNoType(Object o) {
        return new Should<Object>(o);
    }

    /*
     * Simple chaining to improve readability. Does nothing.
     */
    public Should<T> an = this;
    public Should<T> of = this;
    public Should<T> a = this;
    public Should<T> and = this;
    public Should<T> been = this;
    public Should<T> with = this;
    public Should<T> should = this;

    public Must<T> is() { return must(); }

    /**
     * Object "must" ...
     */
    public Must<T> must() {
        return new Must<T>(should).setInvert(invert);
    }

    /**
     * Should "not" ...
     */
    public Should<T> not() {
        return this.setInvert(!invert);
    }

    /**
     * Should not ...
     */
    public Should<T> shouldNot() { return this.setInvert(!invert); }

    /**
     * Shouldnt ...
     */
    public Should<T> shouldnt() { return this.setInvert(!invert); }

    /**
     * Should "exactly"
     */
    public Must<T> exactly()  { return must().exactly(); }

    /**
     * Should "be" object
     */
    public Must<T> be() {
        return must().be();
    }

    public boolean ok() { return must().ok(); }

    public boolean true_() { return must().true_(); }

    public boolean false_() { return must().false_(); }

    public Have<T> have() { return new Have<T>(this).setInvert(invert); }

    public Have<T> has() { return new Have<T>(this).setInvert(invert); }

    public Should<T> exist() {
        if (invert) {
            return should.o == null ? new Should<T>(this) : null;
        } else {
            return should.o == null ? null : new Should<T>(this);
        }
    }

    public Should<T> startsWith(String s) {
        if (should.o instanceof String) {
            return invert != ((String) should.o).startsWith(s) ? this : null;
        }
        return null;
    }

    public Should<T> endsWith(String s) {
        if (should.o instanceof String) {
            return invert != ((String) should.o).endsWith(s) ? this : null;
        }
        return null;
    }
}
