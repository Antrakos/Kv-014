package edu.softserve.zoo.dto;

import edu.softserve.zoo.annotation.IrrespectiveDto;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author Ilya Doroshenko
 */
@IrrespectiveDto
public class ChangePasswordDto {

    @NotNull
    @NotEmpty
    private String newPassword;

    @NotNull
    @NotEmpty
    private String confirmationPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }

    public void setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
    }
}
