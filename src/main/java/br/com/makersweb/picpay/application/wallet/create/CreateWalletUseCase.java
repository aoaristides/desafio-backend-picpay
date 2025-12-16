package br.com.makersweb.picpay.application.wallet.create;

import br.com.makersweb.picpay.application.UseCase;
import br.com.makersweb.picpay.domain.validation.handler.Notification;
import io.vavr.control.Either;

/**
 * @author aoaristides
 */
public abstract class CreateWalletUseCase extends UseCase<CreateWalletCommand, Either<Notification, CreateWalletOutput>> {
}
