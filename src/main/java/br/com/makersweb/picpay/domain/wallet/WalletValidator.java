package br.com.makersweb.picpay.domain.wallet;

import br.com.makersweb.picpay.domain.validation.Error;
import br.com.makersweb.picpay.domain.validation.ValidationHandler;
import br.com.makersweb.picpay.domain.validation.Validator;
import br.com.makersweb.picpay.utils.DocumentValidatorUtils;

/**
 * @author aoaristides
 */
public class WalletValidator extends Validator {

    private static final int NAME_MAX_LENGTH = 255;
    private static final int NAME_MIN_LENGTH = 3;
    private final Wallet wallet;

    public WalletValidator(final Wallet wallet,  final ValidationHandler aHandler) {
        super(aHandler);
        this.wallet = wallet;
    }

    @Override
    public void validate() {
        checkNameConstraints();
        checkCpfCnpjValidate();
    }

    private void checkNameConstraints() {
        final var name = this.wallet.getFullName();
        if (name == null) {
            this.validationHandler().append(new Error("'name' should not be null"));
            return;
        }

        if (name.isBlank()) {
            this.validationHandler().append(new Error("'name' should not be empty"));
            return;
        }

        final int length = name.trim().length();
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            this.validationHandler().append(new Error("'name' must be between 3 and 255 characters"));
        }
    }

    private void checkCpfCnpjValidate() {
        var cpfCnpj = this.wallet.getCpfCnpj();
        if (cpfCnpj == null) {
            this.validationHandler().append(new Error("'CPF/CNPJ' should not be null"));
            return;
        }

        cpfCnpj = cpfCnpj.replaceAll("[^0-9]", "");
        if (cpfCnpj.length() < 11 || cpfCnpj.length() > 14) {
            this.validationHandler().append(new Error("'CPF/CNPJ' should be between 11 and 14 characters"));
            return;
        }

        if (cpfCnpj.length() == 11 && !DocumentValidatorUtils.validateCpf(cpfCnpj)) {
            this.validationHandler().append(new Error("'CPF' invalid."));
            return;
        }

        if (cpfCnpj.length() == 14 && !DocumentValidatorUtils.validateCnpj(cpfCnpj)) {
            this.validationHandler().append(new Error("'CNPJ' invalid."));
        }
    }
}
