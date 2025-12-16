package br.com.makersweb.picpay.domain.events;

/**
 * @author aoaristides
 */
@FunctionalInterface
public interface DomainEventPublisher {

    void publishEvent(DomainEvent event);

}
