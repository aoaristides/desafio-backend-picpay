package br.com.makersweb.picpay.infrastructure.wallet.persistence;

import br.com.makersweb.picpay.domain.wallet.Wallet;
import br.com.makersweb.picpay.domain.wallet.WalletID;
import br.com.makersweb.picpay.domain.wallet.WalletType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author aoaristides
 */
@Setter
@Getter
@Entity(name = "Wallet")
@Table(name = "wallets")
public class WalletJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "cpf_cnpj", nullable = false, unique = true)
    private String cpfCnpj;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public WalletJpaEntity() {
    }

    private WalletJpaEntity(
            final String id,
            final String fullName,
            final String cpfCnpj,
            final String email,
            final String password,
            final BigDecimal balance,
            final String type,
            final boolean active,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        this.id = id;
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.type = type;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static WalletJpaEntity from(final Wallet aWallet) {
        return new WalletJpaEntity(
                aWallet.getId().getValue(),
                aWallet.getFullName(),
                aWallet.getCpfCnpj(),
                aWallet.getEmail(),
                aWallet.getPassword(),
                aWallet.getBalance(),
                aWallet.getType().name(),
                aWallet.isActive(),
                aWallet.getCreatedAt(),
                aWallet.getUpdatedAt(),
                aWallet.getDeletedAt()
        );
    }

    public Wallet toAggregate() {
        return Wallet.with(
                WalletID.from(getId()),
                getFullName(),
                getCpfCnpj(),
                getEmail(),
                getPassword(),
                getBalance(),
                WalletType.valueOf(getType()),
                isActive(),
                getCreatedAt(),
                getUpdatedAt(),
                getDeletedAt()
        );
    }

}
