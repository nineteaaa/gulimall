package com.atguigu.gulimall.pms.controller;

import java.util.Arrays;


import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.QueryCondition;
import com.atguigu.gulimall.commons.bean.Resp;
import com.atguigu.gulimall.pms.vo.AttrSaveVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gulimall.pms.entity.AttrEntity;
import com.atguigu.gulimall.pms.service.AttrService;


/**
 * 商品属性
 *
 * @author nineteaaa
 * @email 169328498@qq.com
 * @date 2019-08-01 23:35:23
 */
@Api(tags = "商品属性 管理")
@RestController
@RequestMapping("pms/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;



    @ApiOperation("查询某个三级分类下的所有销售属性")
    @GetMapping("/sale/{catId}")
    public Resp<PageVo> getCategorySaleAttr(
            @ApiParam(name = "catId",value = "分类Id",required = true)
            @PathVariable(value = "catId")Long catId,
            QueryCondition queryCondition){
           PageVo pageVo = attrService.queryPageCategorySaleAttr(catId,queryCondition,0);
           return Resp.ok(pageVo);
    }



    @ApiOperation("查询某个三级分类下的所有基本属性")
    @GetMapping("/base/{catId}")
    public Resp<PageVo> getCategoryBaseAttr(
            @ApiParam(name = "catId", value = "分类id", required = true)
            @PathVariable(value = "catId") Long catId,
            QueryCondition queryCondition) {
        PageVo pageVo = attrService.queryPageCategoryBaseAttr(catId, queryCondition, 1);
        return Resp.ok(pageVo);
    }


    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:attr:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = attrService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{attrId}")
    @PreAuthorize("hasAuthority('pms:attr:info')")
    public Resp<AttrEntity> info(@PathVariable("attrId") Long attrId) {
        AttrEntity attr = attrService.getById(attrId);

        return Resp.ok(attr);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('pms:attr:save')")
    public Resp<Object> save(@RequestBody AttrSaveVo attr) {
        attrService.saveAttrAndRelation(attr);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('pms:attr:update')")
    public Resp<Object> update(@RequestBody AttrEntity attr) {
        attrService.updateById(attr);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('pms:attr:delete')")
    public Resp<Object> delete(@RequestBody Long[] attrIds) {
        attrService.removeByIds(Arrays.asList(attrIds));

        return Resp.ok(null);
    }

}
