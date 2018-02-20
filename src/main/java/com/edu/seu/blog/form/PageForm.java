package com.edu.seu.blog.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class PageForm {

    @NotNull(message = "请求页数出错")
    @Min(value = 1,message = "页数必须大于0")
    private Integer page;

    @NotNull(message = "请求状态出错")
    @Min(value = 1,message = "页数必须大于0")
    private Integer size;
}
