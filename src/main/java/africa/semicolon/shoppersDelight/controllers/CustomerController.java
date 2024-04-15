package africa.semicolon.shoppersDelight.controllers;


import africa.semicolon.shoppersDelight.dtos.request.CustomerRegistrationRequest;
import africa.semicolon.shoppersDelight.dtos.request.UpdateCustomerRequest;
import africa.semicolon.shoppersDelight.dtos.response.ApiResponse;
import africa.semicolon.shoppersDelight.dtos.response.CustomerRegistrationResponse;
import africa.semicolon.shoppersDelight.services.CustomerService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @PostMapping
    public ResponseEntity<CustomerRegistrationResponse> registerCustomer(@RequestBody CustomerRegistrationRequest registrationRequest){
        logger.trace("register customer called");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.register(registrationRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody UpdateCustomerRequest request, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(customerService.updateCustomer(id, request));

        }catch (Exception exception){
            return ResponseEntity.badRequest().body(new ApiResponse<>(exception.getMessage()));
        }
    }
    @GetMapping("getCustomer/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable("id")Long id){
        return ResponseEntity.ok(customerService.getCustomerBy(id));
    }
}
