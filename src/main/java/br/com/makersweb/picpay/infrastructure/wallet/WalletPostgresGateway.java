package br.com.makersweb.picpay.infrastructure.wallet;

import br.com.makersweb.picpay.domain.exceptions.DomainException;
import br.com.makersweb.picpay.domain.validation.Error;
import br.com.makersweb.picpay.domain.wallet.Wallet;
import br.com.makersweb.picpay.domain.wallet.WalletGateway;
import br.com.makersweb.picpay.domain.wallet.WalletID;
import br.com.makersweb.picpay.infrastructure.wallet.persistence.WalletJpaEntity;
import br.com.makersweb.picpay.infrastructure.wallet.persistence.WalletRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author aoaristides
 */
@Component
public class WalletPostgresGateway implements WalletGateway {

    private final WalletRepository walletRepository;

    public WalletPostgresGateway(final WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet create(Wallet aWallet) {
        final var existsWallet = this.walletRepository.findByCpfCnpjOrEmail(aWallet.getCpfCnpj(), aWallet.getEmail());
        if (existsWallet.isPresent()) {
            throw DomainException.with(new Error("CpfCnpj or Email already exists"));
        }
        return save(aWallet);
    }

    @Override
    public void deleteById(WalletID anId) {

    }

    @Override
    public Optional<Wallet> findById(WalletID anId) {
        return Optional.empty();
    }

    @Override
    public Wallet update(Wallet aWallet) {
        return null;
    }

    private Wallet save(Wallet aWallet) {
        return this.walletRepository.save(WalletJpaEntity.from(aWallet)).toAggregate();
    }
}
