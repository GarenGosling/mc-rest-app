package org.garen.mc.swagger.api;



import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.garen.mc.service.CarouselManage;
import org.garen.mc.swagger.api.valid.CarouselValid;
import org.garen.mc.swagger.model.BaseModel;
import org.garen.mc.swagger.model.Carousel;
import org.garen.mc.swagger.model.ResponseModel;
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
import java.util.Map;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-25T07:24:22.118Z")

@Controller
public class CarouselApiController extends BaseModel implements CarouselApi {
    @Autowired
    private CarouselManage carouselManage;
    @Autowired
    private CarouselValid carouselValid;
    /**
     * 删除
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> deleteCarousel(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Integer id) {
        //验证
        String msg=carouselValid.idValid(id);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        int i=carouselManage.deleteCarousel(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i),HttpStatus.OK);
    }

    /**
     * 查询全部
     * @return
     */
    public ResponseEntity<ResponseModel> getAll() {
        //业务
        List<org.garen.mc.mybatis.domain.Carousel> carousels=carouselManage.getAll();
        return new ResponseEntity<ResponseModel>(successModel("查询全部",carousels),HttpStatus.OK);
    }

    /**
     * 描述查询
     * @param description
     * @return
     */
    public ResponseEntity<ResponseModel> getByDescription(@ApiParam(value = "首页轮播图描述信息") @RequestParam(value = "description", required = false) String description) {
        //业务
        List<org.garen.mc.mybatis.domain.Carousel> carousels=carouselManage.getByDescription(description);
        return new ResponseEntity<ResponseModel>(successModel("描述查询",carousels),HttpStatus.OK);
    }

    /**
     * 分页查询
     * @param start
     * @param length
     * @param description
     * @return
     */
    public ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
        @ApiParam(value = "首页轮播图描述信息") @RequestParam(value = "description", required = false) String description) {
        //业务
        Map map=carouselManage.getByPage(start,length,description);
        return new ResponseEntity<ResponseModel>(successModel("分页查询",map),HttpStatus.OK);
    }



    /**
     * 状态和位置查询
     * @param status
     * @return
     */
    public ResponseEntity<ResponseModel> getByStatusAndPlace( @Size(max=1)@ApiParam(value = "0表示不显示首页，1表示显示首页") @RequestParam(value = "status", required = false) Integer status,
                                                              @Size(max=50)@ApiParam(value = "位置编号") @RequestParam(value = "place", required = false) String place) {
        //验证
        String msg=carouselValid.statusValid(status);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg),HttpStatus.OK);
        String msg2=carouselValid.placeValid(place);
        if(StringUtils.isNotBlank(msg2))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg2),HttpStatus.OK);
        //业务
        List<org.garen.mc.mybatis.domain.Carousel> carousels=carouselManage.getByStatusAndPlace(status,place);
        return new ResponseEntity<ResponseModel>(successModel("状态和位置查询",carousels),HttpStatus.OK);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> getCarousel(@ApiParam(value = "ID") @RequestParam(value = "id", required = false) Integer id) {
        //验证
        String msg=carouselValid.idValid(id);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg),HttpStatus.OK);
        //业务
        org.garen.mc.mybatis.domain.Carousel carousel=carouselManage.getById(id);
        return new ResponseEntity<ResponseModel>(HttpStatus.OK);
    }

    /**
     * 保存
     * @param carousel
     * @return
     */
    public ResponseEntity<ResponseModel> saveCarousel(@ApiParam(value = "首页轮播图"  )  @Valid @RequestBody Carousel carousel) {
        //验证新增对象参数
        String msg = carouselValid.saveCarouselValid(carousel);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        //业务
        int i=carouselManage.saveCarousel(carousel);
        return new ResponseEntity<ResponseModel>(successModel("新增成功，数量：" + i),HttpStatus.OK);
    }

    /**
     * 修改
     * @param carousel
     * @return
     */
    public ResponseEntity<ResponseModel> updateCarousel(@ApiParam(value = "首页轮播图"  )  @Valid @RequestBody Carousel carousel) {
        //验证
        String msg = carouselValid.updateCarouselValid(carousel);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        //业务
        int i=carouselManage.updateCarousel(carousel);
        return new ResponseEntity<ResponseModel>(successModel("修改成功，数量：" + i),HttpStatus.OK);
    }

}
