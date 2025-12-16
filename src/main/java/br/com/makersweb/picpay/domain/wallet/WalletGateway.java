package br.com.makersweb.picpay.domain.wallet;

import java.util.Optional;

/**
 * @author aoaristides
 */
public interface WalletGateway {

    Wallet create(Wallet aWallet);

    void deleteById(WalletID anId);

    Optional<Wallet> findById(WalletID anId);

    Wallet update(Wallet aWallet);

}
