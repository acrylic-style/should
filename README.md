# Should
An assertion library for Java

## How to use
```java
import xyz.acrylicstyle.should.*;
import java.util.Arrays;
import java.util.Collections;

import static xyz.acrylicstyle.should.Should.*;

public class Test {
    public static void main(String[] args) {
        assert object(null).should.not().exist().ok(); // object[null] should not exist
        assert object(new Object()).should.exist().ok(); // object[object] should exist
        assert list(Arrays.asList(1, 2, 3)).should.have().size(3); // list should have size: 3
        assert map(Collections.singletonMap("k", "v")).should.not().have().key("aaa"); // map should not have key: aaa
        assert object(1).should.be().sameAs(1); // object(1) should be same as 1
        assert object("A-B").should.startsWith("A").and.endsWith("B").ok(); // object(A-B) should starts with A and ends with B
    }
}
```