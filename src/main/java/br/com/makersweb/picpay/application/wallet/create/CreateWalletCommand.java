package br.com.makersweb.picpay.application.wallet.create;

import br.com.makersweb.picpay.domain.wallet.WalletType;

import java.math.BigDecimal;

/**
 * @author aoaristides
 * @param fullName
 * @param cpfCnpj
 * @param email
 * @param password
 * @param balance
 * @param type
 * @param active
 */
public record CreateWalletCommand(
        String fullName,
        String cpfCnpj,
        String email,
        String password,
        BigDecimal balance,
        WalletType type,
        boolean active
) {

    public static CreateWalletCommand with(
            final String fullName,
            final String cpfCnpj,
            final String email,
            final String password,
            final BigDecimal balance,
            final WalletType type,
            final boolean active
    ) {
        return new CreateWalletCommand(fullName, cpfCnpj, email, password, balance, type, active);
    }

}
