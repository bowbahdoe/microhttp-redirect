# microhttp-cookies

Utility for producing a redirect response.

## Dependency Information

### Maven

```xml
<dependency>
    <groupId>dev.mccue</groupId>
    <artiactId>microhttp-redirect</artiactId>
    <version>0.0.2</version>
</dependency>
```

### Gradle

```groovy
dependencies {
    implementation('dev.mccue:microhttp-redirect:0.0.2')
}
```

## Usage

```java
import dev.mccue.microhttp.handler.IntoResponse;
import dev.mccue.microhttp.handler.RouteHandler;
import org.jspecify.annotations.Nullable;
import org.microhttp.Request;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SomeHandler extends RouteHandler {
    public SomeHandler() {
        super("GET", Pattern.compile("/some/path"));
    }

    @Override
    protected IntoResponse handleRoute(Matcher matcher, Request request) {
        return RedirectResponse.seeOther("/path/to/redirect/to");
    }
}
```