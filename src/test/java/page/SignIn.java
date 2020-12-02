package page;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class SignIn {

    public SignIn open() {
        Selenide.open("/");
        return this;
    }

    public void fillForm(String email, String password) {
        $("#user_email").setValue(email);
        $("#user_password").setValue(password).pressEnter();
    }
}
