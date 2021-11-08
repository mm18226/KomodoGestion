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
            <h5 class="card-title text-center">Ingrese una nueva contraseña</h5>
            <g:if test='${flash.message}'>
                        <div class="alert alert-danger" role="alert">${flash.message}</div>
                        </g:if>
            <form class="form-signin" action="confirmarContraseña" method="POST" id="cambiarContraseñaForm" autocomplete="off">
            <div class="form-group">
                          <label for="password">Contraseña: </label>
              <input type="password" placeholder="Password" class="form-control" name="password" id="password" pattern="^(?=.*\d)(?=.*[\u0021-\u002b\u003c-\u0040])(?=.*[A-Z])(?=.*[a-z])\S{12,16}$"/>
              <i id="passwordToggler" title="toggle password display" onclick="passwordDisplayToggle()">&#128065;</i>
            </div>

            <div class="form-group">
                          <label for="password">Confirmar contraseña: </label>
              <input type="password" placeholder="confirm password" class="form-control" name="repassword" id="repassword" pattern="^(?=.*\d)(?=.*[\u0021-\u002b\u003c-\u0040])(?=.*[A-Z])(?=.*[a-z])\S{12,16}$"/>
            </div>
              <hr class="my-4">
              <button id="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Confirmar</button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript">
    function passwordDisplayToggle() {
            var toggleEl = document.getElementById("passwordToggler");
            var eyeIcon = '\u{1F441}';
            var xIcon = '\u{2715}';
            var passEl = document.getElementById("password");
            if (passEl.type === "password") {
                toggleEl.innerHTML = xIcon;
                passEl.type = "text";
            } else {
                toggleEl.innerHTML = eyeIcon;
                passEl.type = "password";
            }
        }
    </script>
    
</body>
</html>