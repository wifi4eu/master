package wifi4eu.wifi4eu.web.rest;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping(value = "/foos")
public class FooController {

    Logger _log = LogManager.getLogger(FooController.class);

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public FooController() {
        super();
    }

    // API

    // read - one

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String findById(@PathVariable("id") final Long id, final HttpServletResponse response) {

        return "{id:1;name:'juan'}";
    }

    // read - all

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<String> findAll() {

        final List<String> list = new ArrayList<>();

        list.add("{id:1;name:'juan'}");
        list.add("{id:2;name:'pepe'}");

        return list;
    }

    @RequestMapping(params = { "page", "size" }, method = RequestMethod.GET)
    @ResponseBody
    public List<String> findPaginated(@RequestParam("page") final int page, @RequestParam("size") final int size,
                                      final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
        final List<String> list = new ArrayList<>();

        list.add("{id:1;name:'juan'");
        list.add("{id:2;name:'pepe'");

        return list;
    }

    // write

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final String resource, final HttpServletResponse response) {
        _log.info(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") final Long id, @RequestBody final String resource) {
        _log.info(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") final Long id) {
        _log.info(id);
    }

}
