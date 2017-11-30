package com.oryx.core.bundle.bu.stock;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("Appointment details")
public interface StockPositionConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("Appointment")
    public String XmlRdv();

    @DefaultStringValue("Date/Time")
    public String rdvDateTime();

    @DefaultStringValue("Duration (min)")
    public String duration();

    @DefaultStringValue("Status")
    public String status();

    @DefaultStringValue("Host")
    public String hostId();

    @DefaultStringValue("Guest")
    public String guestId();

    //status enum
    @DefaultStringValue("Delayed")
    public String DELAYED();

    @DefaultStringValue("Completed")
    public String COMPLETED();

    @DefaultStringValue("Planned")
    public String PLANNED();

    @DefaultStringValue("Rejected")
    public String REJECTED();

    @DefaultStringValue("Canceled")
    public String CANCELED();

    @DefaultStringValue("Accepted")
    public String ACCEPTED();
}
