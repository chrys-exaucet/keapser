package keapser.chat.common.annotation;


import javax.validation.constraints.Pattern;

@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$", message = " votre mot de passe est au mauvais format")
public @interface Password {
}
