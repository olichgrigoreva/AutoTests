package page;

import com.codeborne.selenide.Selenide;

public class SignIn {

    public SignIn open() {
        Selenide.open("/");
        return this;
    }
}
