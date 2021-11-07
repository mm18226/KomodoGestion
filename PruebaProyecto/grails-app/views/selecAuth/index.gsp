<html>
<head>
    <meta name="layout" content="${gspLayout ?: 'main'}"/>
    <title><g:message code='springSecurity.login.title'/></title>
</head>

<body>
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Habilitacion de 2AF: Escoja el metodo deseado</h5>
              <p> <button id="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="button" ><g:link controller="sms" action="index" style="color:white">SMS</g:link></p></button>
              <br>
              <p> <button id="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="button" ><g:link controller="email" action="email" style="color:white">Email</g:link></p></button>
              <hr class="my-4">
            </form>
          </div>
        </div>
      </div>
    </div>
    
</body>
</html>