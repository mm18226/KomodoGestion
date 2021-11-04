package pruebaproyecto

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AreaDeTrabajoServiceSpec extends Specification {

    AreaDeTrabajoService areaDeTrabajoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AreaDeTrabajo(...).save(flush: true, failOnError: true)
        //new AreaDeTrabajo(...).save(flush: true, failOnError: true)
        //AreaDeTrabajo areaDeTrabajo = new AreaDeTrabajo(...).save(flush: true, failOnError: true)
        //new AreaDeTrabajo(...).save(flush: true, failOnError: true)
        //new AreaDeTrabajo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //areaDeTrabajo.id
    }

    void "test get"() {
        setupData()

        expect:
        areaDeTrabajoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AreaDeTrabajo> areaDeTrabajoList = areaDeTrabajoService.list(max: 2, offset: 2)

        then:
        areaDeTrabajoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        areaDeTrabajoService.count() == 5
    }

    void "test delete"() {
        Long areaDeTrabajoId = setupData()

        expect:
        areaDeTrabajoService.count() == 5

        when:
        areaDeTrabajoService.delete(areaDeTrabajoId)
        sessionFactory.currentSession.flush()

        then:
        areaDeTrabajoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AreaDeTrabajo areaDeTrabajo = new AreaDeTrabajo()
        areaDeTrabajoService.save(areaDeTrabajo)

        then:
        areaDeTrabajo.id != null
    }
}
