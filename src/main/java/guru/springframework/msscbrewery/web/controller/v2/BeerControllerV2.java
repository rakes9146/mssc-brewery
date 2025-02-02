package guru.springframework.msscbrewery.web.controller.v2;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2)
    {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping  //create new post mapping
    public ResponseEntity handlePost(@RequestBody  BeerDto beerDto){

        BeerDto savedDt = beerServiceV2.saveNewBeer(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        //to do add host name url
        httpHeaders.add("Location", "/api/v1/beer/"+savedDt.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }


    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable  UUID beerId,@RequestBody BeerDto beerDto){

        beerServiceV2.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerID") UUID beerId){

        beerServiceV2.deleteById(beerId);
    }

}
