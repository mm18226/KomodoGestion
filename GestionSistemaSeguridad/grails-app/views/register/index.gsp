<html>
<head>
    <meta name="layout" content="${gspLayout ?: 'main'}"/>
    <title>Registrarse</title>
</head>

<body>
    <div class="row">
    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
      <div class="card card-signin my-5">
        <div class="card-body">
          <h5 class="card-title text-center">Registrarse Aqui</h5>
                    <g:if test='${flash.message}'>
                        <div class="alert alert-danger" role="alert">${flash.message}</div>
                    </g:if>
              <form class="form-signin" action="register" method="POST" id="loginForm" autocomplete="off">
                      <!--<div class="form-group">
                          <label for="role">Role</label>
              <g:select class="form-control" name="role.id"
                    from="${pruebaproyecto.Role.list()}"
                    optionKey="id" />
                </div>-->

            <div class="form-group">
                    <label for="username">Dui</label>
              <input type="text" placeholder="Ingrese su DUI" class="form-control" name="dui" id="dui" autocapitalize="none" pattern="[0-9]{9}"/>
            </div>

            <div class="form-group">
                          <label for="password">Correo Electronico</label>
              <input type="text" placeholder="Ingrese su email" class="form-control" name="email" id="email"/>
            </div>

            <div class="form-group">
                          <label for="password">Telefono Movil</label>
              <input type="text" placeholder="Ingrese su numero de movil" class="form-control" name="telefono" id="telefono"/>
            </div>

                      <!--<div class="form-group">
                          <label for="username">Full Name</label>
              <input type="text" placeholder="Your full name" class="form-control" name="fullname" id="fullname" autocapitalize="none"/>
            </div>-->

            <button id="submit" class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
            <hr class="my-4">
            <p>Already have an account? <g:link controller="login" action="auth">Login</g:link></p>
          </form>
        </div>
      </div>
    </div>
  </div>
    <script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function(event) {
            document.forms['loginForm'].elements['username'].focus();
        });
    </script>
</body>
</html>
