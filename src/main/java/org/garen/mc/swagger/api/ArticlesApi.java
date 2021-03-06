/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.garen.mc.swagger.api;


import io.swagger.annotations.*;
import org.garen.mc.swagger.model.Article;
import org.garen.mc.swagger.model.Audit;
import org.garen.mc.swagger.model.ErrorModel;
import org.garen.mc.swagger.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-24T09:48:54.707Z")

@Api(value = "articles", description = "the articles API")
public interface ArticlesApi {

    @ApiOperation(value = "id删除", notes = "根据文章id删除文章和文章详情 ", response = ResponseModel.class, tags={ "article", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/api/articles/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deleteArticle(@ApiParam(value = "文章id", required = true) @PathVariable("id") Long id,HttpServletRequest request);


    @ApiOperation(value = "查询全部", notes = "查询全部文章 ", response = ResponseModel.class, tags={ "article", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/articles",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> findALL();









    @ApiOperation(value = "查询文章", notes = "文章统一查询方法", response = ResponseModel.class, tags={ "article", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/articles/query",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> findArticle(@ApiParam(value = "文章标题") @RequestParam(value = "title", required = false) String title,
                                              @ApiParam(value = "菜单码，按照菜单码模糊查询文章菜单码全路径字段") @RequestParam(value = "menuCode", required = false) String menuCode,
                                              @ApiParam(value = "专题名称，按照专题名称查询") @RequestParam(value = "subjectName", required = false) String subjectName,
                                              @ApiParam(value = "是否显示文章详情，1显示，0不显示") @RequestParam(value = "showDetail", required = false) Integer showDetail,
                                              @ApiParam(value = "排序字段") @RequestParam(value = "orderBy", required = false) String orderBy,
                                              @ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
                                              @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
                                              @ApiParam(value = "文章状态") @RequestParam(value = "status", required = false) Integer status,
                                              @ApiParam(value = "（0:等于菜单码查询，1:不等于菜单码查询）") @RequestParam(value = "notMenuCode", required = false) Integer notMenuCode);



    @ApiOperation(value = "id查询", notes = "根据文章id查询文章和文章的详情 ", response = ResponseModel.class, tags={ "article", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/articles/{id}",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getArticle(@ApiParam(value = "文章id", required = true) @PathVariable("id") Long id);


    @ApiOperation(value = "发布文章", notes = "发布文章 ", response = ResponseModel.class, tags={ "article", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/api/articles",
        produces = { "application/json" },
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> saveArticle(@ApiParam(value = "文章") @Valid @RequestBody Article article, HttpServletRequest request);


    @ApiOperation(value = "修改文章", notes = "根据文章id修改文章 ", response = ResponseModel.class, tags={ "article", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/api/articles/{id}",
        produces = { "application/json" },
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updateArticle(@ApiParam(value = "文章id", required = true) @PathVariable("id") Long id, @ApiParam(value = "文章") @Valid @RequestBody Article article,HttpServletRequest request);

    @ApiOperation(value = "精选会员专题", notes = "精选会员专题，根据作者的所有文章的查看数字进行倒排序，显示相关作者的最受欢迎的文章 整体显示的是（作者和其中最受欢迎的一片文章）的列表 ", response = ResponseModel.class, tags={ "article", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/articles/popAuthor",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> findPopAuthor(@ApiParam(value = "菜单码，按照菜单码模糊查询文章菜单码全路径字段") @RequestParam(value = "menuCode", required = false) String menuCode,@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,@ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length);
    @ApiOperation(value = "审核文章", notes = "根据文章id修改文章 ", response = ResponseModel.class, tags={ "article", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/api/articles/audit",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> auditArticle(@ApiParam(value = "审核对象"  )  @Valid @RequestBody Audit audit);
    @ApiOperation(value = "状态查询文章", notes = "状态查询文章", response = ResponseModel.class, tags={ "article",   })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/articles/status",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> findByStatus(@ApiParam(value = "状态（0：未审核，1：审核通过，2：审核驳回）") @RequestParam(value = "status", required = false) Integer status);
    @ApiOperation(value = "根据用户查询文章", notes = "根据用户查询文章（管理员查询和普通用户查看自己的文章） 普通用户只能查看自己发的文章，管理员可以查看别人的文章，通过前端你舒服 ", response = ResponseModel.class, tags={ "article", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/api/articles/queryByAuthor",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> findArticle2(@ApiParam(value = "文章标题") @RequestParam(value = "title", required = false) String title,@ApiParam(value = "菜单码，按照菜单码模糊查询文章菜单码全路径字段") @RequestParam(value = "menuCode", required = false) String menuCode,@ApiParam(value = "专题名称，按照专题名称查询") @RequestParam(value = "subjectName", required = false) String subjectName,@ApiParam(value = "排序字段") @RequestParam(value = "orderBy", required = false) String orderBy,@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,@ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,@ApiParam(value = "作者名称或者真实姓名") @RequestParam(value = "authorName", required = false) String authorName,@ApiParam(value = "审核状态") @RequestParam(value = "status", required = false) Integer status,HttpServletRequest request);
}
