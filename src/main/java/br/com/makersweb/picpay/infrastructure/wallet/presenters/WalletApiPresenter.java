package br.com.makersweb.picpay.infrastructure.wallet.presenters;

import br.com.makersweb.picpay.application.wallet.retrieve.get.WalletOutput;
import br.com.makersweb.picpay.infrastructure.wallet.models.WalletResponse;

/**
 * @author aoaristides
 */
public interface WalletApiPresenter {

    static WalletResponse present(final WalletOutput output) {
        return new WalletResponse(
                output.id().getValue(),
                output.fullName(),
                output.cpfCnpj(),
                output.email(),
                output.password(),
                output.balance(),
                output.type().name(),
                output.active(),
                output.createdAt(),
                output.updatedAt(),
                output.deletedAt()
        );
    }

}
