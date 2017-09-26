/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.garen.mc.swagger.api;



import io.swagger.annotations.*;
import org.garen.mc.swagger.model.Carousel;
import org.garen.mc.swagger.model.ErrorModel;
import org.garen.mc.swagger.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-26T09:15:17.936Z")

@Api(value = "carousel", description = "the carousel API")
public interface CarouselApi {

    @ApiOperation(value = "删除首页轮播图", notes = "删除首页轮播图 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/carousel",
        method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deleteCarousel(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Integer id);


    @ApiOperation(value = "查询全部", notes = "查询全部 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/carousel/all",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getAll();




    @ApiOperation(value = "通过描述查询", notes = "通过描述查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/carousel/description",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByDescription(@ApiParam(value = "首页轮播图描述信息") @RequestParam(value = "description", required = false) String description);


    @ApiOperation(value = "分页查询首页轮播图", notes = "分页查询首页轮播图 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/carousel/page",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start, @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length, @ApiParam(value = "首页轮播图描述信息") @RequestParam(value = "description", required = false) String description);


    @ApiOperation(value = "通过状态和位置查询", notes = "状态和位置查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/carousel/statusAndPlace",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByStatusAndPlace(@Size(max = 1) @ApiParam(value = "0表示不显示首页，1表示显示首页") @RequestParam(value = "status", required = false) Integer status, @Size(max = 2) @ApiParam(value = "位置编号") @RequestParam(value = "place", required = false) Integer place);


    @ApiOperation(value = "ID查询", notes = "ID查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/carousel",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getCarousel(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Integer id);


    @ApiOperation(value = "新增首页轮播图", notes = "新增首页轮播图 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/carousel",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> saveCarousel(@ApiParam(value = "首页轮播图") @Valid @RequestBody Carousel carousel);


    @ApiOperation(value = "修改首页轮播图", notes = "修改首页轮播图 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/carousel",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updateCarousel(@ApiParam(value = "首页轮播图") @Valid @RequestBody Carousel carousel);

}
