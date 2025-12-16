package br.com.makersweb.picpay.domain.exceptions;

/**
 * @author aoaristides
 */
public class NoStacktraceException extends RuntimeException {

    public NoStacktraceException(final String message) {
        this(message, null);
    }

    public NoStacktraceException(final String message, final Throwable cause) {
        super(message, cause, true, false);
    }

}
