$(document).ready(function(){
    updateTotal();
});

var quantity = $("input[name=nameGoesHere]").val();
    console.log("Hello);

function updateTotal(){
    total = 12;
    var quantity = $("input[name=nameGoesHere]").val();
    console.log(quantity);
//   $("").each(function(index, element){
//    total = total + parseFloat(element.innerHTML)
//   });


    $("#totalAmount").text("$" + x);
 }