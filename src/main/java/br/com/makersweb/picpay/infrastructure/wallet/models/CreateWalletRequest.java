package br.com.makersweb.picpay.infrastructure.wallet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author aoaristides
 * @param fullName
 * @param cpfCnpj
 * @param email
 * @param password
 * @param balance
 * @param type
 * @param active
 */
public record CreateWalletRequest(
        @JsonProperty("full_name") String fullName,
        @JsonProperty("cpf_cnpj") String cpfCnpj,
        @JsonProperty("email") String email,
        @JsonProperty("password") String password,
        @JsonProperty("balance") BigDecimal balance,
        @JsonProperty("type") String type,
        @JsonProperty("is_active") Boolean active
) {
}
