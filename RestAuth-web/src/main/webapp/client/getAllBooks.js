var resourcePath = 'http://localhost:8080/RestAuth-web/restAuth/books';

$(function() {
    $('#getbooks').click(function() {
       $.getJSON(
            resourcePath
       )
       .done(function(data){
         var result = document.getElementById('result');
         result.innerHTML = '';
         
         var str = '<table border="1">';
         for (var i = 0; i < data.length; i++) {
             str += '<tr><td>' 
                     + data[i]['isbn'] + '</td><td>' 
                     + data[i]['title'] + '</td><td>' 
                     + data[i]['description'] + '</td><td>' 
                     + data[i]['price'] + '</td></tr>'; 
         }
         str += '</table>';
         result.innerHTML = str;
       })
       .fail(function(jqXHR, textStatus, errorThrown) {
            var result = document.getElementById('result');
            result.innerHTML = jqXHR.responseText;
       });
    });
});

$(function() {
    $('#getbook').click(function() {
        var isbn = $('#isbn').val();
        $.getJSON(
            resourcePath + '/' + isbn
        )
       .done(function(data) {
         var result = document.getElementById('result');
         result.innerHTML = '';
         
         var str = '<table border="1">';
         str += '<tr><td>' 
                + data['isbn'] + '</td><td>' 
                + data['title'] + '</td><td>' 
                + data['description'] + '</td><td>' 
                + data['price'] + '</td></tr>'; 
         str += '</table>';
         result.innerHTML = str;
        })
        .fail(function(jqXHR, textStatus, errorThrown) {
            var text = "";
            var body = JSON.parse(jqXHR.responseText);
            for (var i in body.error) {
                //alert(body.error[i].errorMessage);
                text += body.error[i].errorMessage + '<br>';
            }

            var result = document.getElementById('result');
            result.innerHTML = text;
       });
    });
});
