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
            <h5 class="card-title text-center">Ingrese el codigo enviado a su Email</h5>
            <g:if test='${flash.message}'>
                        <div class="alert alert-danger" role="alert">${flash.message}</div>
                        </g:if>
            <form class="form-signin" action="verificarCod" method="POST" id="emailForm" autocomplete="off">
            <div class="form-group">
                          
              <input type="text" placeholder="Codigo" class="form-control" name="codigo" id="codigo" autocapitalize="none"/>
            </div>
              <hr class="my-4">
              <button id="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Ingresar</button>
            </form>
          </div>
        </div>
      </div>
    </div>
    
</body>
</html>