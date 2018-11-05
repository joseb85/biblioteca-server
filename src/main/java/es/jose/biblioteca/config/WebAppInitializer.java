package es.jose.biblioteca.config;

import javax.servlet.Filter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Archivo de inicialización de la app
 * @since 28-oct-2018
 * @author joseb85
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**
     * The @Configuration classes returned from getServletConfigClasses() will
     * define beans for DispatcherServlet’s application context.
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebAppConfig.class};
    }
    
    
    /**
     * The @Configuration class’s returned getRootConfigClasses() will be used
     * to configure the application context created by ContextLoaderListener.
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{WebRepositoryConfig.class/*, WebSecurityConfig.class*/ };
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
