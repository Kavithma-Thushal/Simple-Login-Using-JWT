$('#signinForm').submit(function (event) {
    event.preventDefault();

    const loginData = {
        email: $('#email').val(),
        password: $('#password').val()
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/auth/signin',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(loginData),
        success: function (resp) {
            alert('SignIn Successfully...!');
            localStorage.setItem('token', resp.token);
        },
        error: function (xhr) {
            alert('SigniIn Failed : ' + xhr.responseText);
        }
    });
});