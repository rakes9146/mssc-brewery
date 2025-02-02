package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Rakesh")
                .build();

    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Rakesh")
                .build();
    }

    //do implementation later
    @Override
    public void updateCustomer(CustomerDto customerDto) {
        //to do impl
    }

    @Override
    public void deleteCustomerById(UUID customerId) {

        log.info("Delete customer id");
    }


}
