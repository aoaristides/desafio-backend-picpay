package br.com.makersweb.picpay.infrastructure.api.controllers;

import br.com.makersweb.picpay.application.wallet.create.CreateWalletCommand;
import br.com.makersweb.picpay.application.wallet.create.CreateWalletOutput;
import br.com.makersweb.picpay.application.wallet.create.CreateWalletUseCase;
import br.com.makersweb.picpay.domain.validation.handler.Notification;
import br.com.makersweb.picpay.domain.wallet.WalletType;
import br.com.makersweb.picpay.infrastructure.api.WalletAPI;
import br.com.makersweb.picpay.infrastructure.wallet.models.CreateWalletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author aoaristides
 */
@RestController
public class WalletController implements WalletAPI {

    private final CreateWalletUseCase createWalletUseCase;

    public WalletController(final CreateWalletUseCase createWalletUseCase) {
        this.createWalletUseCase = Objects.requireNonNull(createWalletUseCase);
    }

    @Override
    public ResponseEntity<?> createWallet(final CreateWalletRequest input) {
        final var aCommand = CreateWalletCommand.with(
                input.fullName(),
                input.cpfCnpj(),
                input.email(),
                input.password(),
                input.balance(),
                WalletType.valueOf(input.type()),
                input.active() != null ? input.active() : true
        );

        final Function<Notification, ResponseEntity<?>> onError = notification ->
                ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreateWalletOutput, ResponseEntity<?>> onSuccess = output ->
                ResponseEntity.created(URI.create("/wallets/" + output.id())).body(output);

        return this.createWalletUseCase.execute(aCommand).fold(onError, onSuccess);
    }
}
