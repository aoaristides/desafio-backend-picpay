package br.com.makersweb.picpay.domain.wallet;

import br.com.makersweb.picpay.domain.AggregateRoot;
import br.com.makersweb.picpay.domain.validation.ValidationHandler;
import br.com.makersweb.picpay.utils.InstantUtils;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * @author aoaristides
 */
public class Wallet extends AggregateRoot<WalletID> {

    private String fullName;
    private String cpfCnpj;
    private String email;
    private String password;
    private BigDecimal balance;
    private WalletType type;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Wallet(
            final WalletID walletID,
            final String fullName,
            final String cpfCnpj,
            final String email,
            final String password,
            final BigDecimal balance,
            final WalletType type,
            final boolean active,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        super(walletID);
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.type = type;
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "'createdAt' should not be null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "'updatedAt' should not be null");
        this.deletedAt = deletedAt;
    }

    public static Wallet newWallet(
            final String fullName,
            final String cpfCnpj,
            final String email,
            final String password,
            final BigDecimal balance,
            final WalletType type,
            final boolean active
    ) {
        final var id = WalletID.unique();
        final var now = InstantUtils.now();
        final var deletedAt = active ? null : now;
        return new Wallet(id, fullName, cpfCnpj, email, password, balance, type, active, now, now, deletedAt);
    }

    public static Wallet with(
            final WalletID walletID,
            final String fullName,
            final String cpfCnpj,
            final String email,
            final String password,
            final BigDecimal balance,
            final WalletType type,
            final boolean active,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        return new Wallet(walletID, fullName, cpfCnpj, email,  password, balance, type, active, createdAt, updatedAt, deletedAt);
    }

    public static Wallet with(final Wallet aWallet) {
        return with(
                aWallet.getId(),
                aWallet.fullName,
                aWallet.cpfCnpj,
                aWallet.email,
                aWallet.password,
                aWallet.balance,
                aWallet.type,
                aWallet.active,
                aWallet.createdAt,
                aWallet.updatedAt,
                aWallet.deletedAt
        );
    }

    @Override
    public void validate(ValidationHandler handler) {
        new WalletValidator(this, handler).validate();
    }

    public Wallet activate() {
        this.deletedAt = null;
        this.active = true;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public Wallet deactivate() {
        if (getDeletedAt() == null) {
            this.deletedAt = InstantUtils.now();
        }

        this.active = false;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public Wallet update(
            final String fullName,
            final String cpfCnpj,
            final String email,
            final String password,
            final BigDecimal balance,
            final WalletType type,
            final boolean active
    ) {
        if (active) {
            activate();
        } else {
            deactivate();
        }
        this.fullName = fullName;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.type = type;
        this.active = active;
        this.updatedAt = Instant.now();
        return this;
    }

    @Override
    public WalletID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public WalletType getType() {
        return type;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
