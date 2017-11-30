package crud.controller;

import crud.backend.Person;
import crud.backend.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by 241180 on 13/03/2017.
 */
@Controller //http://localhost:8090/upgradeTask
@RequestMapping("/upgradeTask")
public class UpgradeTaskController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    PersonRepository personRepository;

    @Autowired
    private DataSource dataSource;

    @RequestMapping(method = RequestMethod.GET, produces = {/*MediaType.APPLICATION_JSON_VALUE, */MediaType.APPLICATION_XML_VALUE})
    public
    @ResponseBody
    List<Person> upgradeTask(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        return personRepository.findAll();
    }
}
