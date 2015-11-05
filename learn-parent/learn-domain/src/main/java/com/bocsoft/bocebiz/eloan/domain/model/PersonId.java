package com.bocsoft.bocebiz.eloan.domain.model;

import lombok.Data;

/**
 * id 3 item : certificateType(id), certificateNumber(id num), customer name
 * Created by li10 on 15-6-17.
 */
@Data
public class PersonId {

    String cbiCerTy;
    String cbiCerNo;
    String cbiCusNm;

}
