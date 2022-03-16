$(document).ready(function(){
    $('.nBtn,.table .eBtn').on('click',function(event){
    event.preventDefault();
    var href = $(this).attr('href');
    var text = $(this).text();
    if(text == 'Edit'){
        $.getJSON(href, function (data) {
            $('.myForm #id').val(data['id']);
            $('.myForm #topic').val(data['topic']);
            $('.myForm #content').val(data['content']);
            $('.myForm #author').val(data['author']);
        })
        $('.myForm #exampleModal').modal('show');
        }else{
         $('.myForm #id').val();
                   $('.myForm #topic').val('');
                    $('.myForm #content').val('');
                    $('.myForm #author').val('');
                     $('.myForm #exampleModal').modal('show');
        }
    });

    // $(".table .eBtn").dblclick(function(event){
    //     event.preventDefault();
    //     var href = $(this).attr('href');
    //     $.getJSON(href, function (data) {
    //         $('.myForm #id').val(data['id']);
    //         $('.myForm #topic').val(data['topic']);
    //         $('.myForm #content').val(data['content']);
    //         $('.myForm #author').val(data['author']);
    //     });
    //     $('.myForm #exampleModal').modal('show');
    // });
});

