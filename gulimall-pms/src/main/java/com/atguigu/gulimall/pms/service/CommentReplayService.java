package com.atguigu.gulimall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.pms.entity.CommentReplayEntity;
import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.QueryCondition;


/**
 * 商品评价回复关系
 *
 * @author nineteaaa
 * @email 169328498@qq.com
 * @date 2019-08-01 23:35:23
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageVo queryPage(QueryCondition params);
}

