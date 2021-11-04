package pruebaproyecto

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PuestoTrabajoServiceSpec extends Specification {

    PuestoTrabajoService puestoTrabajoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PuestoTrabajo(...).save(flush: true, failOnError: true)
        //new PuestoTrabajo(...).save(flush: true, failOnError: true)
        //PuestoTrabajo puestoTrabajo = new PuestoTrabajo(...).save(flush: true, failOnError: true)
        //new PuestoTrabajo(...).save(flush: true, failOnError: true)
        //new PuestoTrabajo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //puestoTrabajo.id
    }

    void "test get"() {
        setupData()

        expect:
        puestoTrabajoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PuestoTrabajo> puestoTrabajoList = puestoTrabajoService.list(max: 2, offset: 2)

        then:
        puestoTrabajoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        puestoTrabajoService.count() == 5
    }

    void "test delete"() {
        Long puestoTrabajoId = setupData()

        expect:
        puestoTrabajoService.count() == 5

        when:
        puestoTrabajoService.delete(puestoTrabajoId)
        sessionFactory.currentSession.flush()

        then:
        puestoTrabajoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PuestoTrabajo puestoTrabajo = new PuestoTrabajo()
        puestoTrabajoService.save(puestoTrabajo)

        then:
        puestoTrabajo.id != null
    }
}
