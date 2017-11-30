package com.oryx.core.module;

import com.oryx.core.annotation.capable.IBundleCapable;
import com.oryx.core.bundle.tools.BundleExtractor;
import com.oryx.core.delegate.IDelegate;
import com.oryx.core.delegate.IDelegateKey;
import com.oryx.core.parameter.IClientParameterDefault;
import org.apache.log4j.Logger;

import javax.xml.ws.Service;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by SAMI on 13/03/2017.
 */
public abstract class AbstractServiceModule extends AbstractModule implements IServiceModule {
    final static Logger logger = Logger.getLogger(AbstractServiceModule.class);

    @Override
    public void bindService(Class<?> entityClass, Class<? extends IDelegate> delgateClass, Class<? extends Service> serviceClass) {
        if (this.getApplicationModule() == null) {
            this.setApplicationModule(this);
        }

        try {
            //"http://localhost:8680/oryx-server/AdressService.wsdl"
            String host = null; //CommonServiceHelper.getParameterService().getValue(IClientParameterNames.HOST);
            if (host == null || host.isEmpty()) host = IClientParameterDefault.HOST;
            String port = null; //CommonServiceHelper.getParameterService().getValue(IClientParameterNames.PORT);
            if (port == null || port.isEmpty()) port = IClientParameterDefault.PORT;
            String path = null; //CommonServiceHelper.getParameterService().getValue(IClientParameterNames.PATH);
            if (path == null || path.isEmpty()) path = IClientParameterDefault.PATH;

            StringBuilder urlStr = new StringBuilder("http://").append(host).append(":").append(port).append("/").append(path).append("/").append(serviceClass.getSimpleName().replace("Services", "Service.wsdl"));

            Service service = serviceClass.getConstructor(URL.class).newInstance(new URL(urlStr.toString()));

            IDelegate delegate = delgateClass.getDeclaredConstructor(Service.class).newInstance(service);
            bind(IDelegateKey.class, entityClass, delegate);

            String description = BundleExtractor.getStringValue(IBundleCapable.getBundleInterface(this), entityClass.getSimpleName());
            register(IDelegateKey.class, description, entityClass);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IDelegate getService(Class<?> entityClass) {
        return (IDelegate) getBoundObject(IDelegateKey.class, entityClass);
    }
}