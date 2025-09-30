package kt.config;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class JPAContextListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    JPAUtil.init();
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    JPAUtil.close();
  }
}
