package com.jiejing.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by evil on 6/15/16.
 */
@Data @AllArgsConstructor @NoArgsConstructor public class XmEnum {
    List<XmEnumParam> GradeId;
    List<XmEnumParam> SubjectId;
    List<XmEnumParam> BPaymentType;
    List<XmEnumParam> ContractType;
    List<XmEnumParam> PaymentStatus;
}


