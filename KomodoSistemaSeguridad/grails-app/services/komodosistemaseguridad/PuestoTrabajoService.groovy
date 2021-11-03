package komodosistemaseguridad

import grails.gorm.services.Service

@Service(PuestoTrabajo)
interface PuestoTrabajoService {

    PuestoTrabajo get(Serializable id)

    List<PuestoTrabajo> list(Map args)

    Long count()

    void delete(Serializable id)

    PuestoTrabajo save(PuestoTrabajo puestoTrabajo)

}