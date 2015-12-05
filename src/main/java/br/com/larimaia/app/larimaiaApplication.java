package br.com.larimaia.app;


import br.com.larimaia.rest.ClienteResource;
import br.com.larimaia.rest.PedidoResources;
import br.com.larimaia.rest.ProdutoResources;
import br.com.larimaia.rest.TipoEventoResources;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lucas on 23/09/2015.
 */
@ApplicationPath("/ws")
public class larimaiaApplication extends Application {
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(ClienteResource.class);
        classes.add(ProdutoResources.class);
        classes.add(TipoEventoResources.class);
        classes.add(PedidoResources.class);
        return classes;
    }
}
