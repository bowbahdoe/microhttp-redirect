package dev.mccue.microhttp.redirect;

import dev.mccue.microhttp.handler.IntoResponse;
import dev.mccue.reasonphrase.ReasonPhrase;
import org.microhttp.Header;
import org.microhttp.Response;

import java.util.List;

public final class RedirectResponse implements IntoResponse {
    enum StatusCode {
        MOVED_PERMANENTLY(301),
        FOUND(302),
        SEE_OTHER(303),
        TEMPORARY_REDIRECT(307),
        PERMANENT_REDIRECT(308);

        final int code;
        StatusCode(int code) {
            this.code = code;
        }
    }

    private final StatusCode statusCode;
    private final String location;

    private RedirectResponse(StatusCode statusCode, String location) {
        this.statusCode = statusCode;
        this.location = location;
    }

    public static RedirectResponse movedPermanently(String location) {
        return new RedirectResponse(StatusCode.MOVED_PERMANENTLY, location);
    }

    public static RedirectResponse found(String location) {
        return new RedirectResponse(StatusCode.FOUND, location);
    }

    public static RedirectResponse seeOther(String location) {
        return new RedirectResponse(StatusCode.SEE_OTHER, location);
    }

    public static RedirectResponse temporary(String location) {
        return new RedirectResponse(StatusCode.TEMPORARY_REDIRECT, location);
    }

    public static RedirectResponse permanent(String location) {
        return new RedirectResponse(StatusCode.PERMANENT_REDIRECT, location);
    }

    @Override
    public Response intoResponse() {
        return new Response(
                statusCode.code,
                ReasonPhrase.forStatus(statusCode.code),
                List.of(new Header("Location", location)),
                new byte[]{}
        );
    }
}
