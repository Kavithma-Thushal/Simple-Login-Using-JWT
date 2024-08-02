$('#signupForm').submit(function (event) {
    event.preventDefault();

    const userData = {
        firstName: $('#firstName').val(),
        lastName: $('#lastName').val(),
        email: $('#email').val(),
        password: $('#password').val(),
        role: $('#role').val()
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/auth/signup',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(userData),
        success: function (resp) {
            alert('SignUp Successfully...!');
            window.location.href = '../SignIn/SignIn.html';
        },
        error: function (xhr) {
            alert('SignUp Failed : ' + xhr.responseText);
        }
    });
});