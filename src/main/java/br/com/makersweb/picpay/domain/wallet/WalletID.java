package br.com.makersweb.picpay.domain.wallet;

import br.com.makersweb.picpay.domain.Identifier;
import br.com.makersweb.picpay.utils.IdUtils;

import java.util.Objects;

/**
 * @author aoaristides
 */
public class WalletID extends Identifier {

    private final String value;

    private WalletID(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static WalletID unique() {
        return WalletID.from(IdUtils.uuid());
    }

    public static WalletID from(final String anId) {
        return new WalletID(anId);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final WalletID that = (WalletID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
