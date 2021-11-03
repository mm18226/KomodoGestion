package komodosistemaseguridad

import grails.gorm.services.Service

@Service(AreaTrabajo)
interface AreaTrabajoService {

    AreaTrabajo get(Serializable id)

    List<AreaTrabajo> list(Map args)

    Long count()

    void delete(Serializable id)

    AreaTrabajo save(AreaTrabajo areaTrabajo)

}