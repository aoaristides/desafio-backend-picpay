package br.com.makersweb.picpay.infrastructure.wallet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author aoaristides
 * @param id
 * @param fullName
 * @param cpfCnpj
 * @param email
 * @param password
 * @param balance
 * @param type
 * @param active
 * @param createdAt
 * @param updatedAt
 * @param deletedAt
 */
public record WalletResponse(
        @JsonProperty("id") String id,
        @JsonProperty("full_name") String fullName,
        @JsonProperty("cpf_cnpj") String cpfCnpj,
        @JsonProperty("email") String email,
        @JsonProperty("password") String password,
        @JsonProperty("balance") BigDecimal balance,
        @JsonProperty("type") String type,
        @JsonProperty("is_active") Boolean active,
        @JsonProperty("created_at") Instant createdAt,
        @JsonProperty("updated_at") Instant updatedAt,
        @JsonProperty("deleted_at") Instant deletedAt
) {
}
