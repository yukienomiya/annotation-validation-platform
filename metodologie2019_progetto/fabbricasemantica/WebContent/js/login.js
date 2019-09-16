/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
class login {
    static main(args) {
        console.log("Creating form");
        let form = document.createElement("form");
        form.action = login.SERVLET_URL;
        form.method = "POST";
        form.className = "pure-form pure-form-stacked";
        console.log("Form Done");
        let f = document.createElement("fieldset");
        console.log("creating mail label");
        let labelMail = document.createElement("label");
        labelMail.textContent = "Email:";
        console.log("creating pw label");
        let labelPw = document.createElement("label");
        labelPw.textContent = "Password:";
        console.log("creating email input");
        let email = document.createElement("input");
        email.name = "email";
        email.type = "email";
        console.log("creating password input");
        let password = document.createElement("input");
        password.name = "password";
        password.type = "password";
        let loginButton = document.createElement("input");
        loginButton.type = "submit";
        loginButton.name = "loginButton_button";
        loginButton.value = "LOGIN";
        loginButton.className = "pure-button pure-button-primary";
        console.log("creating signup anchor element");
        let signupButton = document.createElement("a");
        signupButton.href = login.SIGNUP_URL;
        signupButton.textContent = "SIGN UP";
        signupButton.className = "pure-button";
        console.log("creating signupButton label");
        let divMail = document.createElement("div");
        $(divMail).append(labelMail);
        $(divMail).append(email);
        let divPw = document.createElement("div");
        $(divPw).append(labelPw);
        $(divPw).append(password);
        let divButton = document.createElement("div");
        $(divButton).append(loginButton);
        let divLink = document.createElement("div");
        $(divLink).append(signupButton);
        let divForm = document.createElement("div");
        console.log("adding to form");
        $(f).append(divMail);
        $(f).append(divPw);
        $(f).append(divButton);
        $(f).append(divLink);
        $(form).append(f);
        $(divForm).append(form);
        console.log("adding to body");
        $("body").append(divForm);
    }
}
login.SERVLET_URL = "login.jsp";
login.SIGNUP_URL = "signup.html";
login["__class"] = "login";
login.main(null);
