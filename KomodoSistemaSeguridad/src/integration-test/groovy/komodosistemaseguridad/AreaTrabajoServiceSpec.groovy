package komodosistemaseguridad

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AreaTrabajoServiceSpec extends Specification {

    AreaTrabajoService areaTrabajoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AreaTrabajo(...).save(flush: true, failOnError: true)
        //new AreaTrabajo(...).save(flush: true, failOnError: true)
        //AreaTrabajo areaTrabajo = new AreaTrabajo(...).save(flush: true, failOnError: true)
        //new AreaTrabajo(...).save(flush: true, failOnError: true)
        //new AreaTrabajo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //areaTrabajo.id
    }

    void "test get"() {
        setupData()

        expect:
        areaTrabajoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AreaTrabajo> areaTrabajoList = areaTrabajoService.list(max: 2, offset: 2)

        then:
        areaTrabajoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        areaTrabajoService.count() == 5
    }

    void "test delete"() {
        Long areaTrabajoId = setupData()

        expect:
        areaTrabajoService.count() == 5

        when:
        areaTrabajoService.delete(areaTrabajoId)
        sessionFactory.currentSession.flush()

        then:
        areaTrabajoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AreaTrabajo areaTrabajo = new AreaTrabajo()
        areaTrabajoService.save(areaTrabajo)

        then:
        areaTrabajo.id != null
    }
}
