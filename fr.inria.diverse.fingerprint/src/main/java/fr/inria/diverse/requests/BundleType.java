package fr.inria.diverse.requests;


/**
 * TODO: Add serializer for the resteasy client request
 * The type of bundle to be created
 */
public enum BundleType {
    /**
     * Flat bundles are simple tarballs that can be read without any specialized software
     */
    FLAT,
    /**
     * A gzip-compressed git fast-export
     */
    GITFAST,
    /**
     * A tarball that can be decompressed to get a real git repository. It is without a checkout, so it is the equivalent of what one would get with git clone --bare
     */
    GITBARE
}
