package controllers

import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

class RootController(cc: ControllerComponents) extends AbstractController(cc) {
  def index: Action[AnyContent] = Action {
    Ok("Hello, world!")
  }
}
