package br.com.makersweb.picpay.domain.events;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author aoaristides
 */
public interface DomainEvent extends Serializable {

    Instant occurredOn();

}
