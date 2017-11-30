package com.oryx.core.endpoint;

import com.oryx.core.enums.EnumServiceOperation;

/**
 * Created by 241180 on 10/01/2017.
 */
public interface IServiceEndPoint<Q, R, QD> {
    public EnumServiceOperation getRequestOperation(QD xmlOperationDescIn);

    public String getSessionToken(Q request);

    public boolean isSessionValid(Q request);

    public R superCrudOperation(Q request);
}
