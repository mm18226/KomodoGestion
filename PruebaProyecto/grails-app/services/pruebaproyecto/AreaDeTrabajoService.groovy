package pruebaproyecto

import grails.gorm.services.Service

@Service(AreaDeTrabajo)
interface AreaDeTrabajoService {

    AreaDeTrabajo get(Serializable id)

    List<AreaDeTrabajo> list(Map args)

    Long count()

    void delete(Serializable id)

    AreaDeTrabajo save(AreaDeTrabajo areaDeTrabajo)

}