$(document).ready(function () {
    // Signup Form Submission
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
            success: function (response) {
                alert('Signup successful! Please sign in.');
                window.location.href = 'index.html';
            },
            error: function (xhr, status, error) {
                alert('Signup failed: ' + xhr.responseText);
            }
        });
    });

    // Signin Form Submission
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
            success: function (response) {
                alert('Signin successful!');
                localStorage.setItem('token', response.token);
                // Redirect to dashboard or another page
            },
            error: function (xhr, status, error) {
                alert('Signin failed: ' + xhr.responseText);
            }
        });
    });
});