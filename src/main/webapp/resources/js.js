

function submitEmployeeForm(){

    const contextRoot = "/"+window.location.pathname.split('/')[1];
    const jsonData = JSON.stringify(serializeObject($("#employeeForm")));
    const errorsDiv = $("#errors");
    errorsDiv.empty();
    errorsDiv.hide();

    $.ajax({url:contextRoot+"/employee/restful",
        type:'POST',
        dataType:'json',
        data:jsonData,
        contentType:"application/json",

        success: function(response) {
            $('#formInput').html("");
            $("#formInput").append( '<H3 align="center"> New Employee Information <H3>');
            $('#formInput').append("<H4 align='center'>First Name:  " +response.firstName+ "</h4>"  );
            $('#formInput').append("<H4 align='center'>Last Name: " +response.lastName+ "</h4>" );
            $('#formInput').append("<H4 align='center'>Email: " +response.email+ "</h4>");
            $("#formInput").append('<h4 align="center"> <a href="#" onclick="toggle_visibility(\'formInput\');resetForm(\'employeeForm\');"><b>EXIT</b> </a> </h4>');
            // make_visible('formInput');
            // make_hidden('errors');
            $("#formInput").show();
            $("#errors").hide();
        },

        error: function(errorObject){
            if(errorObject.responseJSON.errorType=="ValidationError"){
                errorsDiv.show();
                errorsDiv.append("<h3 align='center'>Error(s)!!!</h3>");
                const errorsList = errorObject.responseJSON.errors;
                $.each(errorsList, (i,error)=>errorsDiv.append(error.message+"<br>"));

            }else{
                alert(errorObject.responseJSON.errors(0));
            }

        }

    });

}

function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
        jsonObject[this.name] = this.value;
    });
    return jsonObject;

};