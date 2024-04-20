import org.jspecify.annotations.NullMarked;

@NullMarked
module dev.mccue.microhttp.redirect {
    requires transitive org.microhttp;
    requires transitive dev.mccue.microhttp.handler;
    requires dev.mccue.reasonphrase;
    requires static org.jspecify;

    exports dev.mccue.microhttp.redirect;
}