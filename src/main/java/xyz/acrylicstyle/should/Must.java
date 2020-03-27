package xyz.acrylicstyle.should;

import util.javascript.JavaScript;

public class Must<T> {
    Should<T> should;
    private boolean exact = false;
    private boolean invert = false;
    private Must<T> parent;

    Must(Should<T> should) {
        parent = this;
        this.should = should;
    }

    private Must<T> setExact(boolean exact) {
        this.exact = exact;
        return this;
    }

    Must<T> setInvert(boolean invert) {
        this.invert = invert;
        return this;
    }

    /**
     * Checks if "must" param equals with this object.
     * @param must A Must object that compares to.
     * @return If two must objects are same or not.
     */
    public boolean equals(Must<T> must) {
        return super.equals(must);
    }

    public Must<T> be() {
        return this;
    }

    public boolean true_() {
        return JavaScript.If(should.o);
    }

    public boolean false_() {
        return !JavaScript.If(should.o);
    }

    public boolean ok() { return true_(); }

    public boolean object(Object o) {
        if (invert) {
            if (exact) return this.should.o != o;
            return !this.should.o.equals(o);
        } else {
            if (exact) return this.should.o == o;
            return this.should.o.equals(o);
        }
    }

    public boolean parsableInteger() {
        if (should.o instanceof Integer) return !invert;
        if (!(should.o instanceof String)) return invert;
        try {
            Integer.parseInt((String) should.o);
            return !invert;
        } catch (NumberFormatException ignored) {
            return invert;
        }
    }

    public Should<T> exist() { return should.exist(); }

    public boolean integer() { return invert != (should.o instanceof Integer); }

    public boolean number() { return invert != (should.o instanceof Number); }

    public Have<T> have() { return new Have<T>(should).setInvert(invert); }

    public Must<T> not() { return new Must<T>(should).setExact(parent.exact).setInvert(!parent.invert); }

    public Must<T> exactly() { return new Must<T>(should).setExact(!parent.exact).setInvert(parent.invert); }

    @Override
    public String toString() { return "Must{" + "should=" + should + ", exact=" + exact + ", invert=" + invert + "}"; }
}
