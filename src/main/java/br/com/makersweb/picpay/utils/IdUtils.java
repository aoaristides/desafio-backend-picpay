package br.com.makersweb.picpay.utils;

import java.util.UUID;

/**
 * @author aoaristides
 */
public final class IdUtils {

    private IdUtils() {}

    public static String uuid() {
        return UUID.randomUUID().toString().toLowerCase();
    }

}
