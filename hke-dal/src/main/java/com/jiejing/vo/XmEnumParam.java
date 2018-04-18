package com.jiejing.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by evil on 6/16/16.
 */
@Data @Builder @AllArgsConstructor @NoArgsConstructor public class XmEnumParam {
    Integer code;
    String value;
}
