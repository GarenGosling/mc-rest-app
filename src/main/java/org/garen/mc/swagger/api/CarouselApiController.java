package org.garen.mc.swagger.api;


import io.swagger.annotations.*;

import org.garen.mc.service.CarouselManager;
import org.garen.mc.swagger.model.SuccessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-15T08:23:34.430Z")

@Controller
public class CarouselApiController implements CarouselApi {
    @Autowired
    private CarouselManager carouselManager;


    public ResponseEntity<SuccessModel> getCarousels() {
        return new ResponseEntity<SuccessModel>(carouselManager.getAll(),HttpStatus.OK);
    }

}
