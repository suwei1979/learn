/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package com.bocsoft.bocebiz.eloan.domain.repository;

import com.bocsoft.bocebiz.eloan.domain.model.application.ProductType;

public interface ProductRepository {

    ProductType findByProductCode(String productCode);

}
