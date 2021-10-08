package com.Monstarlab.SonCH.response;

import com.Monstarlab.SonCH.utils.Messagesutils;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {
    InvalidAccessError("99", "api.error.response.invalid.access")
    , DefaultInternalServerMessageError("100", "api.error.response.default.internal.message.error")
    , DuplicatedUsername("101", "api.error.response.duplicated.username")
    , UserRoleNotFound("102", "api.error.response.user.role.not.found")
    , CardIdNotFound("103", "api.error.response.card.id.not.found")
    , AuthenticateUserFailed("104", "api.error.response.authenticate.user.failed")
    , CreateStoreSuccessfully("105", "api.success.response.create.store.successfully")
    , UpdateStoreSuccessfully("106", "api.success.response.update.store.successfully")
    , DeleteStoreSuccessfully("107", "api.success.response.delete.store.successfully")
    , RegisterUserSuccessfully("108", "api.success.response.create.user.successfully")
            ;
    private String status;
    private String messageId;

    public String getMessage(Object... params) {
        String mess = Messagesutils.getMessage(this.messageId, params);
        return mess;
    }
}
