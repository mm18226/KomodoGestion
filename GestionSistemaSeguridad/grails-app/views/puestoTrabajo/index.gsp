<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'puestoTrabajo.label', default: 'PuestoTrabajo')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-puestoTrabajo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
            <li><a class="home" href="${createLink(uri: '/empleado/index')}">Volver a Empleado</a></li>
                <li><a class="create" href="${createLink(uri: '/areaDeTrabajo/index')}">Volver Area de Trabajo</a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-puestoTrabajo" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${puestoTrabajoList}" />

            <div class="pagination">
                <g:paginate total="${puestoTrabajoCount ?: 0}" />
            </div>
        </div>
    </body>
</html>