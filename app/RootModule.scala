import controllers.RootController
import play.api.mvc.ControllerComponents

trait RootModule {
  import com.softwaremill.macwire._

  lazy val rootController: RootController = wire[RootController]

  def controllerComponents: ControllerComponents
}
