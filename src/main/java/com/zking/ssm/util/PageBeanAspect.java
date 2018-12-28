package com.zking.ssm.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageBeanAspect {

    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable {
        Object[] pramas = args.getArgs();
        PageBean pageBean = null;
        for (Object prama : pramas) {
            if (prama instanceof PageBean){
                pageBean = (PageBean) prama;
                break;
            }
        }

        if(null!=pageBean&&pageBean.isPagination())
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());

        Object result = args.proceed(pramas);

        if(null!=pageBean&&pageBean.isPagination()){
            List lis = (List)result;
            PageInfo pageInfo = new PageInfo(lis);
            System.out.println("当前页码："+pageInfo.getPageNum());
            System.out.println("每页多少条记录:"+pageInfo.getPageSize());
            System.out.println("总记录数："+pageInfo.getTotal());
            pageBean.setTotal(pageInfo.getTotal()+"");
        }

        return result;
    }

}
