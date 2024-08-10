$('#signin-form').submit(function (event) {
    event.preventDefault();

    const loginData = {
        email: $('#signIn-email').val(),
        password: $('#signIn-password').val()
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/auth/signin',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(loginData),
        success: function (resp) {
            alert('SignIn Successfully...!');
            localStorage.setItem('token', resp.token);
            window.location.href = '../../Pages/CustomerPage.html';
        },
        error: function (xhr) {
            alert('SignIn Failed : ' + xhr.responseText);
        }
    });
});