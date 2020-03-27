package xyz.acrylicstyle.should.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static xyz.acrylicstyle.should.Should.*;

public class ShouldTest {
    @Test
    public void objectMustExactlyBe() { assert object(0).must().exactly().be().object(0); }

    @Test
    public void objectMustNotExactlyBe() { assert object(new Object()).must().not().exactly().be().object(new Object()); }

    @Test
    public void objectMustNotBe() { assert object(new Object()).must().not().be().object(new Object()); }

    @Test
    public void objectMustBe() { assert object("abc").should.be().object("abc"); }

    @SuppressWarnings("unused")
    private Object privateField = new Object();

    @Test
    public void objectShouldHavePrivateField() { assert object(this).should.have().privateField("privateField"); }

    @SuppressWarnings("unused")
    public static Object a = new Object();

    @Test
    public void objectShouldHaveField() { assert object(this).should.have().field("a"); }

    @Test
    public void objectShouldNotHaveField() { assert object(this).should.not().have().field("lol"); }

    @Test
    public void objectShouldHaveMethod() { assert object(this).should.have().method("objectShouldHaveMethod"); }

    @Test
    public void objectShouldNotHaveMethod() { assert object(this).should.not().have().method("non existent method"); }

    @SuppressWarnings("unused")
    private void a() {}

    @Test
    public void objectShouldHavePrivateMethod() { assert object(this).should.have().privateMethod("a"); }

    @Test
    public void objectShouldHaveNotPrivateMethod() { assert object(this).should.not().have().privateMethod("abc"); }

    @Test
    public void listShouldHaveSize() { assert object(Arrays.asList("A", "B", "C")).have().size(3); }

    @Test
    public void listShouldNotHaveSize() { assert object(Arrays.asList("A", "B", "C")).should.not().have().size(3000); }

    @Test
    public void mapShouldHaveValue() { assert map(Collections.singletonMap("A", "B")).should.have().value("A", "B"); }

    @Test
    public void mapShouldNotHaveValue() { assert map(Collections.singletonMap("A", "B")).should.not().have().value("A", "non existent value"); }

    @Test
    public void mapShouldHaveKey() { assert map(Collections.singletonMap("uhh", "unread value")).should.have().key("uhh"); }

    @Test
    public void mapShouldNotHaveKey() { assert map(Collections.singletonMap("aa", "no")).should.not().have().key("no"); }

    @Test
    public void listShouldHaveKey() { assert list(Arrays.asList("A", "B", "B")).should.have().key("B"); }

    @Test
    public void listShouldNotHaveKey() { assert list(Arrays.asList("A", "B", "C", "D")).should.not().have().key("-"); }

    @Test
    public void startsEndsWith() { assert object("Should").should.startsWith("Sh").endsWith("ld") != null; }

    @Test
    public void notStartsWith() { assert object("Should").should.startsWith("sho") == null; }

    @Test
    public void numberMustBeNumber() { assert object(Long.MAX_VALUE).must().be().number(); }

    @Test
    public void intMustBeInteger() { assert object(1).must().be().integer(); }

    @Test
    public void objectMustNotBeInteger() { assert object(1F).must().not().be().integer(); }

    @Test
    public void objectMustNotBeNumber() { assert object("its not number").must().not().be().number(); }

    @Test
    public void objectMustNotBeParsableInteger() { assert object("nan").must().not().be().parsableInteger(); }

    @Test
    public void objectShouldExist() { assert object(new Object()).exist().ok(); }

    @Test
    public void nullShouldNotExist() { assert object(null).should.not().exist().ok(); }
}
