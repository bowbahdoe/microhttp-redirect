package dev.mccue.microhttp.redirect;

import dev.mccue.microhttp.handler.IntoResponse;
import dev.mccue.reasonphrase.ReasonPhrase;
import org.microhttp.Header;
import org.microhttp.Response;

import java.util.List;
import java.util.Objects;

public final class RedirectResponse implements IntoResponse {
    enum Status {
        MOVED_PERMANENTLY(301),
        FOUND(302),
        SEE_OTHER(303),
        TEMPORARY_REDIRECT(307),
        PERMANENT_REDIRECT(308);

        final int code;
        Status(int code) {
            this.code = code;
        }
    }

    private final Status status;
    private final String location;

    private RedirectResponse(Status status, String location) {
        this.status = status;
        this.location = Objects.requireNonNull(location);
    }

    public static RedirectResponse movedPermanently(String location) {
        return new RedirectResponse(Status.MOVED_PERMANENTLY, location);
    }

    public static RedirectResponse found(String location) {
        return new RedirectResponse(Status.FOUND, location);
    }

    public static RedirectResponse seeOther(String location) {
        return new RedirectResponse(Status.SEE_OTHER, location);
    }

    public static RedirectResponse temporary(String location) {
        return new RedirectResponse(Status.TEMPORARY_REDIRECT, location);
    }

    public static RedirectResponse permanent(String location) {
        return new RedirectResponse(Status.PERMANENT_REDIRECT, location);
    }

    @Override
    public Response intoResponse() {
        return new Response(
                status.code,
                ReasonPhrase.forStatus(status.code),
                List.of(new Header("Location", location)),
                new byte[]{}
        );
    }

    @Override
    public String toString() {
        return "RedirectResponse[" +
               "status=" + status +
               ", location='" + location + '\'' +
               ']';
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof RedirectResponse response
                && status == response.status
                && location.equals(response.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, location);
    }
}
