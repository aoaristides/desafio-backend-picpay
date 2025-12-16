package br.com.makersweb.picpay.application.wallet.create;

import br.com.makersweb.picpay.domain.wallet.Wallet;

/**
 * @author aoaristides
 * @param id
 */
public record CreateWalletOutput(
        String id
) {

    public static CreateWalletOutput from(final String anId) {
        return new CreateWalletOutput(anId);
    }

    public static CreateWalletOutput from(final Wallet anWallet) {
        return from(anWallet.getId().getValue());
    }

}
