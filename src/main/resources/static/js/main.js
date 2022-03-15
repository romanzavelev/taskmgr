$(document).ready(function(){
    $('.table .eBtn').on('click',function(event){
    event.preventDefault();
    var href = $(this).attr('href');
    $.get(href,function(task){
    $('.myForm #topic').val(task.topic);
    $('.myForm #content').val(task.content);
    $('.myForm #author').val(task.author);
    })
        $('.myForm #exampleModal').modal('show');
       //console.log('Captain’s Log');
    });

    $(".table").dblclick(function(){
        let one = $(this).children('td:first-child').text();
        let two = $(this).children('td:nth-child(2)').text();
        let three = $(this).children('td:last-child').text();
        $('#one').val(one);
        $('#two').val(two);
        $('#three').val(three);
        $("#idModalEditUser").modal('show');
    });
});

