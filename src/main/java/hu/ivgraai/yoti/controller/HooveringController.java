package hu.ivgraai.yoti.controller;

import hu.ivgraai.yoti.dto.Input;
import hu.ivgraai.yoti.service.HooveringService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gergo Ivan
 */
@RestController
public class HooveringController {

    @Autowired
    private HooveringService service;

    @RequestMapping(value = "/navigate", method = RequestMethod.POST)
    public Object navigate(@Valid @RequestBody Input input) {
        // curl -X POST http://localhost:8080/navigate -H 'Content-Type: application/json' -d '{"roomSize" : [5, 5],"coords" : [1, 2],"patches" : [[1, 0],[2, 2],[2, 3]],"instructions" : "NNESEESWNWW"}'
        return service.navigate(input);
    }

}
