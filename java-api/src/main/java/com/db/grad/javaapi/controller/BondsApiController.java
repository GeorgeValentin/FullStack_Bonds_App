package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Bond;
import com.db.grad.javaapi.service.BondService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BondsApiController {

    public static final Logger logger = LogManager.getLogger(BondsApiController.class);

    @Autowired
    private BondService bondService;

    @GetMapping("/activeBonds")
    public ResponseEntity<List<Bond>> getActiveBonds() {
        return ResponseEntity.ok().body(bondService.getActiveBonds());
    }

    @GetMapping("/bonds")
    public ResponseEntity<List<Bond>> getBonds(
            @RequestParam(required = false, name = "active")  String isActive
    ) {
        List<Bond> bonds = new ArrayList<>();

        if (isActive == null) {
            logger.info("No active request param is provided. Returning all bonds");
            bonds = bondService.getAllBonds();
        } else {
            if ("true".equalsIgnoreCase(isActive)) {
                logger.info("No active request param is provided. Returning active bonds");
                bonds = bondService.getActiveBonds();
            } else if ("false".equalsIgnoreCase(isActive)) {
                logger.info("No active request param is provided. Returning inactive bonds");
                bonds = bondService.getInactiveBonds();
            }
        }

        return ResponseEntity.ok().body(bonds);
    }

    @GetMapping("/bonds/{id}")
    public ResponseEntity getBondsById(@PathVariable(value = "id") Integer id) {
        Optional result = bondService.getBondsById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        }return ResponseEntity.notFound().build();
    }

}
