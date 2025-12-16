package br.com.makersweb.picpay.domain;

import br.com.makersweb.picpay.domain.events.DomainEvent;

import java.util.List;

/**
 * @author aoaristides
 * @param <ID>
 */
public abstract class AggregateRoot<ID extends Identifier> extends Entity<ID> {

    protected AggregateRoot(final ID id) {
        super(id);
    }

    protected AggregateRoot(final ID id, final List<DomainEvent> events) {
        super(id, events);
    }

}
