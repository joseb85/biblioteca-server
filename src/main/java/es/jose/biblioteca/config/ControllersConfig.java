package es.jose.biblioteca.config;

import javax.servlet.Filter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Se configura el acceso a los controladores de Spring
 * <p>
 * En Spring MVC existen dos contextos de aplicación:
 * <p>
 * DispatcherServlet carga beans que contengan web components como
 * controladores, view resolvers o handler mappings
 * <p>
 * ContextLoaderListener cargar el resto de beans
 * @since 28-oct-2018
 * @author joseb85
 */
public class ControllersConfig extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**
     * The @Configuration classes returned from getServletConfigClasses() will
     * define beans for DispatcherServlet’s application context.
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebMvcConfiguration.class};
    }
    
    
    /**
     * The @Configuration class’s returned getRootConfigClasses() will be used
     * to configure the application context created by ContextLoaderListener.
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{WebMvcConfiguration.class};
    }

    
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; //Con barra para que funcione en jBoss
    }

    @Override
    protected Filter[] getServletFilters() {
        Filter[] singleton = {new CORSFilter()};
        return singleton;
    }

//    @Override
//    protected void registerContextLoaderListener(ServletContext servletContext) {
////        super.registerContextLoaderListener( servletContext );
//        servletContext.setInitParameter("contextConfigLocation", "<NONE>");
////        servletContext.addListener( SessionListener.class );
//    }
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        return null;
//    }
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        super.onStartup(servletContext);
//        DelegatingFilterProxy filter = new DelegatingFilterProxy("springSecurityFilterChain");
//        filter.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
//        servletContext.addFilter("springSecurityFilterChain", filter).addMappingForUrlPatterns(null, false, "/*");
//    }
}
