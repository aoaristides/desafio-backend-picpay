package br.com.makersweb.picpay.application.wallet.create;

import br.com.makersweb.picpay.domain.validation.handler.Notification;
import br.com.makersweb.picpay.domain.wallet.Wallet;
import br.com.makersweb.picpay.domain.wallet.WalletGateway;
import io.vavr.control.Either;

import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

/**
 * @author aoaristides
 */
public class DefaultCreateWalletUseCase extends CreateWalletUseCase {

    private final WalletGateway walletGateway;

    public DefaultCreateWalletUseCase(final WalletGateway walletGateway) {
        this.walletGateway = Objects.requireNonNull(walletGateway);
    }

    @Override
    public Either<Notification, CreateWalletOutput> execute(CreateWalletCommand aCommand) {
        final var aFullName = aCommand.fullName();
        final var aCpfCnpj = aCommand.cpfCnpj();
        final var aEmail = aCommand.email();
        final var aPassword = aCommand.password();
        final var aBalance = aCommand.balance();
        final var aType = aCommand.type();
        final var aActive = aCommand.active();

        final var notification = Notification.create();

        final var aWallet = Wallet.newWallet(aFullName, aCpfCnpj, aEmail, aPassword, aBalance, aType, aActive);
        aWallet.validate(notification);

        return notification.hasError() ? Left(notification) : create(aWallet);
    }

    private Either<Notification, CreateWalletOutput> create(final Wallet aWallet) {
        return Try(() -> this.walletGateway.create(aWallet))
                .toEither()
                .bimap(Notification::create, CreateWalletOutput::from);
    }
}
