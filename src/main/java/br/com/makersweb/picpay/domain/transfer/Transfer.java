package br.com.makersweb.picpay.domain.transfer;

import br.com.makersweb.picpay.domain.AggregateRoot;
import br.com.makersweb.picpay.domain.validation.ValidationHandler;
import br.com.makersweb.picpay.domain.wallet.Wallet;
import br.com.makersweb.picpay.utils.InstantUtils;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * @author aoaristides
 */
public class Transfer extends AggregateRoot<TransferID> {

    private Wallet sender;
    private Wallet receiver;
    private BigDecimal value;
    private Instant createdAt;
    private Instant updatedAt;

    public Transfer(
            final TransferID transferID,
            final Wallet sender,
            final Wallet receiver,
            final BigDecimal value,
            final Instant createdAt,
            final Instant updatedAt
    ) {
        super(transferID);
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;
        this.createdAt = Objects.requireNonNull(createdAt, "'createdAt' should not be null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "'updatedAt' should not be null");
    }

    public static Transfer newTransfer(
            final Wallet sender,
            final Wallet receiver,
            final BigDecimal value
    ) {
        final var id = TransferID.unique();
        final var now = InstantUtils.now();
        return new Transfer(id, sender, receiver, value, now, now);
    }

    public Transfer with(
            final TransferID transferID,
            final Wallet sender,
            final Wallet receiver,
            final BigDecimal value,
            final Instant createdAt,
            final Instant updatedAt
    ) {
        return new Transfer(transferID, sender, receiver, value, createdAt, updatedAt);
    }

    public Transfer with(final Transfer aTransfer) {
        return with(
                aTransfer.getId(),
                aTransfer.sender,
                aTransfer.receiver,
                aTransfer.value,
                aTransfer.createdAt,
                aTransfer.updatedAt
        );
    }

    @Override
    public void validate(ValidationHandler handler) {
        new TransferValidator(this, handler).validate();
    }

    public Transfer update(
            final Wallet sender,
            final Wallet receiver,
            final BigDecimal value
    ) {
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;
        this.updatedAt = Instant.now();
        return this;
    }

    @Override
    public TransferID getId() {
        return id;
    }

    public Wallet getSender() {
        return sender;
    }

    public Wallet getReceiver() {
        return receiver;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
