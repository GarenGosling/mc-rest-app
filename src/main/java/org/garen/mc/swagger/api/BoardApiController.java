package org.garen.mc.swagger.api;


import io.swagger.annotations.*;

import org.garen.mc.service.BoardManager;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-15T08:16:22.376Z")

@Controller
public class BoardApiController implements BoardApi {
    @Autowired
    private BoardManager boardManager;


    public ResponseEntity<SuccessModel> getBoards() {
        return new ResponseEntity<SuccessModel>(boardManager.getAll(),HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getHotBoards() {
        // do some magic!
        return new ResponseEntity<SuccessModel>(boardManager.getHotBoards(),HttpStatus.OK);
    }


}
