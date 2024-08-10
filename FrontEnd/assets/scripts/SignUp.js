$('#signup-form').submit(function (event) {
    event.preventDefault();

    const userData = {
        name: $('#signUp-name').val(),
        email: $('#signUp-email').val(),
        password: $('#signUp-password').val(),
        role: $('#signUp-role').val()
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/auth/signup',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(userData),
        success: function (resp) {
            alert('SignUp Successfully...!');
        },
        error: function (xhr) {
            alert('SignUp Failed : ' + xhr.responseText);
        }
    });
});