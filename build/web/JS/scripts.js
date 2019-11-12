function red_login()
{
    window.location.replace("tela_login.html");
}
function red_index()
{
    window.location.replace("index.jsp");
}

function red_form()
{
    window.location.replace("formulario.html")
}

function autenticar() {
    $.ajax({
        url: "valida_sessao",
        type: "POST",
        data: {email: $('#email').val(), senha: $('#senha').val()},
        success: function (form) {
            if (!form) {
                $('body').load("index.jsp")
            }
            else
                $("#erro").html(form);
        }
    });
}

function carrega_piadas() {
    alert('piada')
    /*$.ajax({
        url: "carrega_piada",
        type: "GET",
        success: function (form) {
            $('#piada').append(form);
        }
    });*/
}

$(document).ready(function() {
    $.ajax({
        url: "carrega_piada",
        type: "GET",
        success: function (form) {
            $('#piada').append(form);
        }
    });
});

function deslogar() {
    $.ajax({
        url: "deslogar_sessao",
        type: "GET",
        success: function () {
            window.location.replace("index.jsp")
        }
    });
}

function cadastra_piada() {
  
    window.location.replace("cadastro_piadas.jsp")
}

function excluir_usuario() {
    $.ajax({
        url: "excluir_usuario",
        type: "GET",
        success: function () {
            window.location.replace("index.jsp")
        }
    });
}