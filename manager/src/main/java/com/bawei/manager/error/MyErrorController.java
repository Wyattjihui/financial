package com.bawei.manager.error;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public class MyErrorController extends BasicErrorController {
    public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties,
                             List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorProperties, errorViewResolvers);
    }
    /**
     * {
     *     "timestamp": "2019-06-10 18:59:22",
     *     "status": 500,
     *     "error": "Internal Server Error",
     *     "exception": "java.lang.IllegalArgumentException",
     *     "message": "数据id不可为空",
     *     "path": "/manager/products"
     * }
     */
    @Override
    protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        // 删除不需要的属性
        Map<String, Object> errorAttributes = super.getErrorAttributes(request, includeStackTrace);
        errorAttributes.remove("timestamp");
        errorAttributes.remove("status");
        errorAttributes.remove("error");
        errorAttributes.remove("exception");
        errorAttributes.remove("path");
        String code = (String) errorAttributes.get("message");
        ErrorEnum errorEnum = ErrorEnum.getByCode(code);
        errorAttributes.put("message",errorEnum.getMessage());
        errorAttributes.put("code",errorEnum.getCode());
        errorAttributes.put("canRetry",errorEnum.isCanRetry());
        return errorAttributes;
    }
}
