package com.example.demo_be.base.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.example.demo_be.base.entity.CommonEntity;
import com.example.demo_be.base.entity.CommonEntityD;
import com.example.demo_be.base.response.SearchResponse;
import com.example.demo_be.base.search.BaseSearchRequest;
import com.example.demo_be.base.service.BaseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class BaseServiceImpl implements BaseService {

   protected void setCreateCommon(CommonEntity entity, String username) {

      entity.setCreatedBy(username);
      entity.setCreatedDt(new Timestamp(System.currentTimeMillis()));
      entity.setDeletedFlag(false);

   }

   protected void setCreateCommonD(CommonEntityD entity, String username) {

      entity.setCreatedBy(username);
      entity.setCreatedDt(new Timestamp(System.currentTimeMillis()));

   }

   protected void setUpdateCommon(CommonEntity entity, String username) {
      entity.setChangedBy(username);
      entity.setChangedDt(new Timestamp(System.currentTimeMillis()));
      entity.setDeletedFlag(false);
   }

   protected void setUpdateCommonD(CommonEntityD entity, String username) {
      entity.setChangedBy(username);
      entity.setChangedDt(new Timestamp(System.currentTimeMillis()));
   }

   protected void setDeleteCommon(CommonEntity entity, String username) {
      entity.setChangedBy(username);
      entity.setChangedDt(new Timestamp(System.currentTimeMillis()));
   }

   protected <T> SearchResponse createSearchResponse(Page<T> page, BaseSearchRequest request) {
      List<T> data = page.toList();

      return new SearchResponse<>(request.getPageNo(), request.getPageSize(), data.size(), page.getTotalElements(),
            page.getTotalPages(), data);
   }

   protected Pageable getPageable(BaseSearchRequest request) {
      return PageRequest.of(request.getPageNo() - 1, request.getPageSize());
   }

}
