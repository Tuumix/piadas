<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="CSS/formcss.css">
    <link href="https://fonts.googleapis.com/css?family=Sunshiney&display=swap" rel="stylesheet"> 
</head>
    <title>Document</title>
</head>
<body>
        <header>
            <button onclick="red_index();"><i class="fa fa-home">Home</i></button>
        </header>
    <main class="main-cad-piadas">
        <form action="cadastra_pia" method="POST" enctype="multipart/form-data">
            <input name="titulo" class="input_data" type="text" placeholder="Título">
            <textarea name="texto" class="input_data" placeholder="Texto"></textarea>
            <input name="chave" class="input_data" type="text" placeholder="Palavras chave">
            <input type="file" name="foto">
            <br><br>
            <button class="btn btn-outline-success">Cadastrar</button>
        </form>
    </main>
        <script src="JS/scripts.js" type="text/javascript"></script>

</body>
</html>
