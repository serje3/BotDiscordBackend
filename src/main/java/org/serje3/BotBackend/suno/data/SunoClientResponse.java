package org.serje3.BotBackend.suno.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SunoClientResponse {

    @JsonProperty("response")
    private Response response;

    @JsonProperty("client")
    private Object client;  // Если client всегда null, можно использовать Object или конкретный тип, если известно


    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {

        @JsonProperty("object")
        private String object;

        @JsonProperty("id")
        private String id;

        @JsonProperty("sessions")
        private List<Session> sessions;

        @JsonProperty("sign_in")
        private Object signIn;

        @JsonProperty("sign_up")
        private Object signUp;

        @JsonProperty("last_active_session_id")
        private String lastActiveSessionId;

        @JsonProperty("created_at")
        private Long createdAt;

        @JsonProperty("updated_at")
        private Long updatedAt;
    }


    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Session {

        @JsonProperty("object")
        private String object;

        @JsonProperty("id")
        private String id;

        @JsonProperty("status")
        private String status;

        @JsonProperty("expire_at")
        private Long expireAt;

        @JsonProperty("abandon_at")
        private Long abandonAt;

        @JsonProperty("last_active_at")
        private Long lastActiveAt;

        @JsonProperty("last_active_organization_id")
        private Object lastActiveOrganizationId;

        @JsonProperty("actor")
        private Object actor;

        @JsonProperty("user")
        private User user;

        @JsonProperty("public_user_data")
        private PublicUserData publicUserData;

        @JsonProperty("created_at")
        private Long createdAt;

        @JsonProperty("updated_at")
        private Long updatedAt;

        @JsonProperty("last_active_token")
        private LastActiveToken lastActiveToken;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class User {

        @JsonProperty("id")
        private String id;

        @JsonProperty("object")
        private String object;

        @JsonProperty("username")
        private String username;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("image_url")
        private String imageUrl;

        @JsonProperty("has_image")
        private Boolean hasImage;

        @JsonProperty("primary_email_address_id")
        private String primaryEmailAddressId;

        @JsonProperty("primary_phone_number_id")
        private Object primaryPhoneNumberId;

        @JsonProperty("primary_web3_wallet_id")
        private Object primaryWeb3WalletId;

        @JsonProperty("password_enabled")
        private Boolean passwordEnabled;

        @JsonProperty("two_factor_enabled")
        private Boolean twoFactorEnabled;

        @JsonProperty("totp_enabled")
        private Boolean totpEnabled;

        @JsonProperty("backup_code_enabled")
        private Boolean backupCodeEnabled;

        @JsonProperty("email_addresses")
        private List<EmailAddress> emailAddresses;

        @JsonProperty("phone_numbers")
        private List<Object> phoneNumbers;

        @JsonProperty("web3_wallets")
        private List<Object> web3Wallets;

        @JsonProperty("passkeys")
        private List<Object> passkeys;

        @JsonProperty("external_accounts")
        private List<ExternalAccount> externalAccounts;

        @JsonProperty("saml_accounts")
        private List<Object> samlAccounts;

        @JsonProperty("public_metadata")
        private Object publicMetadata;

        @JsonProperty("unsafe_metadata")
        private Object unsafeMetadata;

        @JsonProperty("external_id")
        private Object externalId;

        @JsonProperty("last_sign_in_at")
        private Long lastSignInAt;

        @JsonProperty("banned")
        private Boolean banned;

        @JsonProperty("locked")
        private Boolean locked;

        @JsonProperty("lockout_expires_in_seconds")
        private Object lockoutExpiresInSeconds;

        @JsonProperty("verification_attempts_remaining")
        private Integer verificationAttemptsRemaining;

        @JsonProperty("created_at")
        private Long createdAt;

        @JsonProperty("updated_at")
        private Long updatedAt;

        @JsonProperty("delete_self_enabled")
        private Boolean deleteSelfEnabled;

        @JsonProperty("create_organization_enabled")
        private Boolean createOrganizationEnabled;

        @JsonProperty("last_active_at")
        private Long lastActiveAt;

        @JsonProperty("mfa_enabled_at")
        private Object mfaEnabledAt;

        @JsonProperty("mfa_disabled_at")
        private Object mfaDisabledAt;

        @JsonProperty("profile_image_url")
        private String profileImageUrl;

        @JsonProperty("organization_memberships")
        private List<Object> organizationMemberships;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EmailAddress {

        @JsonProperty("id")
        private String id;

        @JsonProperty("object")
        private String object;

        @JsonProperty("email_address")
        private String emailAddress;

        @JsonProperty("reserved")
        private Boolean reserved;

        @JsonProperty("verification")
        private Verification verification;

        @JsonProperty("linked_to")
        private List<LinkedTo> linkedTo;

        @JsonProperty("created_at")
        private Long createdAt;

        @JsonProperty("updated_at")
        private Long updatedAt;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Verification {

        @JsonProperty("status")
        private String status;

        @JsonProperty("strategy")
        private String strategy;

        @JsonProperty("attempts")
        private Object attempts;

        @JsonProperty("expire_at")
        private Object expireAt;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LinkedTo {

        @JsonProperty("type")
        private String type;

        @JsonProperty("id")
        private String id;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ExternalAccount {

        @JsonProperty("object")
        private String object;

        @JsonProperty("id")
        private String id;

        @JsonProperty("provider")
        private String provider;

        @JsonProperty("identification_id")
        private String identificationId;

        @JsonProperty("provider_user_id")
        private String providerUserId;

        @JsonProperty("approved_scopes")
        private String approvedScopes;

        @JsonProperty("email_address")
        private String emailAddress;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("avatar_url")
        private String avatarUrl;

        @JsonProperty("image_url")
        private String imageUrl;

        @JsonProperty("username")
        private String username;

        @JsonProperty("public_metadata")
        private Object publicMetadata;

        @JsonProperty("label")
        private Object label;

        @JsonProperty("created_at")
        private Long createdAt;

        @JsonProperty("updated_at")
        private Long updatedAt;

        @JsonProperty("verification")
        private Verification verification;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PublicUserData {

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("image_url")
        private String imageUrl;

        @JsonProperty("has_image")
        private Boolean hasImage;

        @JsonProperty("identifier")
        private String identifier;

        @JsonProperty("profile_image_url")
        private String profileImageUrl;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LastActiveToken {

        @JsonProperty("object")
        private String object;

        @JsonProperty("jwt")
        private String jwt;
    }
}