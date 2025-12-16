package br.com.makersweb.picpay.infrastructure.usecases;

import br.com.makersweb.picpay.application.wallet.create.CreateWalletUseCase;
import br.com.makersweb.picpay.application.wallet.create.DefaultCreateWalletUseCase;
import br.com.makersweb.picpay.domain.wallet.WalletGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aoaristides
 */
@Configuration
public class WalletUseCaseConfig {

    private final WalletGateway walletGateway;

    public WalletUseCaseConfig(WalletGateway walletGateway) {
        this.walletGateway = walletGateway;
    }

    @Bean
    public CreateWalletUseCase createWalletUseCase() {
        return new DefaultCreateWalletUseCase(walletGateway);
    }

}
