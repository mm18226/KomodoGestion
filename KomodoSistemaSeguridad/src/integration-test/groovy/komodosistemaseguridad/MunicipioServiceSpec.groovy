package komodosistemaseguridad

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MunicipioServiceSpec extends Specification {

    MunicipioService municipioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Municipio(...).save(flush: true, failOnError: true)
        //new Municipio(...).save(flush: true, failOnError: true)
        //Municipio municipio = new Municipio(...).save(flush: true, failOnError: true)
        //new Municipio(...).save(flush: true, failOnError: true)
        //new Municipio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //municipio.id
    }

    void "test get"() {
        setupData()

        expect:
        municipioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Municipio> municipioList = municipioService.list(max: 2, offset: 2)

        then:
        municipioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        municipioService.count() == 5
    }

    void "test delete"() {
        Long municipioId = setupData()

        expect:
        municipioService.count() == 5

        when:
        municipioService.delete(municipioId)
        sessionFactory.currentSession.flush()

        then:
        municipioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Municipio municipio = new Municipio()
        municipioService.save(municipio)

        then:
        municipio.id != null
    }
}
