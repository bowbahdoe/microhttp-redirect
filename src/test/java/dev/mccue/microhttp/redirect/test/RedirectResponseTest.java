package dev.mccue.microhttp.redirect.test;

import dev.mccue.microhttp.redirect.RedirectResponse;
import org.junit.jupiter.api.Test;
import org.microhttp.Header;
import org.microhttp.Response;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedirectResponseTest {
    @Test
    public void testPermanent() {
        var r = RedirectResponse.permanent("/a/b/c")
                .intoResponse();
        assertEquals(
                new Response(
                        308, "Permanent Redirect", List.of(new Header("Location", "/a/b/c")), r.body()),
                r
        );
        assertEquals(0, r.body().length);
    }

    @Test
    public void testTemporary() {
        var r = RedirectResponse.temporary("/a/b/c")
                .intoResponse();
        assertEquals(
                new Response(
                        307, "Temporary Redirect", List.of(new Header("Location", "/a/b/c")), r.body()),
                r
        );
        assertEquals(0, r.body().length);
    }

    @Test
    public void testFound() {
        var r = RedirectResponse.found("/a/b/c")
                .intoResponse();
        assertEquals(
                new Response(
                        302, "Found", List.of(new Header("Location", "/a/b/c")), r.body()),
                r
        );
        assertEquals(0, r.body().length);
    }

    @Test
    public void testMovedPermanently() {
        var r = RedirectResponse.movedPermanently("/a/b/c")
                .intoResponse();
        assertEquals(
                new Response(
                        301, "Moved Permanently", List.of(new Header("Location", "/a/b/c")), r.body()),
                r
        );
        assertEquals(0, r.body().length);
    }

    @Test
    public void testSeeOther() {
        var r = RedirectResponse.seeOther("/a/b/c")
                .intoResponse();
        assertEquals(
                new Response(
                        303, "See Other", List.of(new Header("Location", "/a/b/c")), r.body()),
                r
        );
        assertEquals(0, r.body().length);
    }
}
