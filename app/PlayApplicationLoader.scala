import _root_.controllers.AssetsComponents
import com.softwaremill.macwire._
import play.api.ApplicationLoader.Context
import play.api.i18n.I18nComponents
import play.api.mvc.EssentialFilter
import play.api._
import play.filters.HttpFiltersComponents
import play.filters.cors.CORSComponents
import play.api.routing.Router
import router.Routes

class PlayApplicationLoader extends ApplicationLoader {
  def load(context: Context): Application = new PlayComponents(context).application
}

class PlayComponents(context: Context) extends BuiltInComponentsFromContext(context)
  with AssetsComponents
  with I18nComponents
  with HttpFiltersComponents
  with CORSComponents
  with RootModule {

  LoggerConfigurator(context.environment.classLoader).foreach {
    _.configure(context.environment, context.initialConfiguration, Map.empty)
  }
  private val logger = Logger(this.getClass)
  logger.info("PlayApplicationLoader started.")

  override def httpFilters: Seq[EssentialFilter] = super.httpFilters :+ corsFilter

  lazy val router: Router = {
    // add the prefix string in local scope for the Routes constructor
    val prefix: String = "/"
    wire[Routes]
  }
}