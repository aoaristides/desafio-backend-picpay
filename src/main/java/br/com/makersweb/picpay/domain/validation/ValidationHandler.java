package br.com.makersweb.picpay.domain.validation;

import java.util.List;

/**
 * @author aoaristides
 */
public interface ValidationHandler {

    ValidationHandler append(Error error);

    ValidationHandler append(ValidationHandler anHandler);

    <T> T validate(Validation<T> aValidation);

    List<Error> getErrors();

    default boolean hasError() {
        return getErrors() != null && !getErrors().isEmpty();
    }

    default Error firstError() {
       if (getErrors() != null && !getErrors().isEmpty()) {
           return getErrors().get(0);
       }
       return null;
    }

    interface Validation<T> {
        T validate();
    }
}
