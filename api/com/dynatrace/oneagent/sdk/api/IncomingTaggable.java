package com.dynatrace.oneagent.sdk.api;

/**
 * Common interface to allow incoming requests to be linked to outgoing requests via tags.
 */
public interface IncomingTaggable {

	/**
	 * Sets the tag using the string format.
	 * Sets a tag retrieved from an {@link OutgoingTaggable} tracer using {@link OutgoingTaggable#getDynatraceStringTag()}.
	 * A tag can only be set *before* a tracer is started.
	 *
	 * To allow tracing across process and technology boundaries, tracers can be supplied with so-called tags.
	 * Tags are strings or byte arrays generated by the SDK that enable Dynatrace to trace a transaction end-to-end.
	 * The user has to take care of transporting the tag from one process/service to the other.
	 * 
	 * At most one tag can be set for each tracer. Calling this method more than once will therefore overwrite any
	 * tag that was set by either {@link #setDynatraceByteTag(byte[])} or {@link #setDynatraceStringTag(String)}
	 * (unless the tracer was already started, in which case any further changes are ignored).
	 * 
	 * @param tag
	 *            if null or an empty string, the incoming tag will be reset (cleared).
	 * 
	 */
	void setDynatraceStringTag(String tag);

	/**
	 * Same as {@link #setDynatraceStringTag(String)} but tag is used in binary format
	 * as returned by {@link OutgoingTaggable#getDynatraceByteTag(byte[])}.
	 * 
	 * @param tag
	 *            if null or an empty string, the incoming tag will be reset (cleared).
	 */
	void setDynatraceByteTag(byte[] tag);

}