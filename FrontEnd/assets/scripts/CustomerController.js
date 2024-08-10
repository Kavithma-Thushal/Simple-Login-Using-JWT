$('#btnSave').on('click', function () {

    const cusObj = {
        id: $('#customerId').val(),
        name: $('#customerName').val(),
        address: $('#customerAddress').val(),
        salary: $('#customerSalary').val()
    };

    const token = localStorage.getItem('token');

    $.ajax({
        url: 'http://localhost:8080/api/v1/customer',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(cusObj),
        beforeSend: function (xhr) {
            xhr.setRequestHeader('Authorization', 'Bearer ' + token);
        },
        success: function (resp) {
            alert('Customer Saved Successfully...!');
        },
        error: function (xhr) {
            alert('Customer Save Failed : ' + xhr.responseText);
        }
    });
});