package br.com.makersweb.picpay.utils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * @author aoaristides
 */
public final class InstantUtils {

    private InstantUtils() {
    }

    public static Instant now() {
        return Instant.now().truncatedTo(ChronoUnit.MICROS);
    }

}
