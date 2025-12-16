package br.com.makersweb.picpay.domain.transfer;

import br.com.makersweb.picpay.domain.validation.Error;
import br.com.makersweb.picpay.domain.validation.ValidationHandler;
import br.com.makersweb.picpay.domain.validation.Validator;

import java.math.BigDecimal;

/**
 * @author aoaristides
 */
public class TransferValidator extends Validator {

    private final Transfer transfer;

    public TransferValidator(final Transfer transfer, final ValidationHandler aHandler) {
        super(aHandler);
        this.transfer = transfer;
    }

    @Override
    public void validate() {
        checkSenderOrReceiverValidate();
        checkValueValidate();
    }

    public void checkSenderOrReceiverValidate() {
        final var sender = this.transfer.getSender();
        final var receiver = this.transfer.getReceiver();
        if (sender == null || receiver == null) {
            this.validationHandler().append(new Error("'Sender' and 'Receiver' are required."));
            return;
        }

        if (sender.equals(receiver)) {
            this.validationHandler().append(new Error("'Sender' and 'Receiver' are equal."));
            return;
        }

        if (!sender.isActive()) {
            this.validationHandler().append(new Error("'Sender' not active."));
            return;
        }

        if (!receiver.isActive()) {
            this.validationHandler().append(new Error("'Receiver' not active."));
        }
    }

    private void checkValueValidate() {
        final var value = this.transfer.getValue();
        if (value == null) {
            this.validationHandler().append(new Error("'Value' is required."));
            return;
        }

        if (value.compareTo(BigDecimal.ZERO) == 0) {
            this.validationHandler().append(new Error("'Value' is required."));
        }
    }
}
