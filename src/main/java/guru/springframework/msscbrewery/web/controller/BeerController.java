package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping  //create new post mapping
    public ResponseEntity handlePost(@Valid @RequestBody  BeerDto beerDto){

        BeerDto savedDt = beerService.saveNewBeer(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        //to do add host name url
        httpHeaders.add("Location", "/api/v1/beer/"+savedDt.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }


    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable  UUID beerId,@Valid  @RequestBody BeerDto beerDto){

        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping({"/{beerId}"})
   @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId" +
            "") UUID beerId){

        beerService.deleteById(beerId);
    }

}
