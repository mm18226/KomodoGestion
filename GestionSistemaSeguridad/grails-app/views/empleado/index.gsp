<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'empleado.label', default: 'Empleado')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-empleado" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="create" href="${createLink(uri: '/areaDeTrabajo/index')}">Area de Trabajo</a></li>
                <li><a class="create" href="${createLink(uri: '/puestoTrabajo/index')}">Puesto de Trabajo</a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                
            </ul>
        </div>
        <div id="list-empleado" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${empleadoList}" />

            <div class="pagination">
                <g:paginate total="${empleadoCount ?: 0}" />
            </div>
        </div>
    </body>
</html>