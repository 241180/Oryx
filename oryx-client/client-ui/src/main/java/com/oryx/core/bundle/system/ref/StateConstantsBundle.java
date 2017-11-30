package com.oryx.core.bundle.system.ref;

import com.oryx.core.annotation.decl.DefaultStringValue;
import com.oryx.core.bundle.common.ICommonConstantBundle;

/**
 * Created by 241180 on 13/01/2017.
 */

@DefaultStringValue("State details")
public interface StateConstantsBundle extends ICommonConstantBundle {
    @DefaultStringValue("City")
    public String XmlState();

    @DefaultStringValue("Name")
    public String name();

    @DefaultStringValue("Country name")
    public String countryName();

    @DefaultStringValue("Postal code")
    public String postalCode();

    @DefaultStringValue("Latitude")
    public String latitude();

    @DefaultStringValue("Longitude")
    public String longitude();

    @DefaultStringValue("Altitude")
    public String altitude();

    @DefaultStringValue("Country")
    public String countryId();
}
