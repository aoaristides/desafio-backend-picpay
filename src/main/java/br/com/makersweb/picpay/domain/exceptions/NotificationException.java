package br.com.makersweb.picpay.domain.exceptions;

import br.com.makersweb.picpay.domain.validation.handler.Notification;

/**
 * @author aoaristides
 */
public class NotificationException extends DomainException {

    public NotificationException(final String aMessage, final Notification notification) {
        super(aMessage, notification.getErrors());
    }

}
