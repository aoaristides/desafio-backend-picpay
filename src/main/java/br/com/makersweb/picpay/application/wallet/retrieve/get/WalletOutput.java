package br.com.makersweb.picpay.application.wallet.retrieve.get;

import br.com.makersweb.picpay.domain.wallet.Wallet;
import br.com.makersweb.picpay.domain.wallet.WalletID;
import br.com.makersweb.picpay.domain.wallet.WalletType;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author aoaristides
 * @param walletID
 * @param fullName
 * @param cpfCnpj
 * @param email
 * @param password
 * @param balance
 * @param type
 * @param active
 * @param createdAt
 * @param updatedAt
 * @param deletedAt
 */
public record WalletOutput(
        WalletID id,
        String fullName,
        String cpfCnpj,
        String email,
        String password,
        BigDecimal balance,
        WalletType type,
        boolean active,
        Instant createdAt,
        Instant updatedAt,
        Instant deletedAt
) {

    public static WalletOutput from(final Wallet aWallet) {
        return new WalletOutput(
                aWallet.getId(),
                aWallet.getFullName(),
                aWallet.getCpfCnpj(),
                aWallet.getEmail(),
                aWallet.getPassword(),
                aWallet.getBalance(),
                aWallet.getType(),
                aWallet.isActive(),
                aWallet.getCreatedAt(),
                aWallet.getUpdatedAt(),
                aWallet.getDeletedAt()
        );
    }

}
