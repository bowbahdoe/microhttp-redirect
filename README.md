# microhttp-redirect

Utility for producing a redirect response.

## Dependency Information

### Maven

```xml
<dependency>
    <groupId>dev.mccue</groupId>
    <artiactId>microhttp-redirect</artiactId>
    <version>2024.04.20</version>
</dependency>
```

### Gradle

```groovy
dependencies {
    implementation('dev.mccue:microhttp-redirect:2024.04.20')
}
```

## Usage

```java
import dev.mccue.microhttp.handler.IntoResponse;
import dev.mccue.microhttp.handler.RouteHandler;
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
