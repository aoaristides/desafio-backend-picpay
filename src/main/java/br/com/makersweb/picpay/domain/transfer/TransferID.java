package br.com.makersweb.picpay.domain.transfer;

import br.com.makersweb.picpay.domain.Identifier;
import br.com.makersweb.picpay.utils.IdUtils;

import java.util.Objects;

/**
 * @author aoaristides
 */
public class TransferID extends Identifier {

    private final String value;

    private TransferID(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static TransferID unique() {
        return TransferID.from(IdUtils.uuid());
    }

    public static TransferID from(final String anId) {
        return new TransferID(anId);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TransferID that = (TransferID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
