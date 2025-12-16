package br.com.makersweb.picpay.infrastructure.wallet.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author aoaristides
 */
public interface WalletRepository extends JpaRepository<WalletJpaEntity, String> {

    Optional<WalletJpaEntity> findByCpfCnpjOrEmail(final String cpfCnpj, final String email);

}
