package edu.softserve.zoo.controller.rest;

import edu.softserve.zoo.dto.AnimalDto;
import edu.softserve.zoo.dto.HouseDto;
import edu.softserve.zoo.model.House;
import edu.softserve.zoo.service.HouseService;
import edu.softserve.zoo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static edu.softserve.zoo.controller.rest.Routes.HOUSES;

/**
 * House domain object REST controller that provides specific methods along with CRUD
 *
 * @author Serhii Alekseichenko
 */
@RestController
@RequestMapping(HOUSES)
public class HouseRestController extends AbstractRestController<HouseDto, House> {

    @Autowired
    private HouseService houseService;

    @Override
    protected Service<House> getService() {
        return houseService;
    }

    @Override
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public HouseDto getById(@PathVariable Long id) {
        return super.getById(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public HouseDto create(@RequestBody HouseDto dto) {
        return super.create(dto);
    }

    @Override
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public HouseDto update(@RequestBody HouseDto dto, @PathVariable Long id) {
        return super.update(dto, id);
    }

    @Override
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        return super.delete(id);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public List<HouseDto> getAll() {
        return super.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, params = "zoneId")
    public List<HouseDto> getAllByZooZoneId(@RequestParam Long zoneId) {
        List<House> allByZoneId = houseService.getAllByZooZoneId(zoneId);
        return converter.convertToDto(allByZoneId);
    }

    @RequestMapping(method = RequestMethod.GET, params = "speciesId")
    public List<AnimalDto> getAllBySpeciesId(@RequestParam Long speciesId) {
        List<House> allBySpeciesId = houseService.getAllAcceptableForNewAnimalBySpeciesId(speciesId);
        return converter.convertToDto(allBySpeciesId);
    }

    @RequestMapping(path = "/populations", method = RequestMethod.GET)
    public Map<Long, Long> getCapacityMap() {
        return houseService.getHousesCurrentCapacityMap();
    }

    @RequestMapping(path="/count", method = RequestMethod.GET)
    @Override
    public Long count() {
        return super.count();
    }
}
