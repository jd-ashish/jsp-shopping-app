function loginValidate() {
    var email = $("#loginEmail").val();
    var pass = $("#loginPass").val();
    
    var error = 0;
    
    if (email.length === 0) {
        
        $(".loginEmailError").html("Enter some email field!");
        $(".loginEmailError").show();
        $(".emailIcon").show();
        error = 1;
    }else{
        $(".loginEmailError").hide();
        $(".emailIcon").hide();
    }
    
    if (IsEmail(email) === false) {
        $(".loginEmailError").show();
        $(".emailIcon").show();
        $(".loginEmailError").html("Enter correct email-id!");
        error = 1;
    }else{
        $(".loginEmailError").hide();
        $(".emailIcon").hide();
    }
    if (pass.length === 0) {
        $(".loginPassError").show();
        $(".passIcon").show();
        $(".loginPassError").html("Enter Password!");
        error = 1;
    }else{
        $(".loginPassError").hide();
        $(".passIcon").hide();
    }

    if (error === 0) {
        $(".loginEmailError").hide();
        $(".emailIcon").hide();
        $(".passIcon").hide();
        $(".loginPassError").hide();
        return true;
    }

    return false;
}
function signupValidate() {
    var name = $("#signupName").val();
    var email = $("#loginEmail").val();
    var pass = $("#loginPass").val();
    
    var error = 0;
    
    if (name.length === 0) {
        $(".signupNameError").html("Enter your name!");
        $(".signupNameError").show();
        $(".emailIcon").show();
        $(".nameICon").show();
        error = 1;
    }else{
        $(".signupNameError").hide();
        $(".emailIcon").hide();
        $(".nameICon").hide();
    }
    if (email.length === 0) {
        
        $(".loginEmailError").html("Enter some email field!");
        $(".loginEmailError").show();
        $(".emailIcon").show();
        error = 1;
    }else{
        $(".loginEmailError").hide();
        $(".emailIcon").hide();
    }
    
    if (IsEmail(email) === false) {
        $(".loginEmailError").show();
        $(".emailIcon").show();
        $(".loginEmailError").html("Enter correct email-id!");
        error = 1;
    }else{
        $(".loginEmailError").hide();
        $(".emailIcon").hide();
    }
    if (pass.length === 0) {
        $(".loginPassError").show();
        $(".passIcon").show();
        $(".loginPassError").html("Enter Password!");
        error = 1;
    }else{
        $(".loginPassError").hide();
        $(".passIcon").hide();
    }

    if (error === 0) {
        $(".loginEmailError").hide();
        $(".emailIcon").hide();
        $(".passIcon").hide();
        $(".loginPassError").hide();
        $(".signupNameError").hide();
        return true;
    }

    return false;
}

function IsEmail(email) {
    var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!regex.test(email)) {
        return false;
    } else {
        return true;
    }
}