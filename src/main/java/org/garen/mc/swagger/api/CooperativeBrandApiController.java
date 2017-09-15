package org.garen.mc.swagger.api;

import io.swagger.annotations.*;

import org.garen.mc.mybatis.domain.CooperativeBrand;
import org.garen.mc.service.CooperativeBrandManager;
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

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-15T07:53:58.924Z")

@Controller
public class CooperativeBrandApiController implements CooperativeBrandApi {
    @Autowired
    private CooperativeBrandManager cooperativeBrandManager;


    public ResponseEntity<SuccessModel> getCoperativeBrand() {
        return new ResponseEntity<SuccessModel>(cooperativeBrandManager.getAll(),HttpStatus.OK);
    }

}
